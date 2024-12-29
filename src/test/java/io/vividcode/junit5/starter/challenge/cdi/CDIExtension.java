package io.vividcode.junit5.starter.challenge.cdi;

import jakarta.inject.Inject;
import java.util.Arrays;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.junit.platform.commons.util.AnnotationUtils;

public class CDIExtension implements BeforeAllCallback, AfterAllCallback,
    TestInstancePostProcessor {

  private static final Namespace NAMESPACE = Namespace.create(
      CDIExtension.class);

  @Override
  public void postProcessTestInstance(Object testInstance,
      ExtensionContext context) throws Exception {
    WeldContainer container = getWeldContainer(context);
    Arrays.stream(context.getRequiredTestClass().getDeclaredFields())
        .filter(field -> AnnotationUtils.isAnnotated(field, Inject.class))
        .forEach(field -> {
          try {
            field.set(testInstance, container.select(field.getType()).get());
          } catch (IllegalAccessException e) {
            System.err.printf("Failed to set field %s%n", field);
          }
        });
  }


  private static WeldContainer getWeldContainer(ExtensionContext context) {
    Class<?> testClass = context.getRequiredTestClass();
    Store store = getStore(context);
    return store.getOrComputeIfAbsent(testClass,
        clazz -> createWeldContainer(), WeldContainer.class);
  }

  private static Store getStore(ExtensionContext context) {
    return context.getRoot().getStore(NAMESPACE);
  }

  private static WeldContainer createWeldContainer() {
    Weld weld = new Weld().disableDiscovery().addBeanClass(UserService.class);
    return weld.initialize();
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    WeldContainer container = getWeldContainer(context);
    System.out.printf("Weld container %s started%n", container.getId());
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    getWeldContainer(context).shutdown();
  }
}

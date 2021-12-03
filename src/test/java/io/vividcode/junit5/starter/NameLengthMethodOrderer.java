package io.vividcode.junit5.starter;

import java.util.Comparator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;

public class NameLengthMethodOrderer implements MethodOrderer {

  @Override
  public void orderMethods(MethodOrdererContext context) {
    context.getMethodDescriptors().sort(Comparator.comparingInt(
        (descriptor) -> descriptor.getMethod().getName().length()));
  }
}

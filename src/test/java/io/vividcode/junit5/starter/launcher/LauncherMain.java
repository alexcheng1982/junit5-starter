package io.vividcode.junit5.starter.launcher;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import java.io.PrintWriter;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

public class LauncherMain {

  public static void main(String[] args) {
    LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
        .selectors(
            selectPackage("io.vividcode.junit5.starter.launcher")
        )
        .filters(
            includeClassNamePatterns(".*Tests")
        )
        .build();
    Launcher launcher = LauncherFactory.create();

    SummaryGeneratingListener listener = new SummaryGeneratingListener();
    launcher.registerTestExecutionListeners(listener);

    launcher.execute(request);
    listener.getSummary().printTo(new PrintWriter(System.out));
  }
}

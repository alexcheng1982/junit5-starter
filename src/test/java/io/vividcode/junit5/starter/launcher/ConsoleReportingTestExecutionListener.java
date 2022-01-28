package io.vividcode.junit5.starter.launcher;

import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

public class ConsoleReportingTestExecutionListener implements
    TestExecutionListener {

  @Override
  public void reportingEntryPublished(TestIdentifier testIdentifier,
      ReportEntry entry) {
    System.out.println(entry.getKeyValuePairs());
  }
}

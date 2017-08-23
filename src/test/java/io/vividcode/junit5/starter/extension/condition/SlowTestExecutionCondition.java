package io.vividcode.junit5.starter.extension.condition;

import java.util.Objects;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SlowTestExecutionCondition implements ExecutionCondition {

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(
      final ExtensionContext context) {
    if (Objects.isNull(System.getProperty("slow"))
        && context.getTags().contains("slow")) {
      return ConditionEvaluationResult
          .disabled("Slow tests are disabled unless -Dslow is set");
    }
    return ConditionEvaluationResult.enabled("enabled by default");
  }
}

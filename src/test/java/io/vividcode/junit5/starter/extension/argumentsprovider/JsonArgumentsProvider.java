package io.vividcode.junit5.starter.extension.argumentsprovider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.PreconditionViolationException;

public class JsonArgumentsProvider implements ArgumentsProvider {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public Stream<? extends Arguments> provideArguments(
      final ExtensionContext context)
      throws Exception {
    return AnnotationUtils
        .findAnnotation(context.getElement(), JsonFileSource.class)
        .map(JsonFileSource::value)
        .map(resource -> {
          try (final InputStream inputStream = context.getRequiredTestClass()
              .getResourceAsStream(resource)) {
            final List<Map<String, Object>> values = this.objectMapper
                .readValue(inputStream,
                    new TypeReference<List<Map<String, Object>>>() {
                    });
            final List<String> properties = Stream
                .of(context.getRequiredTestMethod().getParameters())
                .map(parameter -> AnnotationUtils
                    .findAnnotation(parameter, JsonProperty.class)
                    .map(JsonProperty::value)
                    .orElse(null))
                .collect(Collectors.toList());
            final Stream<Arguments> arguments = values.stream()
                .map(data -> Arguments.of(
                    properties.stream().map(property ->
                        Objects.isNull(property)
                            ? null
                            : data.get(property)).toArray()));
            return arguments;
          } catch (final IOException e) {
            throw new PreconditionViolationException("Invalid JSON file", e);
          }
        })
        .orElseThrow(() ->
            new PreconditionViolationException("@JsonFileSource must exist!"));
  }
}

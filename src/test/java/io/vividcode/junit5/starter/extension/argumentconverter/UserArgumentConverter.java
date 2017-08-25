package io.vividcode.junit5.starter.extension.argumentconverter;

import java.util.Objects;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class UserArgumentConverter implements ArgumentConverter {

  private final UserService userService = new UserService();

  @Override
  public Object convert(final Object source, final ParameterContext context)
      throws ArgumentConversionException {
    if (Objects.equals(context.getParameter().getType(), User.class)) {
      return this.userService.findUser(Objects.toString(source));
    }
    return source;
  }
}

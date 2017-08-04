package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.MultipleFailuresError;

@DisplayName("Examples of assertThrows")
public class AssertThrowsExample {

	@Test
	@DisplayName("Simple assertThrows")
	void simpleAssertThrows() {
		assertThrows(
				ArithmeticException.class,
				() -> System.out.println(1 / 0)
				, "Divided by zero is not allowed.");
	}

	@Test
	@DisplayName("Check thrown exception")
	void checkThrownException() {
		final MultipleFailuresError error = assertThrows(
				MultipleFailuresError.class,
				() -> assertAll(
						"Boom!",
						() -> assertTrue(false)
				)
		);
		assertEquals(1, error.getFailures().size());
		assertTrue(error.getMessage().contains("Boom!"));
	}
}

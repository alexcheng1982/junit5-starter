package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Example of assertAll")
public class AssertAllExample {

	@Test
	@DisplayName("Simple assertAll")
	public void simpleAssertAll() {
		assertAll(
				() -> assertTrue(true),
				() -> assertEquals(1, 1)
		);
		assertAll(
				Stream.of(
						() -> assertTrue(true),
						() -> assertEquals(1, 1)
				)
		);
	}

	@Test
	public void failedAssertAll() {
		assertAll(
				() -> assertTrue(false),
				() -> assertEquals(1, 2)
		);
	}
}

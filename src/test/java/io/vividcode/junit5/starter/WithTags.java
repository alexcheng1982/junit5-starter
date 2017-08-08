package io.vividcode.junit5.starter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WithTags {

	@Test
	@DisplayName("normal test")
	void normalTest() {

	}

	@Test
	@DisplayName("slow test")
	@Slow
	void slowTest() {

	}
}

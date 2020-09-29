package programs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

public class AssumptionDemo {

	@Test
	void trueAssumption() {
		assumeTrue(5>1);
		assertEquals(5+2, 7);
	}
	
	@Test
	void falseAssumption() {
		assumeFalse(5<1);
		assertEquals(5+2, 7);
	}
	
	@Test
	void assumptionThat() {
		String s = "Just a string";
		assumingThat(s.equals("Just a string"), () -> assertEquals(2+2, 4));
	}
}

// @Test, @ParameterizedTest, @RepeatedTest, @TestFactory, @TestTemplate, @TestMethodOrder
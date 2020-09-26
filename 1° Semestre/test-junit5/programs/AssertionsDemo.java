package programs;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AssertionsDemo {

	@Test
	void standardAssertions() {
		int a=2;
		
		assertEquals(3, 3, "It's done");
		assertTrue(2==a, () -> "It's done again");
	
		int[] numbers = { 0, 1, 2, 3, 4 };
		
		assertAll("numbers", 
			() -> assertEquals(numbers[0], 0),
			() -> assertEquals(numbers[3], 3),
			() -> assertEquals(numbers[4], 4)
		);
	}
	
	@Test
	void exceptionTesting() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			throw new IllegalArgumentException("a error message");
		});
		
		assertEquals("a error message", exception.getMessage());
		
		assertThrows(ArithmeticException.class, () -> {
			int b= 5 / 0;
			System.out.println(b);
		});
	}
}

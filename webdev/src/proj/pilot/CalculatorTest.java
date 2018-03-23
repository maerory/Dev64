package proj.pilot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	static Calculator c = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before!");
		c = new Calculator();
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("after");
		c = null;
	}

	@Test
	void testAdd() {
		System.out.println("TestAdd");
		assertEquals(667, c.add(600, 67));
	}

	@Test
	void testSub() {
		assertEquals(667, c.sub(670, 3));
	}

	@Test
	void testMul() {
		assertEquals(6, c.mul(2, 3));
	}

	@Test
	void testDiv() {
		assertEquals(2, c.div(6, 3));
	}

	@Test
	void testMod() {
		assertEquals(1, c.mod(3, 2));
	}

}

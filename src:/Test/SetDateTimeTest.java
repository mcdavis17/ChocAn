package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import project4.SetDateTime;
// author: Calvin Clark
// testing author code: Richard Anthony - SetDateTime.java
public class SetDateTimeTest {
	SetDateTime dt;
	
	@Before
	public void setUp() throws Exception {
		dt = new SetDateTime();
		dt.setDayOfMonth(15);
		dt.setMonth(9);
		dt.setYear(2018);
	}

	@Test
	public void evaluateGetMonth() {
		assertEquals(9, dt.getMonth());
	}

	@Test(expected = NumberFormatException.class)
	public void testSetMonth() {
		dt.setMonth(14);
	}

	@Test
	public void testSanity() {
		dt.setYear(dt.getYear());
		assertEquals(2018, dt.getYear());
	}

}


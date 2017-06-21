import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

public class junitObjectTests {

	//This test will use the assertEquals test to see if the two are equal.
	@Test
	public void testAddition() {
		junitObject test = new junitObject();
		int result = test.twoElementAddition(30, 20);
		assertEquals(50, result);
	}

	//This test will use the assertEquals test to see if the two are equal.
	@Test
	public void testSqaure() {
		junitObject test = new junitObject();
		int result = test.square(10);
		assertEquals(45, result);
	}

	//This test will use assertArrayEquals to verify arrays of expected and results.
	@Test
	public void testArray(){
		junitObject test = new junitObject();
		int[] value = {10,20,30,40};
		int[] expected = {100,400,900,1600};
		int[] result = new int[4];
		for(int i = 0; i<value.length;i++){
			result[i] = test.square(value[i]);
		}
		assertArrayEquals(expected,result);
	}
	
	//This test will use assertTrue to test the result of square().
	@Test
	public void testTrue(){
		junitObject test = new junitObject();
		int result = test.square(10);
		assertTrue(100 == result);
	}
	
	//This test will use assertFalse to test the result of square().
	@Test
	public void testFalse(){
		junitObject test = new junitObject();
		int result = test.square(10);
		assertFalse(100 != result);
	}
	
	//Use the assertNull to test if the result is null.
	@Test
	public void testNull(){
		junitObject test = new junitObject();
		String result = test.nullName("Peter");
		assertNull(result);
	}
	
	//Use the assertNotNull to test if the result is not null.
	@Test
	public void testNotNull(){
		junitObject test = new junitObject();
		String result = test.nullName("Louise");
		assertNotNull(result);
	}
	
	//This test uses assertSame to test if two objects are actually the same one.
	@Test
	public void testSameObject(){
		junitObject test = new junitObject();
		Object testObj = new junitObject();
		Object result = test.returnSameObject(testObj);
		assertSame(testObj, result);
	}
	
	//This test uses assertNotSame to test if two objects are not the same one.
	@Test
	public void testNotSameObject(){
		junitObject test = new junitObject();
		Object testObj = new junitObject();
		Object result = test.returnSameObject(new junitObject());
		assertNotSame(testObj, result);
	}
	
	//fail() will just fail the test with a message.
	@Test
	public void failTest(){
		fail("Fail test causes a fail.");
	}
	
	// @Ignore means it will Ignore the next test.
	@Ignore
	@Test
	public void testSqaure2() {
		junitObject test = new junitObject();
		int result = test.square(10);
		assertEquals(100, result);
	}

	// This test will fail in the given time (.01 seconds)
	@Test(timeout = 10)
	public void testPrintMessage() {
		junitObject test = new junitObject();
		test.printMessageByTimes(1000000);
	}

	// This test will pass in the given time (.02 seconds)
	@Test(timeout = 20)
	public void testPrintMessage2() {
		junitObject test = new junitObject();
		test.printMessageByTimes(1);
	}

}
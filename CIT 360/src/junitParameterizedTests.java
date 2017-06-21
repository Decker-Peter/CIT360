import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

 // Parameter test with 5 groups of numbers to test square() the 3rd group of numbers will fail because the result should be 16
 
@RunWith(Parameterized.class)
public class junitParameterizedTests {
	private int sInput;
	private int sExpected;
	private junitObject test;

	@Before
	public void initialize() {
		test = new junitObject();
	}

	@Parameters
	public static Collection<Object[]> numbers() {
		return Arrays.asList(new Object[][] { { 2, 4 }, { 3, 9 }, { 4, 20 }, { 5, 25 }, { 6, 36 } });
	}

	public junitParameterizedTests(int input, int expected) {
		sInput = input;
		sExpected = expected;
	}

	@Test
	public void test() {
		assertEquals(sExpected, test.square(sInput));
	}

}
import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectedComponentTest {

	@Test
	public void findComponentCountTest() {
		String testString = " X ";
		String[] testArray = {testString};
		ConnectedComponents cc = new ConnectedComponents();
		//assertEquals(1, cc.findComponentCount(testArray));
		String testString2 = "  ";
		String[] testArray2 = new String[3];
		//assertEquals(-1, cc.findComponentCount(testArray2));
		testString2 = "  X";
		testArray2[1] = testString2;
		//assertEquals(2, cc.findComponentCount(testArray2));
		testArray2[0] = testString;
		testArray2[1] = " X ";
		testArray2[2] = " X ";
		assertEquals(1, cc.findComponentCount(testArray2));
	}

}

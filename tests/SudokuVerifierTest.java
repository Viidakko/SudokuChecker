import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", 0, a);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("Did not pick-up repeating character from subgrid", -2, a);
	}
	
	@Test
	public void testRepeatingNumbersInRow() {
		String incorrectRows = "417369824632158957958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(incorrectRows);
		assertEquals("Did not find incorrect row", -3, a);
	}
	@Test
	public void testRepeatingNumbersInColumn() {
		String incorrectRows = ""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "614875293";
		int a = v.verify(incorrectRows);
		assertEquals("Did not find incorrect row", -4, a);
	}
	
	@Test
	public void testNotANumber() {
		String notANumber = "hie369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(notANumber);
		assertEquals("Did not pick up characters that are not numbers", 1, a);
	}
	@Test
	public void testZero() {
		String thereIsAZero = "410369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(thereIsAZero);
		assertEquals("Did not pick up characters that are not numbers", -1, a);
	}
}

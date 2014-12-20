package it.reti.futureti.testkata;

import it.reti.futureti.testkata.exceptions.ProgramException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProgramTests {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	 
	@Test
	public void testAddNull() throws ProgramException {
        // arrange
        String input = null;
        int expectedResult = 0;

        // act
        Program program = new Program();
        int result = program.Add(input);

        // assert
        Assert.assertEquals(expectedResult, result);
    }
	
	@Test
	public void testAddEmptyString() throws ProgramException {
        // arrange
        String input = "";
        int expectedResult = 0;

        // act
        Program program = new Program();
        int result = program.Add(input);

        // assert
        Assert.assertEquals(expectedResult, result);
    }
	
	@Test
	public void testAddOneNumber() throws ProgramException {
        // arrange
        String input = "5";
        int expectedResult = 5;

        // act
        Program program = new Program();
        int result = program.Add(input);

        // assert
        Assert.assertEquals(expectedResult, result);
    }
	
	@Test
	public void testAddTwoNumbers() throws ProgramException {
        // arrange
        String input = "5,7";
        int expectedResult = 12;

        // act
        Program program = new Program();
        int result = program.Add(input);

        // assert
        Assert.assertEquals(expectedResult, result);
    }
	
	@Test
	public void testAddManyNumbers() throws ProgramException {
        // arrange
		String input = "5,7,1,2,3,4,5";
        int expectedResult = 27;

        // act
        Program program = new Program();
        int result = program.Add(input);

        // assert
        Assert.assertEquals(expectedResult, result);
    }
	
	@Test
	public void testAddNewLineSplitter() throws ProgramException {
        // arrange
		String input = "1\n2,3";
        int expectedResult = 6;

        // act
        Program program = new Program();
        int result = program.Add(input);

        // assert
        Assert.assertEquals(expectedResult, result);
    }
	
	@Test(expected=ProgramException.class)
	public void testAddWrongInput() throws ProgramException {
        // arrange
		String input = "1,\n";

        // act
        Program program = new Program();
        program.Add(input);

        // assert
    }
	
	@Test
	public void testAddFirstNegative() throws ProgramException {
        // arrange
		String input = "-1,2";

        // act
        Program program = new Program();
        thrown.expect(ProgramException.class);
        thrown.expectMessage("Negatives not allowed.");
        program.Add(input);

        // assert
    }

	@Test
	public void testAddNegative() throws ProgramException {
        // arrange
		String input = "1,-1,2";

        // act
        Program program = new Program();
        thrown.expect(ProgramException.class);
        thrown.expectMessage("Negatives not allowed.");
        program.Add(input);

        // assert
    }
	
	@Test
	public void testAddCustomDelimeter() throws ProgramException {
        // arrange
        String input = ";\n1;2";
        int expectedResult = 3;

        // act
        Program program = new Program();
        int result = program.Add(input);

        // assert
        Assert.assertEquals(expectedResult, result);
    }

}

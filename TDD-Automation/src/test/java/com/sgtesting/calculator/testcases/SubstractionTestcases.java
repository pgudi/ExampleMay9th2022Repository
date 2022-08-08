package com.sgtesting.calculator.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgtesting.calculator.sourcecode.Calculator;

public class SubstractionTestcases {
	
	Calculator calculator=new Calculator();
	/**
	 * Created By:
	 * Description:
	 */
	@Test
	public void substractTwoPositiveNumbers()
	{
		int expected,actual;
		try
		{
			expected=60;
			actual=calculator.Subtraction(100,40);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Description:
	 */
	@Test
	public void substractTwoNegativeNumbers()
	{
		int expected,actual;
		try
		{
			expected=-21;
			actual=calculator.Subtraction(-25,-4);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Description:
	 */
	@Test
	public void substractPositiveAndNegativeNumbers()
	{
		int expected,actual;
		try
		{
			expected=53;
			actual=calculator.Subtraction(50,-3);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Created By:
	 * Description:
	 */
	@Test
	public void substractPositiveAndZeroNumbers()
	{
		int expected,actual;
		try
		{
			expected=40;
			actual=calculator.Subtraction(40,0);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

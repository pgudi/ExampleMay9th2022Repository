package com.sgtesting.calculator.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgtesting.calculator.sourcecode.Calculator;


public class MultiplicationTestcases {
	
	Calculator calculator=new Calculator();
	/**
	 * Created By:
	 * Description:
	 */
	@Test
	public void multiplyTwoPositiveNumbers()
	{
		int expected,actual;
		try
		{
			expected=70;
			actual=calculator.multiplication(10,7);
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
	public void multiplyTwoNegativeNumbers()
	{
		int expected,actual;
		try
		{
			expected=52;
			actual=calculator.multiplication(-13,-4);
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
	public void multiplyPositiveAndNegativeNumbers()
	{
		int expected,actual;
		try
		{
			expected=-90;
			actual=calculator.multiplication(30,-3);
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
	public void multiplyPositiveAndZeroNumbers()
	{
		int expected,actual;
		try
		{
			expected=0;
			actual=calculator.multiplication(30,0);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

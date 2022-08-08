package com.sgtesting.calculator.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgtesting.calculator.sourcecode.Calculator;

public class AdditionTestcases {
	
	Calculator calculator=new Calculator();
	/**
	 * Created By:
	 * Description:
	 */
	@Test
	public void addTwoPositiveNumbers()
	{
		int expected,actual;
		try
		{
			expected=70;
			actual=calculator.addition(30,40);
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
	public void addTwoNegativeNumbers()
	{
		int expected,actual;
		try
		{
			expected=-17;
			actual=calculator.addition(-13,-4);
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
	public void addPositiveAndNegativeNumbers()
	{
		int expected,actual;
		try
		{
			expected=27;
			actual=calculator.addition(30,-3);
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
	public void addPositiveAndZeroNumbers()
	{
		int expected,actual;
		try
		{
			expected=30;
			actual=calculator.addition(30,0);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

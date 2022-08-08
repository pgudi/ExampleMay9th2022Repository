package com.sgtesting.calculator.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgtesting.calculator.sourcecode.Calculator;

public class DivisionTestcases {
	
	Calculator calculator=new Calculator();
	/**
	 * Created By:
	 * Description:
	 */
	@Test
	public void divideTwoPositiveNumbers()
	{
		int expected,actual;
		try
		{
			expected=3;
			actual=calculator.division(120,40);
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
	public void divideTwoNegativeNumbers()
	{
		int expected,actual;
		try
		{
			expected=5;
			actual=calculator.division(-25,-5);
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
	public void devidePositiveAndNegativeNumbers()
	{
		int expected,actual;
		try
		{
			expected=-10;
			actual=calculator.division(30,-3);
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
	public void addPositiveAndOneNumbers()
	{
		int expected,actual;
		try
		{
			expected=45;
			actual=calculator.division(45,1);
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

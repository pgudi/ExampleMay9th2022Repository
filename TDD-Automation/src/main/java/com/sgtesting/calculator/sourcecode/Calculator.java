package com.sgtesting.calculator.sourcecode;

public class Calculator {
	/**
	 * Author:
	 * parmas:
	 * Purpose:
	 * Description:
	 */
	public int multiplication(int num1,int num2)
	{
		int result=0;
		try
		{
			result=(num1*num2);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Author:
	 * parmas:
	 * Purpose:
	 * Description:
	 */
	public int Subtraction(int num1,int num2)
	{
		int result=0;
		try
		{
			result=(num1-num2);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Author:
	 * parmas:
	 * Purpose:
	 * Description:
	 */
	public int division(int num1,int num2)
	{
		int result=0;
		try
		{
			result=(num1/num2);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Author:
	 * parmas:
	 * Purpose:
	 * Description:
	 */
	public int addition(int num1,int num2)
	{
		int result=0;
		try
		{
			result=(num1+num2);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

}

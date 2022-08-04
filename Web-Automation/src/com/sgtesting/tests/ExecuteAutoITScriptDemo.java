package com.sgtesting.tests;

public class ExecuteAutoITScriptDemo {

	public static void main(String[] args) {
		executeFile();

	}
	
	private static void executeFile()
	{
		try
		{
			String fileName="E:\\ExampleAutomation1\\AutoIT\\ThirdAutiItToSaveFile.exe";
	//		Runtime.getRuntime().exec(fileName);
			Runtime obj=Runtime.getRuntime();
			obj.exec(fileName);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

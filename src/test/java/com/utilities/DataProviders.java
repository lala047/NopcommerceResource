package com.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path=(System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\LoginData.xlsx");
		int totalrows=XLUtils.getRowCount(path, "Sheet1");   //4
		int totalcols=XLUtils.getCellCount(path, "Sheet1", 1); //3
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path, "Sheet1",i, j);  //1,0
			}
		}
		
		return logindata;
	}
	


}

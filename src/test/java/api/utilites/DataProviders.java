package api.utilites;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="AllData")
	public String [][] AllDataProvider(){
		
		
		String fname = System.getProperty("user.dir") + "//TestData//TestData.xlsx";
		
		int ttlRowCnt = ReadExcelFile.getRowCount(fname, "Sheet1");
		int ttlColCnt = ReadExcelFile.getColCount(fname, "Sheet1");
		
		String userData[][] = new String[ttlRowCnt-1][ttlColCnt];
		
		for (int rowNo = 1;rowNo<ttlRowCnt;rowNo++)
		{
			for(int colNo = 0;colNo<ttlColCnt;colNo++)
			{
				
				
				userData[rowNo-1][colNo] = ReadExcelFile.getCellValue(fname, "Sheet1", rowNo, colNo);
			}
			
					
		}
		
		return userData;
	}
	
	
	@DataProvider(name="UserNameData")
	public String [] UserNameDataProvider(){
		
		
		String fname = System.getProperty("user.dir") + "//TestData//UserData.xlsx";
		
		int ttlRowCnt = ReadExcelFile.getRowCount(fname, "Sheet1");
		int ttlColCnt = ReadExcelFile.getColCount(fname, "Sheet1");
		
		String userNamesData[] = new String[ttlRowCnt-1];
		
		for (int rowNo = 1;rowNo<ttlRowCnt;rowNo++)
		{
			
				
			userNamesData[rowNo-1] = ReadExcelFile.getCellValue(fname, "Sheet1", rowNo, 1);
			
			
					
		}
		
		return userNamesData;
	}
	
}

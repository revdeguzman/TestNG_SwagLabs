package file.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadExcel {
	
    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws EncryptedDocumentException, IOException {
        return ReadExcelData("Sheet1"); // Replace with your actual sheet name
    }
	
	public String[][] ReadExcelData (String excelSheetName) throws EncryptedDocumentException, IOException {
		
		//Create object and Locate the Excel File
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\test_data\\Test Data.xlsx");
		
		//Read the Data from Excel File
		FileInputStream fileInput = new FileInputStream(excelFile);
		
		//Allow to support .xlsx and .xls formats (Excel)
		Workbook wbook = WorkbookFactory.create(fileInput);
		
		//Access the specific Sheet Name from the Excel
		Sheet sheetName = wbook.getSheet(excelSheetName);
		
		//Store the total rows from Excel
		int totalRows = sheetName.getLastRowNum();
		
		//Print total Rows
		System.out.println("Total Rows is: " + totalRows);
		
		//Get the column count from Excel
		Row rowCells = sheetName.getRow(0);
		
		//Store the total column from Excel
		int totalCols = rowCells.getLastCellNum();
		
		//Print total Column
		System.out.println("Total Columns: " + totalCols);
		
		//Format the Data get from Excel
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String[totalRows][totalCols];
		
		//Data Driven - Read Data from Rows
		for (int i = 1; i <= totalRows; i++) {
			
			//Data Driven - Read Data from Columns
			for (int j = 0; j < totalCols; j++) {
				
				//Format the Data get from Excel
				testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);

			}
			
		}
	
	//Close the Files
	fileInput.close();
	wbook.close();
		
	//Return the Data	
	return testData;
		
	}

}

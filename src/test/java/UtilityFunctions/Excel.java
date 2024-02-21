package UtilityFunctions;

import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseTest.BaseTest;

public class Excel extends BaseTest {
	/*All excel related stuff */ 

	public String projectPath;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;

	public Excel(String excelFileName) {
		this.projectPath = System.getProperty("user.dir") + File.separator+"dataProviders"+File.separator;
//		this.projectPath = "C:\\Users\\obint\\eclipse-workspace\\nopcart\\dataProviders\\";

		String workbookLocation = this.projectPath + excelFileName + ".xlsx";
		System.out.println("workbookLocation = " + workbookLocation);

		try {
			workbook = new XSSFWorkbook(workbookLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheet("Sheet1");

		System.out.println("DEBUG: sheet.toString() = " + sheet.toString());

	}

	public int getRowCount() {

		int rowCount = sheet.getPhysicalNumberOfRows();

		return rowCount;

	}

	public int getColCount() {

		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		return colCount;

	}

	public String getCellData_String(int row, int col) {
		String cellData = null;

		try {
			cellData = sheet.getRow(row).getCell(col).getStringCellValue();
		} catch (IllegalStateException e) {
//			System.out.println("row = " + row + ", col = " + col);
		}

		return cellData;

	}

	public double getCellData_Numeric(int row, int col) {

		double cellData = sheet.getRow(row).getCell(col).getNumericCellValue();

		return cellData;

	}

}

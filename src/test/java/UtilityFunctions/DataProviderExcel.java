package UtilityFunctions;

import BaseTest.BaseTest;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderExcel {
	


	@DataProvider(name = "billingInfo")
	public Object[][] billingAddressData() {

		Object[][] data = testData();

		return data;

	}

	public Object[][] testData() {
		Excel excel = new Excel("billingAddress");

		int row = excel.getRowCount();
		int col = excel.getColCount();

		Object data[][] = new Object[row - 1][col];

		for (int i = 1; i < row; i++) {

			for (int j = 0; j < col; j++) {

				String cellData = excel.getCellData_String(i, j);

				if (cellData == null) {

					double temp = excel.getCellData_Numeric(i, j);

					cellData = (int) Math.floor(temp) + "";
				}

				data[i - 1][j] = cellData;

//				System.out.println("data added to 2 dimensional array = " + data[i - 1][j]);

			}

		}

		return data;

	}

}

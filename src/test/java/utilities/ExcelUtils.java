package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;
	private static DataFormatter formatter = new DataFormatter();

	public static Object[][] getTableArray(String filePath, String sheetName, String methodName) throws Exception {
		Object[][] tabArray = null;
		try {
			FileInputStream excelFile = new FileInputStream(filePath);
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet(sheetName);
			row = excelWSheet.getRow(0);
			int totalRows = excelWSheet.getPhysicalNumberOfRows();
			int totalCols = row.getLastCellNum();
			tabArray = new Object[totalRows - 1][totalCols - 1];
			for (int i = 0; i < totalRows - 1; i++) {
				if (excelWSheet.getRow(i + 1).getCell(0).getStringCellValue().equals(methodName)) {
					XSSFRow row = excelWSheet.getRow(i + 1);
					for (int j = 0; j < totalCols - 1; j++) {
						if (row == null)
							tabArray[i][j] = "";
						else {
							XSSFCell cell = row.getCell(j + 1);
							if (cell == null)
								tabArray[i][j] = "";
							else {
								String value = formatter.formatCellValue(cell);
								tabArray[i][j] = value;
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);
	}

}

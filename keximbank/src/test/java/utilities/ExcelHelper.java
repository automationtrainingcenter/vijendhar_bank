package utilities;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import in.srssprojects.keximbank.BaseClass;

public class ExcelHelper {

	HSSFWorkbook book;
	HSSFSheet sheet;

//	set an excel file to read data
	public void setExcelToRead(String folderName, String fileName, String sheetName) {
		try {
			book = new HSSFWorkbook(new FileInputStream(BaseClass.getFilePath(folderName, fileName)));
			sheet = book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	get the number of rows
	public int getRowCount() {
		return sheet.getLastRowNum()+1;
	}

//	get the number of columns
	public int getColumnCount() {
		return sheet.getRow(0).getLastCellNum();
	}

//	read the data from a cell
	public String readCellData(int rNum, int cNum) {
		String data = "";
		Cell cell = sheet.getRow(rNum).getCell(cNum);
		CellType cellTypeEnum = cell.getCellTypeEnum();
		switch (cellTypeEnum) {
		case NUMERIC:
			data = Integer.toString((int) cell.getNumericCellValue());
			break;
		case STRING:
			data = cell.getStringCellValue();
			break;
		default:
			data = "";
		}
		return data;
	}

//	get complete excel data into a 2D object array for DataProvider annotation
	public Object[][] getExcelData(String folderName, String fileName, String sheetName) {
		this.setExcelToRead(folderName, fileName, sheetName);
		int nor = this.getRowCount();
		int noc = this.getColumnCount();
		System.out.println(nor+"\t"+noc);
		String[][] data = new String[nor-1][noc];
		for (int r = 1; r < nor; r++) {
			for (int c = 0; c < noc; c++) {
				data[r-1][c] = this.readCellData(r, c);
			}
		}
		return data;

	}

}

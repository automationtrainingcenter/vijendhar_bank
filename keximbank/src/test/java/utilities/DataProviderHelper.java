package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderHelper {
	ExcelHelper excel = new ExcelHelper();
	
	@DataProvider(name = "branch_data")
	public Object[][] brancesData(){
		return excel.getExcelData("resources", "testdata.xls", "branchdata");
	}

	@DataProvider(name = "role_data")
	public Object[][] rolesData(){
		return excel.getExcelData("resources", "testdata.xls", "roledata");
	}
}

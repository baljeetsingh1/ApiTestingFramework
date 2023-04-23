package utilities;

import io.cucumber.java.ja.然し;

import java.io.IOException;

public class  DataProviders {
    public String[][] getAllData() throws IOException {
        String path = System.getProperty("user.dir") + "//testuserdata.xlsx";
        XLUtility xl = new XLUtility(path);

        int rownum = xl.getRowCount("Sheet1");
        int colcount = xl.getCellCount("sheet1", 1);

        String apidata[][] = new String[rownum][colcount];
        for (int i = 1; i < rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                apidata[i - 1][j] = xl.getCellData("Sheet1", i, j);

            }

        }
        return apidata;
    }

}
















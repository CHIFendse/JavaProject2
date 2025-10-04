package task_n2;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.sql.*;

public class Excel2 {

    public static void ExportToExcel(String tableName) throws Exception {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "CHIFendse", "CHIFendse");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName)) {

            Workbook workbook = new XSSFWorkbook();
            String sheetName = tableName.length() > 31 ? tableName.substring(0, 31) : tableName;
            Sheet sheet = workbook.createSheet(sheetName);


            Row headerRow = sheet.createRow(0);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                headerRow.createCell(i - 1).setCellValue(metaData.getColumnName(i));
            }


            int rowNum = 1;
            while (rs.next()) {
                Row row = sheet.createRow(rowNum++);
                for (int i = 1; i <= columnCount; i++) {
                    row.createCell(i - 1).setCellValue(rs.getString(i));
                }
            }


            for (int i = 0; i < columnCount; i++) {
                sheet.autoSizeColumn(i);
            }


            String filePath = "C:\\Excels\\" + tableName + ".xlsx";
            try (FileOutputStream out = new FileOutputStream(filePath)) {
                workbook.write(out);
            }
            workbook.close();

            System.out.println("Таблица '" + tableName + "' успешно экспортирована в: " + filePath);
        }catch(Exception e){
            System.out.println("");
        }
    }
}

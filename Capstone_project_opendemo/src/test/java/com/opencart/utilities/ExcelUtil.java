package com.opencart.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    // Updated Excel path
    private static final String EXCEL_PATH = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";

    /**
     * Returns a single row as Map<String,String>
     * rowIndex = 1 → first data row after header
     */
    public static Map<String, String> getRegisterData(int rowIndex) {
        Map<String, String> dataMap = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(EXCEL_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // First sheet
            Row headerRow = sheet.getRow(0);      // Header
            Row dataRow = sheet.getRow(rowIndex); // Data row

            if (dataRow == null) {
                throw new RuntimeException("❌ Row " + rowIndex + " is empty in Excel file");
            }

            int cols = headerRow.getLastCellNum();

            for (int i = 0; i < cols; i++) {
                Cell headerCell = headerRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                Cell valueCell = dataRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                String key = headerCell.getStringCellValue().trim().toLowerCase();
                String value;

                if (valueCell.getCellType() == CellType.STRING) {
                    value = valueCell.getStringCellValue();
                } else if (valueCell.getCellType() == CellType.NUMERIC) {
                    value = String.valueOf((long) valueCell.getNumericCellValue()); // convert numbers
                } else {
                    value = "";
                }

                dataMap.put(key, value.trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Excel file not found at: " + EXCEL_PATH);
        }

        System.out.println("✅ Excel Data Loaded for row " + rowIndex + ": " + dataMap);
        return dataMap;
    }

    /**
     * Returns all rows as Object[][] of Map<String, String>
     * Useful for DataProvider
     */
    public static Object[][] getTestDataAsMap(String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(EXCEL_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows - 1][1]; // return as Map

        // Read headers
        Row headerRow = sheet.getRow(0);
        String[] headers = new String[cols];
        for (int j = 0; j < cols; j++) {
            headers[j] = headerRow.getCell(j).getStringCellValue().trim().toLowerCase();
        }

        // Read each row
        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            Map<String, String> rowData = new HashMap<>();
            for (int j = 0; j < cols; j++) {
                Cell cell = (row == null) ? null : row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                String value = (cell == null) ? "" : cell.toString();
                rowData.put(headers[j], value.trim());
            }
            data[i - 1][0] = rowData;
        }

        workbook.close();
        fis.close();
        return data;
    }
}

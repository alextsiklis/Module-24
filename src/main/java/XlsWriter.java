import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class XlsWriter {
    public static void createTable(List<Statistics> stats, String name) throws IOException {
        Date date = new Date();
        String filename = String.format("%s_%tF.xls", name, date);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(name);
        int rowNum = 0;
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Профиль");
        row.createCell(1).setCellValue("Количество студентов");
        row.createCell(2).setCellValue("Название университета");
        row.createCell(3).setCellValue("Средний балл");

        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short)12);
        style.setFont(font);
        style.setWrapText(true);

        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            sheet.autoSizeColumn(i);
            row.getCell(i).setCellStyle(style);
        }

        for (Statistics stat : stats) {
            fill(sheet, ++rowNum, stat);
        }

        File file = new File(String.format("XLSFiles/%s", filename));
        try (FileOutputStream fileOut = new FileOutputStream(file)) {
            workbook.write(fileOut);
        }
}

    public static void fill(HSSFSheet sheet, int rowNum, Statistics stat) {
        double scale = Math.pow(10, 2);
        double result = Math.ceil(stat.getAvgExamScore()* scale) / scale;

        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue(stat.getStudyProfile().getTitle());
        row.createCell(1).setCellValue(stat.getStuCount());
        row.createCell(2).setCellValue(stat.getUniversityName());
        row.createCell(3).setCellValue(result);
    }
}
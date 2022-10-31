/**
 * @author liyouxiu
 * @date 2022/10/26 16:40
 */

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 使用Apache-poi生成Excel文件
 */
public class TestPOI {
    public static void main(String[] args) {
        //创建对象
        HSSFWorkbook wb=new HSSFWorkbook();
        //创建页
        HSSFSheet sheet = wb.createSheet("学生列表");
        //创建行
        HSSFRow row = sheet.createRow(0);//行号，从0开始依次增加
        //创建列
        HSSFCell cell = row.createCell(0);//列号，从0开始
        cell.setCellValue("学号");

    }
}

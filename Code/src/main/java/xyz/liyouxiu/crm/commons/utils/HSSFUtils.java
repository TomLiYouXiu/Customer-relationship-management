package xyz.liyouxiu.crm.commons.utils;

/**
 * @author liyouxiu
 * @date 2022/10/29 16:46
 */

import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 * 关于Excel文件操作的方法
 */
public class HSSFUtils {
    /**
     * 从指定的HSSFCell对象获取列的值
     */
    public static String getCellValueForStr(HSSFCell cell) {
        String ret="";
        if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
            ret=cell.getStringCellValue();
        }else if(cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
            ret=cell.getNumericCellValue()+" ";
        }else if(cell.getCellType()==HSSFCell.CELL_TYPE_BOOLEAN){
            ret=cell.getBooleanCellValue()+" ";
        }else if(cell.getCellType()==HSSFCell.CELL_TYPE_FORMULA){
            ret=cell.getCellFormula()+" ";
        }else{
            ret="";
        }
        return ret;
    }
}

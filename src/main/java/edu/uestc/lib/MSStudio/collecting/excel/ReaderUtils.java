package edu.uestc.lib.MSStudio.collecting.excel;

import org.apache.poi.ss.usermodel.Cell;

public class ReaderUtils {
	public static String getCellContent(Cell cell){
		switch (cell.getCellType()){
			case Cell.CELL_TYPE_BLANK: return null;
			case Cell.CELL_TYPE_BOOLEAN:return String.valueOf(cell.getBooleanCellValue());
			case Cell.CELL_TYPE_ERROR: return null;
			case Cell.CELL_TYPE_FORMULA: return null;
			case Cell.CELL_TYPE_NUMERIC:return String.valueOf(cell.getNumericCellValue());
			case Cell.CELL_TYPE_STRING:return cell.getStringCellValue();
		}
		return null;
	}
	
	public static Integer transInteger(String string){
		if (string.contains(".0"))
		return Integer.valueOf(string.substring(0, string.length()-2));
		else return Integer.valueOf(string);
	}

	public static Long transLong(String string){
		if (string.contains(".0"))
		return Long.valueOf(string.substring(0, string.length()-2));
		else return Long.valueOf(string);
	}
}

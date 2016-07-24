package edu.uestc.lib.MSStudio.collecting.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.el.ExpressionFactory;
import javax.script.ScriptEngineManager;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.JxltEngine.Expression;
import org.apache.commons.jexl3.MapContext;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.uestc.lib.MSStudio.collecting.controller.SizeController;
import edu.uestc.lib.MSStudio.collecting.model.SchoolSize;

public class SizeReader{

	public static List<List<String>> readFile(String filePath) throws Exception{
		InputStream is = new FileInputStream(filePath);
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook(is);
		List<List<String>> result = new ArrayList<List<String>>();
		
		for (int numSheet = 0;numSheet<hssfWorkBook.getNumberOfSheets();numSheet++){
			HSSFSheet hssfSheet = hssfWorkBook.getSheetAt(numSheet);
			if(hssfSheet==null){
				continue;
			}
			
			for (int rowNum=0;rowNum<=hssfSheet.getLastRowNum();rowNum++){
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				int minColIx = hssfRow.getFirstCellNum();
				int maxColIx = hssfRow.getLastCellNum();
				
				List<String> rowList = new ArrayList<String>();
				
				for (int colIx = minColIx;colIx<maxColIx;colIx++){
					HSSFCell cell = hssfRow.getCell(colIx);
					if (cell==null){
						continue;
					}
					
					
				}
				result.add(rowList);
			}
		}
		return result;
	}
	

	public static List<SchoolSize> getModelFromExcel(String filePath){
		if (filePath.contains(".xlsx")) return getModelFromXLSX(filePath);
		if (filePath.contains(".xls")) return getModelFromXLS(filePath);
		else return null;
	}
	
	public static List<SchoolSize> getModelFromXLS(String filePath) {
		InputStream is;
		HSSFWorkbook hssfWorkBook;
		try {
			is = new FileInputStream(filePath);
			hssfWorkBook = new HSSFWorkbook(is);
		} catch (IOException e) {
			//产生空文件错误，返回 null。
			return null;
		}
		List<SchoolSize> result = new ArrayList<SchoolSize>();
		
		for (int numSheet = 0;numSheet<hssfWorkBook.getNumberOfSheets();numSheet++){
			HSSFSheet hssfSheet = hssfWorkBook.getSheetAt(numSheet);
			if(hssfSheet==null){
				continue;
			}
			//第一行不存取数据，仅有数据列名称，数据列名称顺序如下：
			/*
			 * 
			Admcode, Year, SchoolRun, SchoolLevel, SchoolSubject, 
			Area, OwnPropArea, TotalArea, SchOwnConArea, 
			StuArea, OfficeArea, TeaAuxArea, TrainArea, PsyArea, DormArea, 
			DormPerArea, TotalStudent, AnnualGraduate, 
			ConsolidationRate, Enrollment, Majors 
			 * */

			//获取列数范围
			HSSFRow hssfRow = hssfSheet.getRow(0);
			int minColIx = hssfRow.getFirstCellNum();
			int maxColIx = hssfRow.getLastCellNum();
			
			for (int rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){
				hssfRow = hssfSheet.getRow(rowNum);
				String[] rowList = new String[maxColIx];
				StringBuffer expBuilder = new StringBuffer();
				for (int colIx = minColIx;colIx<maxColIx;colIx++){
					HSSFCell cell = hssfRow.getCell(colIx);
					if (cell==null){
						rowList[colIx]="";
					}
					else rowList[colIx]=ReaderUtils.getCellContent(cell).trim();
					expBuilder.append("\""+rowList[colIx]+"\",");
				}
				JexlEngine jexl = new JexlBuilder().create();
				expBuilder.deleteCharAt(expBuilder.length()-1);
				String jexlExp = "foo.preSaveSchoolSize("+expBuilder.toString()+")";
				//System.out.println(jexlExp);
				JexlExpression e = jexl.createExpression( jexlExp );
				JexlContext jc = new MapContext();
			    jc.set("foo", SizeController.class);
				SchoolSize o = (SchoolSize) e.evaluate(jc);
				result.add(o);
			}//扫描每一行，将扫描到的行添加到 result 中
		}//扫描每一个 sheet，跳过为空的sheet
		return result;
	}
	
	public static List<SchoolSize> getModelFromXLSX(String filePath) {
		InputStream is;
		XSSFWorkbook hssfWorkBook;
		try {
			is = new FileInputStream(filePath);
			hssfWorkBook = new XSSFWorkbook(is);
		} catch (IOException e) {
			//产生空文件错误，返回 null。
			return null;
		}
		List<SchoolSize> result = new ArrayList<SchoolSize>();
		
		for (int numSheet = 0;numSheet<hssfWorkBook.getNumberOfSheets();numSheet++){
			XSSFSheet hssfSheet = hssfWorkBook.getSheetAt(numSheet);
			if(hssfSheet==null){
				continue;
			}
			//第一行不存取数据，仅有数据列名称，数据列名称顺序如下：
			/*
			 * 
			Admcode, Year, SchoolRun, SchoolLevel, SchoolSubject, 
			Area, OwnPropArea, TotalArea, SchOwnConArea, 
			StuArea, OfficeArea, TeaAuxArea, TrainArea, PsyArea, DormArea, 
			DormPerArea, TotalStudent, AnnualGraduate, 
			ConsolidationRate, Enrollment, Majors 
			 * */

			//获取列数范围
			XSSFRow hssfRow = hssfSheet.getRow(0);
			int minColIx = hssfRow.getFirstCellNum();
			int maxColIx = hssfRow.getLastCellNum();
			
			for (int rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){
				hssfRow = hssfSheet.getRow(rowNum);
				String[] rowList = new String[maxColIx];
				StringBuffer expBuilder = new StringBuffer();
				for (int colIx = minColIx;colIx<maxColIx;colIx++){
					XSSFCell cell = hssfRow.getCell(colIx);
					if (cell==null){
						rowList[colIx]="";
					}
					else rowList[colIx]=ReaderUtils.getCellContent(cell).trim();
					expBuilder.append("\""+rowList[colIx]+"\",");
				}
				JexlEngine jexl = new JexlBuilder().create();
				expBuilder.deleteCharAt(expBuilder.length()-1);
				String jexlExp = "foo.preSaveSchoolSize("+expBuilder.toString()+")";
				//System.out.println(jexlExp);
				JexlExpression e = jexl.createExpression( jexlExp );
				JexlContext jc = new MapContext();
			    jc.set("foo", SizeController.class);
				SchoolSize o = (SchoolSize) e.evaluate(jc);
				result.add(o);
			}//扫描每一行，将扫描到的行添加到 result 中
		}//扫描每一个 sheet，跳过为空的sheet
		return result;
	}
	
	public static void sayhi(String hi){
		System.out.println(hi);
	}
}
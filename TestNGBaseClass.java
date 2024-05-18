package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGBaseClass {
	public static WebDriver driver;
	
	public WebDriver launchBrowser( ) {
   WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver(); 
   return driver;
	}
	
	public void loadUrl(WebDriver driver,String url) {
		driver.get(url);
	}
	public void insertText(WebElement refname,String data) {
refname.sendKeys(data);
	}
	public void btnClick(WebElement b) {
		b.click();
	}
	public void quitBrowser(WebDriver q) {
		q.quit();
     
	}
	public String getCurrUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public String getAttribute(WebElement refname1) {
		String at = refname1.getAttribute("value");
		return at;
	}
	public String getDatafromExcel(String filepath, String sheetname, int row, int cell) throws Exception {
    String value=null;
		File exloc=new File(filepath);
    FileInputStream stream =new FileInputStream(exloc);
    Workbook w=new XSSFWorkbook(stream);
    Sheet s = w.getSheet(sheetname);
    Row r = s.getRow(row);
    Cell c = r.getCell(cell);
    int type = c.getCellType();
    if (type==1) {
    	 value = c.getStringCellValue();
		}if (type==0) {
			boolean cdf = DateUtil.isCellDateFormatted(c);
			if (cdf) {
				Date dcv = c.getDateCellValue();
				SimpleDateFormat sdf=new SimpleDateFormat();
				 value = sdf.format(dcv);
			}
			
    else {
		double ncv = c.getNumericCellValue();
		long l=(long)ncv;
		 value = String.valueOf(l);
	}}
     return value;
	}
	public void assertattri(WebElement refn, String expectedvalue) {
		String at = refn.getAttribute("value");
    Assert.assertEquals(at, expectedvalue);
	}
   
}
I was active in playing outdoor sports, particularly cricket, and I also actively participate in   athlete events like 400m and 1500m.
 Additionally, I had a fondness for music and used to play the keyboard, although I haven't practiced much since then.
 Singing was another passion of mine, and I was part of the school choir.  
6.hiding the logic
	

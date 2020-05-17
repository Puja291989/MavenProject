package com.xyz.mavproj.driverscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverscript {
	public static WebElement un;
	public static WebElement pwd;
	public static WebDriver d;
	public static WebElement submit;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Chrome driver\\chromedriver.exe");
		d =  new ChromeDriver();
		d.manage().window().maximize();
		d.get("	http://newtours.demoaut.com/");
	
		
		File f =  new File("F:\\Users\\psdemo\\Desktop\\Maven\\src\\test\\resources\\TestData\\UserData.xlsx");
				FileInputStream fis = new FileInputStream(f);
				XSSFWorkbook wb = new XSSFWorkbook (fis);
				XSSFSheet sheet  =  wb.getSheet("sheet1");
				int rowcoun= sheet.getLastRowNum();
				int cellcount =  sheet.getRow(1).getLastCellNum();

				un = d.findElement(By.name("userName"));
				pwd = d.findElement(By.name("password"));

				String uname1 = sheet.getRow(1).getCell(0).getStringCellValue();
				String passwd1 = sheet.getRow(1).getCell(1).getStringCellValue();
				
;

				un.sendKeys(uname1);
				pwd.sendKeys(passwd1);
				
				submit = d.findElement(By.name("login"));

				submit.click();
				
				d.navigate().back();
				Thread.sleep(1000);
		
				un = d.findElement(By.name("userName"));
				pwd = d.findElement(By.name("password"));
				
				String uname2 = sheet.getRow(2).getCell(0).getStringCellValue();
				String passwd2 = sheet.getRow(2).getCell(1).getStringCellValue();
			
				un.sendKeys(uname2);
				pwd.sendKeys(passwd2);
				submit = d.findElement(By.name("login"));

				submit.click();
				
				String title  = d.getTitle();
				System.out.print(title);		
	}

}

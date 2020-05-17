package com.xyz.mavproj.driverscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterUser extends driverscript {
	
	public static WebElement Fname, Lname,	Phone,	Email,	Addr1,	Addr2;
	public static WebElement city,	state,	zip,	country,	username;
	public static WebElement pwd,	confpwd,register;
	

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Chrome driver\\chromedriver.exe");
		d =  new ChromeDriver();
		d.manage().window().maximize();
		d.get("	http://newtours.demoaut.com/");
		d.findElement(By.linkText("Register here")).click();
		
				
		File f =  new File("F:\\Users\\psdemo\\Desktop\\Maven\\src\\test\\resources\\TestData\\RegUser.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook (fis);
		XSSFSheet sheet  =  wb.getSheet("sheet1");
		int rowcoun= sheet.getLastRowNum();
		int cellcount =  sheet.getRow(1).getLastCellNum();

		Fname = d.findElement(By.name("firstName"));
		Lname = d.findElement(By.name("lastName"));
		Phone = d.findElement(By.name("phone"));
		Email= d.findElement(By.name("userName"));
		Addr1= d.findElement(By.name("address1"));
		Addr2= d.findElement(By.name("address2"));
		city= d.findElement(By.name("city"));
		state= d.findElement(By.name("state"));
		zip= d.findElement(By.name("postalCode"));
		 country = d.findElement(By.name("country"));
			Select countryname = new Select(country);
		username= d.findElement(By.name("email"));
		pwd= d.findElement(By.name("password"));
		confpwd = d.findElement(By.name("confirmPassword"));
		register = d.findElement(By.name("register"));

		String xfname = sheet.getRow(1).getCell(0).getStringCellValue();
		String xlname = sheet.getRow(1).getCell(1).getStringCellValue();
		String xphone = sheet.getRow(1).getCell(2).getStringCellValue();
		String xemail = sheet.getRow(1).getCell(3).getStringCellValue();
		String xaddr1 = sheet.getRow(1).getCell(4).getStringCellValue();
		String xaddr2 = sheet.getRow(1).getCell(5).getStringCellValue();
		String xcity = sheet.getRow(1).getCell(6).getStringCellValue();
		String xstate = sheet.getRow(1).getCell(7).getStringCellValue();
		String xzip = sheet.getRow(1).getCell(8).getStringCellValue();
		String xcountry = sheet.getRow(1).getCell(9).getStringCellValue();
		String xusername = sheet.getRow(1).getCell(10).getStringCellValue();
		String xpwd = sheet.getRow(1).getCell(11).getStringCellValue();
		String xconfpwd = sheet.getRow(1).getCell(12).getStringCellValue();
		
		
		
		
		
		Fname.sendKeys(xfname);
		Lname.sendKeys(xlname);
		Phone.sendKeys(xphone);
		Email.sendKeys(xemail);
		Addr1.sendKeys(xaddr1);
		Addr2.sendKeys(xaddr2);
		city.sendKeys(xcity);
		state.sendKeys(xstate);
		zip.sendKeys(xzip);	
		Thread.sleep(1000);
		countryname.selectByVisibleText(xcountry);
		username.sendKeys(xusername);
		 pwd.sendKeys(xpwd);
		 confpwd.sendKeys(xconfpwd);
		 register.click();
	}

}

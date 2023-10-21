import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab7DemoTest {
	WebDriver driver;
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", "./drive/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
	}
	@Test
	public void TC01_LoginFirstAccount() {
		String baseUrl = PropertiesFileUtils.getProperty("base_url");
		String email = PropertiesFileUtils.getProperty("email_1");
		String password = PropertiesFileUtils.getProperty("password_1");
		
		LoginPage loginPage = new LoginPage(driver);
		try {
			loginPage.openWebsite(baseUrl);
			Assert.assertEquals(loginPage.checkSignOut(), false);
			loginPage.gotoLoginPage();
			loginPage.enterEmail(email);
			loginPage.enterPassword(password);
			loginPage.clickSignIn();
			Assert.assertEquals(loginPage.checkSignOut(), true);
			loginPage.clickLogout();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test
	public void TC02_LoginSecondAccount() {
		String baseUrl = PropertiesFileUtils.getProperty("base_url");
		String email = PropertiesFileUtils.getProperty("email_2");
		String password = PropertiesFileUtils.getProperty("password_2");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		try {
			loginPage.openWebsite(baseUrl);
			Assert.assertEquals(loginPage.checkSignOut(), false);
			loginPage.gotoLoginPage();
			loginPage.enterEmail(email);
			loginPage.enterPassword(password);
			loginPage.clickSignIn();
			loginPage.checkSignOut();
			Assert.assertEquals(loginPage.checkSignOut(), true);
			loginPage.clickLogout();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws InterruptedException {
		Thread.sleep(1000);
		try {
			if(ITestResult.FAILURE == result.getStatus()) {
				CaptureScreenshot.takeScreenshot(driver, result.getName());
				System.out.println("Da chup man hinh tai testcase "+ result.getName());
			}
		} catch (Exception e) {
			System.out.println("Đã xảy ra lỗi khi chụp ảnh màn hình "+ e.getMessage());
			
		}
	}
	
	@AfterClass
	public void terminal() {
		driver.close();
	}
}
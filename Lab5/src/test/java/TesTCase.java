import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TesTCase {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Thiết lập đường dẫn đến ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64");
        // Khởi tạo đối tượng ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void TC01_GoogleSearch() {
        // Mở trình duyệt và điều hướng đến https://www.google.com.vn/
        driver.get("https://www.google.com.vn/");

        // Sử dụng WebDriverWait để cài đặt thời gian tải trang không quá 15 giây
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement inputSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

        // Đẩy từ khóa "selenium" vào ô tìm kiếm
        inputSearch.sendKeys("selenium");

        // Tìm và nhấp vào nút Tìm trên google (XPath được sử dụng là ví dụ, bạn có thể chọn cách tìm
        // nút bằng id, name, hoặc css selector tương ứng)
        WebElement btnSearch = driver.findElement(By.xpath("//input[@name='btnK']"));
        btnSearch.click();
    }

    @AfterClass
    public void tearDown() {
        // Đóng trình duyệt sau khi hoàn thành
        driver.quit();
    }
}



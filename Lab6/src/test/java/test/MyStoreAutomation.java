package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class MyStoreAutomation {
    private WebDriver driver;
    private final String URL = "https://automationexercise.com/products";
    private final String keyword = "Stylish Dress";

    @BeforeClass
    public void Init() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_MyOrderSearchValid() {
        // Step 1: Navigate to the URL
        driver.get(URL);

        // Set a timeout for page loading
        WebDriverWait wait = new WebDriverWait(driver, 15);

        // Check if the search input is displayed
        WebElement inputSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_query_top")));
        Assert.assertTrue(inputSearch.isDisplayed(), "Page load failed");

        // Use Actions to enter the keyword and submit the search
        Actions action = new Actions(driver);
        action.sendKeys(inputSearch, keyword).sendKeys(Keys.ENTER).build().perform();

        // Step 2: Verify search results
        WebElement resultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-count")));
        Assert.assertTrue(resultMessage.isDisplayed(), "Search failed");
 
        // Set a timeout for page loading
        WebDriverWait Wait = new WebDriverWait(driver, 5);

        // Check if the product image is displayed
        WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='replace-2x img-responsive']")));
        Assert.assertTrue(productImage.isDisplayed(), "Product image is not displayed");

        // Step 3: Add the product to cart
        WebElement btnAddToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit")));
        Assert.assertTrue(btnAddToCart.isDisplayed(), "Add to cart button is not displayed");
        // Set a timeout for page loading
        WebDriverWait WAIT = new WebDriverWait(driver, 5);

        WebElement productName = driver.findElement(By.xpath("//a[@class='product-name']"));
        String productNameText = productName.getText();
        Assert.assertTrue(productNameText.contains(keyword), "Product name does not match search keyword");

        action.click(btnAddToCart).build().perform();

        // Step 4: Verify the success message
        WebElement addResponseMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'alert-success')]")));
        String expectedMsg = "Your product has been added to cart.";
        String actualMsg = addResponseMsg.getText();
        Assert.assertEquals(actualMsg, expectedMsg, "Adding to cart failed");
    }

    @AfterClass
    public void terminate() {
        driver.quit();
    }
}


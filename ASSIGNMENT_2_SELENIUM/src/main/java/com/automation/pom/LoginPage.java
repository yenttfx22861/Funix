package com.automation.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.utils.PropertiesFileUtils;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@data-qa='login-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@data-qa='login-password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@data-qa='login-button']")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void enterEmail(String email) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
        Thread.sleep(2000);
    }

    public void enterPassword(String password) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
        Thread.sleep(2000);
    }

    public void clickSignIn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        Thread.sleep(2000);
    }
}
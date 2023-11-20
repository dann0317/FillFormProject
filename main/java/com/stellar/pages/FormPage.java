package com.stellar.pages;

import com.stellar.models.FormModel;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class FormPage {
    private WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(FormModel formData) {
        WebElement firstnameInput = driver.findElement(By.id("firstname"));
        WebElement lastnameInput = driver.findElement(By.id("lastname"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement companyInput = driver.findElement(By.id("company"));
        WebElement phoneInput = driver.findElement(By.id("phone"));
        WebElement messageInput = driver.findElement(By.id("message"));

        firstnameInput.sendKeys(formData.getFirstName());
        lastnameInput.sendKeys(formData.getLastName());
        emailInput.sendKeys(formData.getEmail());
        companyInput.sendKeys(formData.getCompany());
        phoneInput.sendKeys(formData.getPhone());
        messageInput.sendKeys(formData.getMessage());
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement button = driver.findElement(By.id("email"));
//        js.executeScript("arguments[0].scrollIntoView();", button);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[@type='submit']")));
        messageInput.sendKeys(Keys.PAGE_DOWN);
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
//        Actions actions = new Actions(driver);
//        Point point;
//        point= submitButton.getLocation();
//        actions.moveByOffset(point.getX(), point.getY());
//       // actions.moveToElement(submitButton);
//        actions.perform();
        submitButton.click();

//        Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(ElementClickInterceptedException.class);
//        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
//This is how we specify the condition to wait on.
//This is what we will explore more in this chapter

        //submitButton.click();
    }

    public String getSuccessfulMessage() {
        WebElement res = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(), 'Thanks')]"))));
//        Wait<WebDriver> wait =
//                new FluentWait<>(driver)
//                        .withTimeout(Duration.ofSeconds(4))
//                        .pollingEvery(Duration.ofMillis(300))
//                        .ignoring(ElementNotInteractableException.class);
//        wait.until(d -> driver.findElement(By.xpath("//h2[contains(text(), 'Thanks')]")).isDisplayed());
        WebElement successMessage = driver.findElement(By.xpath("//h2[contains(text(), 'Thanks')]"));
        return successMessage.getText();
    }

    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }
}

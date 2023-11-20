package com.stellar.pages;

import com.stellar.models.FormModel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        scrollToElement(By.xpath("//button[@type='submit']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
    }

    public String getSuccessfulMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlToBe("https://www.adkgroup.com/thank-you/"));
        WebElement successMessage = driver.findElement(By.xpath("//h2[contains(text(), 'Thanks')]"));
        return successMessage.getText();
    }

    public String getWrongFormatError(){
        WebElement formatErrorMessage = driver.findElement(By.xpath("//span[text()='Incorrect format']"));
        return formatErrorMessage.getText();
    }

    private void scrollToElement(By elementBy) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(elementBy));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

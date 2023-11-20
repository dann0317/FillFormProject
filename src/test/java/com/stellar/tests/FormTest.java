package com.stellar.tests;

import com.stellar.models.FormModel;
import com.stellar.pages.FormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTest {
    private WebDriver driver;
    private FormPage formPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        formPage = new FormPage(driver);
    }

    @Test
    public void testFillAndSendForm() {
        driver.get("https://adkcw-wp.adkalpha.com/contact/");
        FormModel formData = new FormModel(
                "John", "Doe", "john.doe@example.com", "company", "123456789", "hello");
        formPage.fillForm(formData);
//        String succesfulMessage = formPage.getSuccessfulMessage();
//        Assert.assertEquals("Thanks for throwing us a bone.", succesfulMessage);
//        Assert.assertEquals("https://www.adkgroup.com/thank-you/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

package com.testing2i;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
;import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    WebDriver driver;

    @Given("I am on nouri's progress page")
    public void i_am_on_nouri_s_progress_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);
        driver.get("https://nouri2i.github.io/");

    }
    @When("I click on the {string} link")
    public void i_click_on_the_link(String string) throws InterruptedException {

        driver.findElement(By.cssSelector("a[href='#framework']")).click();
        Thread.sleep(2000);

    }
    @Then("I am taken to the {string} section")
    public void i_am_taken_to_the(String string) {



    }
    @Then("I can click the github link to load the github page")
    public void i_can_click_the_github_link_to_load_the_github_page() throws InterruptedException {

        driver.findElement(By.id("frameworkgithubLink")).click();
    }
    @Then("I click the github link")
    public void a_link_to_github_showing_my_work_is_available() {

        driver.findElement(By.cssSelector("#githubLink")).click();

    }
    @Then("I am taken to the {string} page")
    public void i_am_taken_to_the_page(String expectedURL) throws InterruptedException{
        Thread.sleep(10000);
        String currentURL=driver.getCurrentUrl();
        System.out.println(currentURL);
      //  assertTrue(currentURL.contains(expectedURL));

    }






    @AfterAll
    public void afterTest(){
        driver.quit();

    }


}

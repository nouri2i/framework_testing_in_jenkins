package com.testing2i;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
;import static org.hamcrest.CoreMatchers.containsString;

public class StepDefinitions {
    WebDriver driver;
    @Given("^(?i)I am on the (?-i)Google homepage$")
    @When("I am on the Google")
    public void i_am_on_the_google_homepage() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.google.co.uk");
        driver.findElement(By.cssSelector("#L2AGLb > div")).click();

    }

//    @Then("I search for \"([^\"]*)\"$")
    @When("I search for {string}")
    public void i_search_for(String searchText) throws InterruptedException {
        driver.findElement(By.cssSelector(".a4bIc > input[role='combobox']")).sendKeys(searchText+ Keys.ENTER);
        Thread.sleep(1000);
    }
//    @When("I search for \"([^\"]*)\"$")
//    public void blah(String searchText) throws InterruptedException {
//
//    }
    @Then("{string} appears in the results")
    public void appears_in_the_results(String searchResult) {
        String searchResults= driver.findElement(By.cssSelector("#rso")).getText();
       MatcherAssert.assertThat(searchResults,containsString(searchResult));

    }

}

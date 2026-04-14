package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class App {
    public static void main(String[] args) {

        // Configure Chrome for headless Linux/CI environment
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Open website
            driver.get("https://practicetestautomation.com/practice-test-login/");

            // Wait setup
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Perform login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            // Optional: wait for successful login element (adjust if needed)
            wait.until(ExpectedConditions.urlContains("logged-in-successfully"));

        } finally {
            // Close browser
            driver.quit();
        }
    }
}

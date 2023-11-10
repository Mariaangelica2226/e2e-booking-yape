package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public static WebDriver createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximiza la ventana del navegador al abrirlo

        System.setProperty("webdriver.chrome.driver", "./chromedriver"); // Ruta al archivo ChromeDriver

        return new ChromeDriver(options);
    }
}

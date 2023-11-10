package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestStepDefinitions extends UIInteractionSteps {

    @Step("Busca los elementos y realiza una accion por cada uno")
    public void useElements() {
        //$("//*[@class=\"example\"]/p").waitUntilClickable().withTimeoutOf(Duration.ofSeconds(10)).click();
        //$(InputField.withPlaceholder("Send a mesage")).type("secret_sauce");
        //$(Button.withText("Login")).click();

        List<WebElementFacade> elementos = $(By.xpath("//*[@class='example']")).thenFindAll(By.xpath("//a"));
        for(WebElement elemento: elementos) {
            switch (elemento.getText().split(".")[1]) {
                case "png":
                    System.out.println("Soy un archivo PNG");
                    break;
                case "jpg":
                    System.out.println("Soy un archivo JPG");
                    break;
                case "txt":
                    elemento.click();
                    break;
                default:
                    System.out.println("No es un archivo valido");
                    break;

            }
        }
    }
}
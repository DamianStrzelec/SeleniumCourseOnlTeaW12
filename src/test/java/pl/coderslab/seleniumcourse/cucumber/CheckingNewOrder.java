package pl.coderslab.seleniumcourse.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckingNewOrder {
    private WebDriver driver;

    public CheckingNewOrder(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPickUpInStoreBtnChecked() {
        WebElement pickUpInStoreBtn = driver.findElement(By.cssSelector("span"));
        String status = pickUpInStoreBtn.getText();

        return status.equals("");
    }
}
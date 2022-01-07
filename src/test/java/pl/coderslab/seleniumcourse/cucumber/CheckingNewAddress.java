package pl.coderslab.seleniumcourse.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckingNewAddress {
    private WebDriver driver;

    public CheckingNewAddress(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAliasCorrect() {
        WebElement alias = driver.findElement(By.xpath("//h4"));
        String aliasInForm = alias.getText();

        return aliasInForm.equals("Kowal");
    }

    public boolean isAddressCorrect() {
        WebElement address = driver.findElement(By.xpath("//address"));
        String addressInForm = address.getText();

        return addressInForm.contains("89 Crown Street");
    }

    public boolean isZipcodeCorrect() {
        WebElement zipcode = driver.findElement(By.xpath("//address"));
        String zipcodeInForm = zipcode.getText();

        return zipcodeInForm.contains("56-254");
    }

    public boolean isCityCorrect() {
        WebElement city = driver.findElement(By.xpath("//address"));
        String cityInForm = city.getText();

        return cityInForm.contains("Manchester");
    }

    public boolean isCountryCorrect() {
        WebElement country = driver.findElement(By.xpath("//address"));
        String countryInForm = country.getText();

        return countryInForm.contains("United Kingdom");
    }

    public boolean isPhoneCorrect() {
        WebElement phone = driver.findElement(By.xpath("//address"));
        String phoneInForm = phone.getText();

        return phoneInForm.contains("872123942");
    }

    public boolean isAddressAdded() {
        WebElement confirmationText = driver.findElement(By.cssSelector("article.alert.alert-success"));
        String statement = confirmationText.getText();

        return statement.equals("Address successfully added!");
    }
}
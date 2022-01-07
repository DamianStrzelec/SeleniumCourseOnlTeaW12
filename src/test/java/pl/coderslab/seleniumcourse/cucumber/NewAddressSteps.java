package pl.coderslab.seleniumcourse.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class NewAddressSteps {
    private WebDriver driver;

    @Given("^Web page (.*) opened in browser$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    @And("logged on a previously created user using the correct e-mail and password")
    public void loginProcedure() {
        WebElement signInBtn = driver.findElement(By.id("_desktop_user_info"));
        signInBtn.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("txnistdtxjxwhtspla@kvhrs.com");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("qwerty123");
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

    @When("Clicked on the 'Addresses' tile after logging in")
    public void clickTile() {
        WebElement addressesLink = driver.findElement(By.xpath("//a[@title='Addresses']"));
        addressesLink.click();
    }

    @And("clicked on '+ Create new address'")
    public void clickPlus() {
        WebElement createNewAddressLink = driver.findElement(By.xpath("//a[@data-link-action='add-address']"));
        createNewAddressLink.click();
    }

    @And("^filled the 'New address' form with data: (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void fillForm(String alias, String address, String city, String zipcode, String country, String phone) {
        WebElement aliasInputBox = driver.findElement(By.name("alias"));
        aliasInputBox.sendKeys(alias);
        WebElement addressInputBox = driver.findElement(By.name("address1"));
        addressInputBox.sendKeys(address);
        WebElement cityInputBox = driver.findElement(By.name("city"));
        cityInputBox.sendKeys(city);
        WebElement zipcodeInputBox = driver.findElement(By.name("postcode"));
        zipcodeInputBox.sendKeys(zipcode);
        WebElement countryListBox = driver.findElement(By.name("id_country"));
        countryListBox.click();
        countryListBox.sendKeys(country);
        WebElement phoneInputBox = driver.findElement(By.name("phone"));
        phoneInputBox.sendKeys(phone);
    }

    @And("clicked on 'Save' button")
    public void clickSaveBtn() {
        WebElement saveBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary float-xs-right']"));
        saveBtn.click();
    }

    @And("checked if the data in the form is correct")
    public void checkData() {
        CheckingNewAddress checkingNewAddressData = new CheckingNewAddress(driver);
        Assertions.assertTrue(checkingNewAddressData.isAliasCorrect());
        Assertions.assertTrue(checkingNewAddressData.isAddressCorrect());
        Assertions.assertTrue(checkingNewAddressData.isZipcodeCorrect());
        Assertions.assertTrue(checkingNewAddressData.isCityCorrect());
        Assertions.assertTrue(checkingNewAddressData.isCountryCorrect());
        Assertions.assertTrue(checkingNewAddressData.isPhoneCorrect());
    }

    @Then("Added new address with corrected data")
    public void checkAddedNewAddress() {
        CheckingNewAddress checkingNewAddressData = new CheckingNewAddress(driver);
        Assertions.assertTrue(checkingNewAddressData.isAddressAdded());
    }
}
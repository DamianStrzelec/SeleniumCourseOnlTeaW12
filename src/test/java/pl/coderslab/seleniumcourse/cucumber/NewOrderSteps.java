package pl.coderslab.seleniumcourse.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class NewOrderSteps {
    private WebDriver driver;

    @Given("^Web page (.*) opened in Google Chrome browser$")
    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    @And("logged on a previously created user using the same e-mail and password as when adding a new address")
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

    @When("Searched for 'Hummingbird Printed Sweater' for purchase")
    public void searchForProduct() {
        WebElement productFinder = driver.findElement(By.name("s"));
        productFinder.sendKeys("Hummingbird Printed Sweater");
        productFinder.submit();
        WebElement productIcon = driver.findElement(By.xpath("//img[@src='https://mystore-testlab.coderslab.pl/img/p/2/1/21-home_default.jpg']"));
        productIcon.click();
    }

    @And("^selected size (.*)$")
    public void selectSize(String size) {
        WebElement sizeList = driver.findElement(By.id("group_1"));
        sizeList.click();
        sizeList.sendKeys(size);
    }

    @And("^selected (.*) items$")
    public void selectQuantity(String quantity) {
        WebElement quantityList = driver.findElement(By.id("quantity_wanted"));
        quantityList.clear();
        quantityList.sendKeys(quantity);
    }

    @And("added a product to the cart")
    public void clickAddToCartBtn() {
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart']"));
        addToCartBtn.click();
    }

    @And("selected checkout options")
    public void clickCheckoutButtons() {
        WebElement checkoutBtn = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        checkoutBtn.click();
        WebElement checkoutButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        checkoutButton.click();
    }

    @And("confirmed previously added address")
    public void clickContinueBtn() {
        WebElement continueBtn = driver.findElement(By.name("confirm-addresses"));
        continueBtn.click();
    }

    @And("selected the pickup method as 'Pick up in-store'")
    public void selectShippingMethod() {
        CheckingNewOrder checkingNewOrderBtnStatus = new CheckingNewOrder(driver);
        Assertions.assertTrue(checkingNewOrderBtnStatus.isPickUpInStoreBtnChecked());
        WebElement continueButton = driver.findElement(By.name("confirmDeliveryOption"));
        continueButton.click();
    }

    @And("selected the payment option as 'Pay by Check'")
    public void selectPaymentMethod() {
        WebElement payByCheckBtn = driver.findElement(By.id("payment-option-1"));
        payByCheckBtn.click();
    }

    @And("agreed to the terms of service and to adhere with them unconditionally")
    public void selectAgreementCheckbox() {
        WebElement agreementCheckbox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        agreementCheckbox.click();
    }

    @And("clicked on 'Order with an obligation to pay'")
    public void clickSubmitBtn() {
        WebElement submitBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary center-block']"));
        submitBtn.click();
    }

    @Then("Confirmed a new order by a screenshot with the order confirmation and the amount")
    public void checkConfirmationANewOrder() {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
    }
}
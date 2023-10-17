package selenium.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium {
RemoteWebDriver driver;
   @BeforeTest
    public void setUp() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName", "Chrome");
    capabilities.setCapability("browserVersion", "119.0");
    try {
   driver = new RemoteWebDriver(new URL("http://prerana_raut:O4aZnPhl5oXS4rZDedoi9W16CpJ3H4SflZsQcWg2Fzfb9RteJ6@hub.lambdatest.com/wd/hub"),
capabilities);
       } catch (MalformedURLException e) {
    // TODO Auto-generated catch block
   e.printStackTrace();
   }
    }
   @Test
   public void Main() throws InterruptedException {   
       // Test Scenario 1
       driver.get("https://www.lambdatest.com/selenium-playground");

       driver.findElement(By.linkText("Simple Form Demo")).click();

       String currentURL = driver.getCurrentUrl();

       if (currentURL.contains("simple-form-demo")) {

           System.out.println("URL validation successful.");

       } else {

           System.out.println("URL validation failed.");

       }

       String message = "Welcome to LambdaTest";

       WebElement textBox = driver.findElement(By.id("user-message"));

       textBox.sendKeys(message);

       driver.findElement(By.xpath("//button[text()='Get Checked value']")).click();

       WebElement messageLabel = driver.findElement(By.id("message"));

       String displayedMessage = messageLabel.getText();

       if (displayedMessage.equals(message)) {

           System.out.println("Message validation successful.");

       } else {

           System.out.println("Message validation failed.");

       }

       // Test Scenario 2

       driver.get("https://www.lambdatest.com/selenium-playground");

       driver.findElement(By.linkText("Drag & Drop Sliders")).click();

       WebElement slider = driver.findElement(By.xpath("//input[@value='15']")); 

       Actions actions = new Actions(driver);

       actions.clickAndHold(slider).moveByOffset(102, 0) .release().perform();

       WebElement rangeValue = driver.findElement(By.id("rangeSuccess"));

       String value = rangeValue.getAttribute("value");

       if (value.equals("95")) {

           System.out.println("Slider validation successful.");

       } else {

           System.out.println("Slider validation failed.");

       }

       // Test Scenario 3

       driver.get("https://www.lambdatest.com/selenium-playground");

       driver.findElement(By.linkText("Input Form Submit")).click();

       driver.findElement(By.xpath("//button[text()='Submit']")).click();

       String errorMessage = driver.findElement(By.xpath("//input[@id='name']")).getAttribute("validationMessage");

       System.out.println(errorMessage);

       if (errorMessage.equals("Please fill out this field.")) {

           System.out.println("Error message validation successful.");

       } else {

           System.out.println("Error message validation failed.");

       }

       driver.findElement(By.id("name")).sendKeys("abc");

       driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("abc@gmail.com");

       driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("Abc@123");

       driver.findElement(By.id("company")).sendKeys("abc");
       driver.findElement(By.id("websitename")).sendKeys("lambdatest");
       driver.findElement(By.id("inputCity")).sendKeys("pune");
       driver.findElement(By.id("inputAddress1")).sendKeys("abc");
       driver.findElement(By.id("inputAddress2")).sendKeys("abc");
       driver.findElement(By.id("inputState")).sendKeys("Maharashtra");
       driver.findElement(By.id("inputZip")).sendKeys("411057");
       Select countryDropdown = new Select(driver.findElement(By.xpath("//select[@name='country']")));
       countryDropdown.selectByVisibleText("United States");
       driver.findElement(By.cssSelector("button[type='submit']")).click();
       WebElement successMessage = driver
               .findElement(By.xpath("//p[@class='success-msg hidden']"));
       String successText = successMessage.getText();
       if (successText.equals("Thanks for contacting us, we will get back to you shortly.")) {
           System.out.println("Success message validation successful.");
       } else {
           System.out.println("Success message validation failed.");
       }
       driver.quit();
   }
}
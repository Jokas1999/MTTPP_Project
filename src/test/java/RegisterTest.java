
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegisterTest {
    protected String getRandString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public WebDriver driver;

    public String testURL = "https://demo.opencart.com/index.php?route=common/home";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");


        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.whitelistedIps", "192.168.1.106");
        ChromeDriverService service = new ChromeDriverService.Builder().withWhitelistedIps("192.168.1.106").withVerbose(true).build();

        driver.navigate().to(testURL);
    }


    @Test

    public void RegisterTest() throws InterruptedException {

        ExtentReports extent = new ExtentReports("target/Results.html", false);
        ExtentTest test = extent.startTest("RegisterTest");

        Actions actions = new Actions(driver);

        driver.manage().window().maximize();

        WebElement myAccount = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a"));
        myAccount.click();

        WebElement Register = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a"));

        Register.click();

        WebElement inputFirstName = driver.findElement(By.name("firstname"));
        inputFirstName.click();
        inputFirstName.sendKeys("Name");


        WebElement inputLastName = driver.findElement(By.name("lastname"));
        inputLastName.click();
        inputLastName.sendKeys("LastName");

        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.click();
        String email = getRandString() + "@gmail.com";
        inputEmail.sendKeys(email);

        WebElement inputTelephone = driver.findElement(By.name("telephone"));
        inputTelephone.click();
        inputTelephone.sendKeys("1534546454564");

        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.click();
        inputPassword.sendKeys("1234");

        WebElement inputConfirm = driver.findElement(By.name("confirm"));
        inputConfirm.click();
        inputConfirm.sendKeys("1234");

        WebElement inputAgree = driver.findElement(By.name("agree"));
        inputAgree.click();

        WebElement inputContinue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        inputContinue.click();
        Thread.sleep(2999);


        test.log(LogStatus.PASS, "Test izvršen uspješno");
        extent.endTest(test);
        extent.flush();


    }


    @AfterMethod
    public void teardownTest() {

        driver.quit();
    }
}

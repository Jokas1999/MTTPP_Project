
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {


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

    public void LoginTest() throws InterruptedException {

        ExtentReports extent = new ExtentReports("target/Results.html", false);
        ExtentTest test = extent.startTest("LoginTest");

        Actions actions = new Actions(driver);

        driver.manage().window().maximize();

        WebElement myAccount = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a"));
        myAccount.click();

        WebElement Login = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
        Login.click();

        WebElement inputFirstName = driver.findElement(By.name("email"));
        inputFirstName.click();
        inputFirstName.sendKeys("kesolovic123@gmail.com");


        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.click();
        inputPassword.sendKeys("1234");

        WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        btnLogin.click();

        WebElement textCheck = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]"));
        Assert.assertEquals(textCheck.getText(), "My Account");





        test.log(LogStatus.PASS, "Test izvršen uspješno");
        extent.endTest(test);
        extent.flush();


    }


    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FeritTest {


    public WebDriver driver;

    public String testURL = "http://www.google.com";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");


        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.whitelistedIps", "192.168.1.106");
        ChromeDriverService service = new ChromeDriverService.Builder().withWhitelistedIps("192.168.1.106").withVerbose(true).build();

        driver.navigate().to(testURL);
    }

    @Test
    public void feritTest() throws InterruptedException {
        //EXTENT REPORTS INITIALIZE
        ExtentReports extent = new ExtentReports("target/Results.html", true);
        ExtentTest test1 = extent.startTest("FeritTest");


        WebElement accept = driver.findElement(By.id("L2AGLb"));
        accept.click();


        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("ferit");
        searchTextBox.submit();

        WebElement webLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        webLink.click();
        WebElement feritElement = driver.findElement(By.xpath("//*[@id=\"videoTraka\"]/div/h3/a[4]"));
        feritElement.click();
        WebElement rasporedElement = driver.findElement(By.id("tekst-dokumenti"));
        Assert.assertEquals(rasporedElement.getText(), "Dokumenti");


        test1.log(LogStatus.PASS, "Test izvršen uspješno");
        extent.endTest(test1);
        extent.flush();
    }


    @AfterMethod
    public void teardownTest() {

        driver.quit();
    }
}


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

public class NikeWebsiteTest {

    public WebDriver driver;

    public String testURL = "https://www.nike.com/hr/?cp=67829552240_search_%7Cnike%7C10566958754%7C105225566795%7Ce%7Cc%7CHR%7Cpure%7C450648179241&gclsrc=aw.ds&ds_rl=1252249&gclid=EAIaIQobChMI-orhg6Te9QIVI4xoCR3kqAY2EAAYASAAEgJOVPD_BwE";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");


        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.whitelistedIps", "192.168.1.106");
        ChromeDriverService service = new ChromeDriverService.Builder().withWhitelistedIps("192.168.1.106").withVerbose(true).build();

        driver.navigate().to(testURL);
    }


    @Test

    public void NikeWebsiteTest() throws InterruptedException {

        ExtentReports extent = new ExtentReports("target/Results.html", false);
        ExtentTest test = extent.startTest("NikeWebsiteTest");


        Actions actions = new Actions(driver);

        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement accept = driver.findElement(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/div[1]/div/div[2]/div/div[2]/div[2]/button"));
        accept.click();

        Thread.sleep(2000);
        WebElement nikeNewReleses = driver.findElement(By.xpath("/html/body/div[1]/div[3]/header/div/div[1]/div[2]/nav/div[2]/ul/li[1]/a"));
        actions.moveToElement(nikeNewReleses).perform();
        actions.click();
        Thread.sleep(2000);
        WebElement nikeBestsellers = driver.findElement(By.xpath("//*[@id=\"DesktopMenu-0-0-0\"]/div/div[1]/a[2]"));
        nikeBestsellers.click();

        test.log(LogStatus.PASS, "Test izvršen uspješno");
        extent.endTest(test);
        extent.flush();


    }


    @AfterMethod
    public void teardownTest() {

        driver.quit();
    }
}


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YoutubeTest {

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
    public void YoutubeTest() throws InterruptedException {
        ExtentReports extent = new ExtentReports("target/Results.html", false);
        ExtentTest test = extent.startTest("YoutubeTest");


        WebElement accept = driver.findElement(By.id("L2AGLb"));
        accept.click();


        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("youtube");
        searchTextBox.submit();

        WebElement webLink = driver.findElement(By.xpath("/html/body/div[7]/div/div[10]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        webLink.click();

        WebElement btnAccept = driver.findElement(By.xpath("/html/body/ytd-app/ytd-consent-bump-v2-lightbox/tp-yt-paper-dialog/div[4]/div[2]/div[5]/div[2]/ytd-button-renderer[2]/a"));
        btnAccept.click();

        WebElement youtubeSearch = driver.findElement(By.name("search_query"));
        youtubeSearch.click();
        youtubeSearch.sendKeys("ferit");
        youtubeSearch.submit();

        WebElement firstLink = driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a/yt-formatted-string"));


        test.log(LogStatus.PASS, "najs");
        extent.endTest(test);
        extent.flush();
    }


    @AfterMethod
    public void teardownTest() {

        driver.quit();
    }
}

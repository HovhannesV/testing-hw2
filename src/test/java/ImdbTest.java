import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImdbTest {
    private WebDriver webDriver;
    static {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @Before
    public void setupChromeDriver() {
        webDriver = new ChromeDriver();
    }

    @Test
    public void findMovie() throws Exception { // I know I can access some of them in better way, its simply for using in different ways
        System.out.println(webDriver);
        webDriver.get("https://www.imdb.com/");
        webDriver.findElement(By.id("suggestion-search")).sendKeys("matrix");
        webDriver.findElement(By.cssSelector("#suggestion-search-button")).click();
        webDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a")).click();
        webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[5]/div[1]/div[2]/div/div[2]/div[1]/div[2]/a[1]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"maindetails_center_bottom\"]/div[2]/div/div[1]/a[1]/img")).click();

        for(int i = 0; i < 25; i++) { // automated slideshow :)
            Thread.sleep(1000);
            webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[3]")).click();
        }
    }
}

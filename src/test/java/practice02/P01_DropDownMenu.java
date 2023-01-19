package practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P01_DropDownMenu {



    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        }
        @After
    public void tearDown(){
       driver.close();

    }
    @Test
    public void test01(){
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/ ");

        // dropdown'dan "Books" secenegini secin
        //dropdown 3 adımda handle edilir
        // 1- locate edilmeli
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2-Select objesini olusturalim
        Select select = new Select(ddm);
        //3-opsiyon seçilir
        select.selectByVisibleText("Books");
        //select.selectByValue("search-alias=stripbooks");-value ıle alimi
        //select.selectByIndex(12);-indexle alimi

        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);// + yerine virgul de olabilir

        // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String aramaSonucYazisi =aramaSonucElementi.getText();
        Assert.assertTrue(aramaSonucYazisi.contains("Java"));

    }
}

package practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class P02_DropDownOptions {



    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void test02(){
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Baby" secenegini secin
        //dropdown 3 adımda handle edilir
        // 1- locate edilmeli
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2-Select objesini olusturalim
        Select select = new Select(ddm);
        //3-opsiyon seçilir
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
       String sectigimOption= select.getFirstSelectedOption().getText();
        System.out.println("Sectigim Option :"+sectigimOption);

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> tumOptionlar =select.getOptions();
        int actualOptionSayısı = tumOptionlar.size();//butun sayıları dondurucek
        int expectedOptionSayısı =28;
        Assert.assertEquals(expectedOptionSayısı,actualOptionSayısı);

    }
}

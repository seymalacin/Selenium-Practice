package practice03;

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

public class P01_DropDown {



    // ** INTERVIEW QUESTION ** implicitlyWait() nereden gelir? -> Selenium
    //                          Thread.sleep() nereden gelir -> Java
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement option = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select optionDropdown = new Select(option);
        optionDropdown.selectByIndex(1);
        System.out.println(optionDropdown.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        optionDropdown.selectByValue("2");
        System.out.println(optionDropdown.getFirstSelectedOption().getText());
        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        optionDropdown.selectByVisibleText("Option 1");
        System.out.println(optionDropdown.getFirstSelectedOption().getText());
        // Tüm option'ları yazdırın
        List<WebElement> list = optionDropdown.getOptions();
        int counter = 1;
        for (WebElement w : list){
            System.out.println(counter + ". option is: " + w.getText());
            counter++;
        }
        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        Assert.assertEquals(3, list.size());
    }
    @After
    public void tearDown() throws Exception {
        driver.close();






    }
}

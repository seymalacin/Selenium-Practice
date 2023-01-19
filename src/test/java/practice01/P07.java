package practice01;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {



    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        // cookies uyarisini kabul ederek kapatin

        // Sayfa basliginin "Google" ifadesi icerdigini test edin
        String actualtitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(actualtitle.contains(expectedTitle));

        // Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        // Bulunan sonuc sayisini yazdirin
        String[] sonucYazisi = driver.findElement(By.id("result-stats")).getText().split(" ");
        String sonuc = sonucYazisi[1];
        System.out.println("Arama Sonuc Sayisi = " + sonuc);

        // Sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        sonuc = sonuc.replaceAll("\\D", ""); // ReplaceAll() ile \\D'i kullanarak bütün noktalama işaretlerini hiçlikle değiştirdik.
        int istenenSayi = 10000000;
        Assert.assertTrue(Integer.parseInt(sonuc) > istenenSayi);

    }

    @After
    public void tearDown() throws Exception {
        // Sayfayi kapatin
        //driver.close();
    }
}

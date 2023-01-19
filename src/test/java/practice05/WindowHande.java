package practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class WindowHande extends TestBase {

    @Test
    public void test01() {

        //Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWimdow = driver.getWindowHandle();

        //Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle =driver.getTitle();
        String arananKeime="Amazon";
        Assert.assertTrue(actualTitle.contains(arananKeime));
        //String actualTitle = driver.getTitle();
       // Assert.assertTrue(actualTitle.contains("Amazon"));


        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);// Yeni bir sekme acmis olduk
        driver.get("https://techproeducation.com ");

        //Sayfa title’nin “TECHPROEDUCATION” icerip icermedigini test edin
        String actualTechProTitle = driver.getTitle();
        String istenenKelime = "TECHPROEDUCATION";
        Assert.assertFalse(actualTechProTitle.contains(istenenKelime));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);// Yeni bir window actık
        driver.get("https://walmart.com");

        //Sayfa title’nin “Walmart” icerip icermedigini test edin
        String actualWalmartTitle = driver.getTitle();
        String beklenenKelime = "Walmart";
        Assert.assertTrue(actualWalmartTitle.contains(beklenenKelime));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWimdow);
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl = "https://amazon.com/";
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}

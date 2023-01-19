package practice10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P04_Practice extends TestBase {

    @Test
    public void name() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Çıkan ürünlerde sadece Apple iPhone yazanları tıklayalım
        List<WebElement> urunler = driver.findElements(By.partialLinkText("Apple iPhone"));

        //TEXT İÇİNDE APPLE IPHONE YAZISI GEÇENLERİ ALICAK
        for (int i = 0; i < ((List<?>) urunler).size(); i++) {
            urunler = driver.findElements(By.partialLinkText("Apple iPhone"));
            urunler.get(i).click();
            driver.navigate().back();
        }
        //StaleElementReferansException hatasını handle etmek için loop içine webelementlerden oluşturduğumuz
        //list'i koymalıyız

    }
}

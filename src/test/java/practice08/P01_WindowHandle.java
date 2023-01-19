package practice08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P01_WindowHandle extends TestBase {

    @Test
    public void name() {

        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
        String sayfa1Handle =driver.getWindowHandle();

        // 2- nutella icin arama yapın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella"+ Keys.ENTER);

        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella"+ Keys.ENTER);
         WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
         ilkUrun.click();

        // 4- yeni tab'da acilan urunun basligini yazdirin
         WebElement baslık =driver.findElement(By.xpath("//span[@id='productTitle']"));
         String baslıkStr=baslık.getText();
        System.out.println("BASLIK"+baslıkStr);

        // 5- ilk sayfaya gecip url'i yazdırın
        driver.switchTo().window(sayfa1Handle);
        String ilkSayfaUrl=driver.getCurrentUrl();
        System.out.println("İLK SAYFA URL"+ilkSayfaUrl);



    }
}

package practice06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P01_İframe extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe ");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);

        // Videoyu izlemek icin Play tusuna basiniz

          //----NOTE----
        //Play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı
        //Bunun uzerıne HTML kodlarını ınceleyınce Play'in aslında iframe ıcerısınde oldugunu gorduk
        //Bu durumda once ıframı locate edıp sonra swicTo() ile iframe gecmelıyız

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        WebElement play =  driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazısı=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazısı.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

        driver.switchTo().parentFrame();//iframeden cıktık

        WebElement powerful = driver.findElement(By.xpath("//span[text()='Powerful, but easy to misuse']"));
        Assert.assertTrue(powerful.isSelected());

    }
}

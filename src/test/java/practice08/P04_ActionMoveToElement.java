package practice08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class P04_ActionMoveToElement extends TestBase {

    @Test
    public void test04() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com ");
        String sayfa1Handle=driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions =new Actions(driver);
        WebElement dilMenu = driver.findElement(By.xpath("//div[text()='EN']"));
        actions.moveToElement(dilMenu).perform();

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//*[@class='icp-mkt-change-lnk'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm =  driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select =new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");

        //Drop down opsıyon lıstesı "Go to wesible" basmamıza engel oldugu ıcın
        //herhangı bır yere click yapıp drop down opsıyon lıstesının toparlanmasını sagladık
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@id='icp-save-button']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
         Set<String> windowHandleSeti =  driver.getWindowHandles();
        System.out.println(sayfa1Handle);
        System.out.println(windowHandleSeti);

        String sayfa2Handle= "";
        for (String each:windowHandleSeti) {
            if (each.equals(sayfa1Handle)){
                sayfa2Handle=each;
            }


        }
        driver.switchTo().window(sayfa2Handle);
        String ikinciSayfaTitle = driver.getTitle();
        System.out.println(ikinciSayfaTitle);
        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));


    }
}

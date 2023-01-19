package practice06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P02_İframe2 extends TestBase {

    @Test
    public void test2() {
        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        WebElement baslik = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(baslik.isEnabled());
        System.out.println("BASLİK :"+baslik.getText());

        // TextBox'a 'Merhaba Dunya' yazin.
        WebElement iframe= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);//iframin icine girdık

         WebElement texBox =driver.findElement(By.xpath("//body[@id='tinymce']"));
         texBox.clear();//icindekı yazıyı sıldık
         texBox.sendKeys("Merhaba Dunya");

        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        driver.switchTo().parentFrame();//iframin dısına cıktık
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println("ELEMENTAL SELENIUM YAZISI :"+elementalSelenium.getText());



    }
}

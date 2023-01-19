package practice10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P02_UploadFile extends TestBase {

    @Test
    public void name() throws InterruptedException {

        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
       // "C:\Users\seyma\OneDrive\Masaüstü\logo.jpeg"

        //"C:\Users\Lenovo\OneDrive\Masaüstü\sen.txt" //DOSYANIN GERÇEK YOLUNU ALIP GÖREBİLMEK BURAYA KOYDUK
        //String farkliKisim = System.getProperty("user.home");//C:\Users\Lenovo
        //String ortakYol = "\\OneDrive\\Masaüstü\\sen.txt";
        //String dosyaYolu = farkliKisim+ortakYol;
        String dosyaYolu = "C:\\Users\\Windows\\OneDrive\\Masaüstü\\sen.txt";
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadfile_0']"));
        dosyaSec.sendKeys(dosyaYolu);

        // I accept terms of service bölümünü tikleyin
        // Submit File buttonuna basınız
        WebElement checkBox =  driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER);

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        Thread.sleep(2000);

        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();



    }
}

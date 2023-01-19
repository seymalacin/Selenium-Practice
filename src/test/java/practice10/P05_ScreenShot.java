package practice10;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P05_ScreenShot extends TestBase {

    String tarih;

    @Test
    public void name() throws IOException, InterruptedException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Tüm sayfanın resmini alalım
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("target/tumSayfaResmi/tumSayfa" + tarih + ".jpeg"));

        /*
        FILEUTILS CLASS'I, FİLE NESNELERİ İLE BİRLİKTE KULLANABİLECEĞİMİZ METHODLAR İÇERİR.
        BU METHODLARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA İŞLEMLERİNİ ÇOK DAHA KOLAY YAPABİLİRİZ
         */

        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        Thread.sleep(6000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("target/tumSayfaResmi/tumSayfa" + tarih + ".jpeg"));

        //Tekrar amazon sayfasına dönüp iphone aratalım
        // Driver.back
        //Arama sonucunun resmini alalım
        //sonuc elementini locate edip webelmente assine edin
        //FileUtils.copyFile(WE.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));
    }
}

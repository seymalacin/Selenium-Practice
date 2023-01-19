package practice07;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class P11_HomeWork extends TestBase {
    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım
    @Test
    public void name() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        List<WebElement> sayilar;
        Random rnd = new Random();
        for (int i = 0; i < 2; i++) {
            sayilar = driver.findElements(By.xpath("//*[@class='btn btn-outline-primary']"));
            sayilar.get(rnd.nextInt(sayilar.size() - 1)).click();
        }
        String sayi1 = driver.findElement(By.xpath("//*[@class='screen']")).getText();
        System.out.println(sayi1);
        Thread.sleep(2000);
        List<WebElement> islem = driver.findElements(By.xpath("//*[@class='operator btn btn-outline-success']"));
        islem.forEach(t -> System.out.println(t.getText()));
        String tiklananIsaret = "";
        for (int i = 0; i < islem.size(); i++) {
            islem = driver.findElements(By.xpath("//*[@class='operator btn btn-outline-success']"));
            WebElement isaret = islem.get(rnd.nextInt(islem.size()));
            isaret.click();
            tiklananIsaret = isaret.getText();
        }
        Thread.sleep(2000);
        for (int i = 0; i < 2; i++) {
            sayilar = driver.findElements(By.xpath("//*[@class='btn btn-outline-primary']"));
            sayilar.get(rnd.nextInt(sayilar.size() - 1)).click();
        }
        String[] sonucEkran = driver.findElement(By.xpath("//*[@class='screen']")).getText().split("");
        List<String> num = new ArrayList<String>();
        num.add(sonucEkran[3] + sonucEkran[4]);
        String sayi2 = "";
        for (String s : num) {
            sayi2 = s;
            System.out.println(sayi2);
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='btn btn-outline-warning']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='spinner-border']")));
        String sonuc = driver.findElement(By.xpath("//*[@class='screen']")).getText();
        double actualResult = Double.parseDouble(sonuc);
        System.out.println("Gerçek Sonuc = " + actualResult);
        double s1 = Double.parseDouble(sayi1);
        double s2 = Double.parseDouble(sayi2);
        double expectedResult = 0;
        System.out.println("TIKLANAN ISARET " + tiklananIsaret);
        switch (tiklananIsaret) {
            case "+":
                expectedResult = s1 + s2;
                break;
            case "-":
                expectedResult = s1 - s2;
                break;
            case "÷":
                expectedResult = s1 / s2;
                break;
            case "x":
                expectedResult = s1 * s2;
                break;
        }
        System.out.println("Beklenen Sonuc = " + expectedResult);
        assert expectedResult == actualResult;

    }
}

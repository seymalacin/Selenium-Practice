package practice07;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P02_Cookie extends TestBase {

    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

    @Test
    public void test01() throws InterruptedException {
        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com");
        Thread.sleep(5000);

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies =driver.manage().getCookies();
        System.out.println("Cookilerın sayısı:"+cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for (Cookie c:cookies){
            System.out.println(c.getName()+":"+c.getValue());
        }
        //cookies.stream().forEach(t-> System.out.println(t.getName()+" "+ t.getValue()));//lambda version

        //Yeni bir cookie ekleyiniz
        Cookie myCookie = new Cookie("myCookie","123456789");
        driver.manage().addCookie(myCookie);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        System.out.println("Cookilerın sayısı:"+cookies.size());
        Set<Cookie> cookies2 =driver.manage().getCookies();
        System.out.println("Cookilerın sayısı:"+cookies2.size());
        for (Cookie w : cookies2){
            System.out.println(w.getName()+":"+w.getValue());
        }

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();


    }
}

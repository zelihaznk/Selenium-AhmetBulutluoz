package video06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C2_AssertionMethodlariIleTest {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // 1- https:www.amazon.com sayfasina gidin
        driver.get("https:www.amazon.com");
        //2- arama cubuguna “Nutella” yazdirin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella");
        //3- Nutella yazdiktan sonra ENTER’a basarak arama islemini yapin
        aramaKutusu.submit();
        //4- Bulunan sonuc yazisinin "Nutella" icerdigini test edelim
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualYaziStr= sonucYaziElementi.getText();
        // 1-48 of 105 results for "Nutella"
        //String expectedBulunacakKelime="Kutella";
        //Assert.assertTrue(actualYaziStr.contains(expectedBulunacakKelime));//Test faıled olur çünkü nutella ve kutella eşit değildir

        String expectedBulunacakKelime="Nutella";
        Assert.assertTrue(actualYaziStr.contains(expectedBulunacakKelime)); // Bu şekilde yazınca sonuç doğru çıkar


        /*
        int aliYas=56;
        int veliYas=68;
        int emeklilikYasi=65;

         */

    }

}




        /**

         En çok kullanılan assertion methodları:

        Assert.assertTrue();

        Assert.assertFalse();

        Assert.assertEquals();


         --->Biz testin PASSED veya FAILED olası için uğraşmıyoruz "Biz bize verileni direkt kontrol ediyoruz."
         Bize ne deniyorsa onu gerçekleştirecek cümleyi yazıyoruz.
         Böyle bir durumda aşağıdaki örneklerde sadece verilen doğru mu yoksa değil mi diye bakarız.


         Örnek:

         int aliYas=56;
         int veliYas=68;
         int emeklilikYasi=65;

         Assert.assertTrue(veliYas>emeklilikYasi); //Test PASSED

         Assert.assertFalse(aliYas>emeklilikYasi); //Test PASSED

         Assert.assertEquals(65,emeklilikYasi); //Test PASSED

         ---> Ne zaman test FAILED olur?

         Assert.assertTrue(aliYas>emeklilikYasi); //Test FAILED

         Assert.assertFalse(veliYas>emeklilikYasi); //Test FAILED

         Assert.assertEquals(63,emeklilikYasi); //Test FAILED

         */


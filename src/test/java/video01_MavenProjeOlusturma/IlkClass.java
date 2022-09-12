package video01_MavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IlkClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");

        driver.manage().window().maximize();// Ekranı büyütür

        Thread.sleep(5000);//5000 milisaniye belke

        driver.close();//programı kapat
    }
}

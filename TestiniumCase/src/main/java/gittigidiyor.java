
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class gittigidiyor {

    public WebDriver driver;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\GurkanSolak\\IdeaProjects\\TestiniumCase\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }

    @Test
    public void TestSearch() {

        WebElement profile = driver.findElement(By.name("profile"));
        profile.click();
        WebElement signin = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a"));
        signin.click();

        WebElement signbtn = driver.findElement(By.className("gg-ui-btn-lg"));
        signbtn.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement mailbox = driver.findElement(By.id("L-UserNameField"));
        mailbox.click();
        mailbox.sendKeys("denemetest@test.com");

        WebElement password = driver.findElement(By.id("L-PasswordField"));
        password.click();
        password.sendKeys("qwer1234");

        driver.findElement(By.id("gg-login-enter")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        /* Arama çubuğunda 'Bilgisayar' ifadesinin aranması */
        WebElement searchBox = driver.findElement(By.name("k"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.findElement(By.tagName("button")).click();

        /* Arama sonuç sayfalarında 2. sayfanın açılması ve rastgele bir ürünün açılması */
        driver.findElement(By.xpath(".//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[3]/div[2]/ul/li[1]")).click();

        WebElement price = driver.findElement(By.xpath(".//*[@id=\"sp-price-discountPrice\"]"));
        String priceText = price.getText();

        /* Açılan ürün sayfasında ürünün sepete eklenmesi*/
        WebElement quantityBox = driver.findElement(By.name("buyitnow_adet"));
        quantityBox.click();
        quantityBox.sendKeys("1");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath("./html/body/div[3]/div[3]/div[3]/div")).click();
        driver.findElement(By.xpath(".//*[@id=\"add-to-basket\"]")).click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]")).click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        /* Ürün sayfasındaki fiyat ile sepetteki fiyatın karşılaştırılması */
        WebElement priceBasket = driver.findElement(By.className("new-price"));
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        String priceText2 = priceBasket.getText();
        if (priceText.compareTo(priceText2) == 0) {

        /* Sepetteki ürün adetinin artırılması */
        WebElement quantityBasket = driver.findElement(By.tagName("select"));
        quantityBasket.click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select/option[2]")).click();
        quantityBasket.click();
        }
        /* Sepetteki ürünlerin boşaltılması */
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/a/i")).click();
    }
    @After
    public void quitDriver() {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}

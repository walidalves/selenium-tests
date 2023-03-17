package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTeste {
    
    protected static WebDriver driver;
    private static final String URL_Base = "https://www.google.com/";
    private static final String CAMINHO_DRIVE = "src/test/java/automatizado/resource/chromedriver-v1110556364.exe";

    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver" , CAMINHO_DRIVE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_Base);
    }

    @AfterClass
    public static void finalizar(){
        driver.quit();
    }

}

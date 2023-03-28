package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todas as classes de teste.
 */
public abstract class BaseTest {
    
    /** Driver do navegador da página atual */
    protected static WebDriver driver;

    /** Caminho base da URL do sistema a ser testado */
    private static final String URL_Base = "file:///C:/Users/walid/OneDrive/%C3%81rea%20de%20Trabalho/Curso%20Automa%C3%A7%C3%A3o/Teste%20Automatizado-20230313T204520Z-001/Teste%20Automatizado/controle-de-produtos/sistema/login.html";

    /** Caminho relativo do driver ao projeto referente ao path */
    private static final String CAMINHO_DRIVE = "src/test/java/automatizado/resource/chromedriver-v1110556364.exe";

    /**
     * Metodo para iniciar o driver do navegador antes de qualquer classe de teste.
     */
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver" , CAMINHO_DRIVE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_Base);
    }

    /**
     * Metodo para iniciar o driver do navegador depois de qualquer classe de teste.
     */
    @AfterClass
    public static void finalizar(){
        driver.quit();
    }

}

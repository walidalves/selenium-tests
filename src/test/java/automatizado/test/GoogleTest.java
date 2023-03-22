package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.GooglePO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://www.google.com/");
        googlePage = new GooglePO(driver);
    }
    
    @Test
    public void TC001_devePesquisarOTextoBatataFrita(){

        googlePage.pesquisar("Batata frita");

        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(resultado, resultado.contains("Aproximadamente"));
    }


    @Test
    public void TC002_devePesquisarOTextoComBacon(){

        googlePage.pesquisar(" Com Bacon");

        String resultado = googlePage.obterResultadoDaPesquisa();
        
        assertTrue(resultado, resultado.contains("resultados"));
    }
}

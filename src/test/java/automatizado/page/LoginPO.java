package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement btnEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    /**
     * Construtor padrãoo para criação de uma nova instâancia da página de login.
     * @param driver Driver da página de login.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }
    
    public String obterMensagem(){
        return this.spanMensagem.getText();
    }

    public void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        btnEntrar.click();
    }
}

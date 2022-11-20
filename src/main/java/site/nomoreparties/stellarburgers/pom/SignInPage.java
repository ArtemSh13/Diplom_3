package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    public static final String LOG_IN_PAGE_URL = ConstructorPage.MAIN_PAGE_URL + "/login";

    private WebDriver driver;

    private Header header;

    private By signInLabel = By.xpath(".//h2[text()='Вход']");

    private By emailField = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @type='text']");

    private By passwordField = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @type='password']");

    private By showPasswordButton = By.xpath(".//div[@class='input__icon input__icon-action']");

    private By signInButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    private By newUserLabel = By.xpath(".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']");

    private By signUpLink = By.xpath(".//a[text()='Зарегистрироваться']");

    private By forgetPasswordLabel = By.xpath(".//p[@class='undefined text text_type_main-default text_color_inactive']");

    private By retrievePasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void signUp(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void showPassword() {
        driver.findElement(showPasswordButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(signInButton).click();
    }

    public void clickSignUpLink() {
        driver.findElement(signUpLink).click();
    }

    public void clickRetrievePasswordLink() {
        driver.findElement(retrievePasswordLink).click();
    }
}

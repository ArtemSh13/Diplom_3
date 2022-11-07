package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    public final static String SIGN_UP_PAGE_URL = ConstructorPage.MAIN_PAGE_URL + "/register";

    private WebDriver driver;

    private Header header;

    private By registrationLabel = By.xpath(".//h2[text()='Регистрация']");

    private By registrationFields = By.xpath(".//input[@class='text input__textfield text_type_main-default']");

    private int registrationFieldsNameFieldIndex = 0;

    private int registrationFieldsEmailFieldIndex = 1;

    private int registrationFieldsPasswordFieldIndex = 2;

    private By incorrectPasswordLabel = By.xpath(".//p[text()='Некорректный пароль']");

    private By showPasswordButton = By.xpath(".//div[@class='input__icon input__icon-action']");

    private By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");

    private By alreadySignedUpLabel = By.xpath(".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']");

    private By userAlreadyExistsLabel = By.xpath(".//p[text()='Такой пользователь уже существует']");
    private By signInLink = By.xpath(".//a[text()='Войти']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
    }

    public void enterName(String name) {
        driver.findElements(registrationFields).get(registrationFieldsNameFieldIndex).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElements(registrationFields).get(registrationFieldsEmailFieldIndex).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElements(registrationFields).get(registrationFieldsPasswordFieldIndex).sendKeys(password);
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void clickSignInLink() {
        driver.findElement(signInLink).click();
    }

    public boolean isPasswordCorrect() {
        return !(driver.findElement(incorrectPasswordLabel).isDisplayed());
    }

    public boolean isUserAlreadySignedUp() {
        return driver.findElement(userAlreadyExistsLabel).isDisplayed();
    }

    public void signUp(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickSignUpButton();
    }

}

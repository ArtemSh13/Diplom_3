package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRetrievalPage {

    public final static String PASSWORD_RETRIEVAL_PAGE_URL = ConstructorPage.MAIN_PAGE_URL + "/forgot-password";

    private WebDriver driver;

    public final Header header;

    private By passwordRetrievalLabel = By.xpath(".//h2[text()='Восстановление пароля']");

    private By emailField = By.xpath(".//input[@class='text input__textfield text_type_main-default']");

    private By retrieveButton = By.xpath(".//button[text()='Восстановить']");

    private By rememberPasswordLabel = By.xpath(".//p[@class='undefined text text_type_main-default text_color_inactive mb-4']");

    private By signInLink = By.xpath(".//a[text()='Войти']");

    public PasswordRetrievalPage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickRetrieveButton() {
        driver.findElement(retrieveButton).click();
    }

    public void clickSignInLink() {
        driver.findElement(signInLink).click();
    }
}

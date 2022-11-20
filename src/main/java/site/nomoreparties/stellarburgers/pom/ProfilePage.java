package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    public static final String PROFILE_PAGE_URL = ConstructorPage.MAIN_PAGE_URL + "/account/profile";

    private WebDriver driver;

    public final Header header;

    private By profileLink = By.xpath(".//a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9']");

    private By profileFields = By.xpath(".//a[@class='text input__textfield text_type_main-default input__textfield-disabled']");
    private By editButtons = By.xpath(".//div[@class='input__icon input__icon-action']");

    private int profileFieldsNameFieldIndex = 0;

    private int editButtonsNameEditButtonIndex = 0;

    private int profileFieldsEmailFieldIndex = 1;

    private int editButtonsEmailEditButtonIndex = 1;

    private int profileFieldsPasswordFieldIndex = 2;

    private int editButtonsPasswordEditButtonIndex = 2;

    private By cancelLink = By.xpath(".//button[text()='Отмена']");

    private By saveButton = By.xpath(".//button[text()='Сохранить']");

    private By ordersHistoryLink = By.xpath(".//a[text()='История заказов']");

    private By ordersHistoryArea = By.xpath(".//a[@class='OrderHistory_link__1iNby']");

    private By signOutButton = By.xpath(".//button[text()='Выход']");

    private By infoLabel = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
    }

    public void profileLinkClick() {
        driver.findElement(profileLink).click();
    }

    public void editButtonsNameEditButtonIndexClick() {
        driver.findElements(editButtons).get(editButtonsNameEditButtonIndex).click();
    }

    public void editButtonsEmailEditButtonIndexClick() {
        driver.findElements(editButtons).get(editButtonsEmailEditButtonIndex).click();
    }

    public void editButtonsPasswordEditButtonIndexClick() {
        driver.findElements(editButtons).get(editButtonsPasswordEditButtonIndex).click();
    }

    public void cancelLinkClick() {
        driver.findElement(cancelLink).click();
    }

    public void saveButtonClick() {
        driver.findElement(saveButton).click();
    }

    public void ordersHistoryLinkClick() {
        driver.findElement(ordersHistoryLink).click();
    }

    public void signOutLinkClick() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe(PROFILE_PAGE_URL));
        driver.findElement(signOutButton).click();
    }

    public void enterNameField(String input) {
        driver.findElements(profileFields).get(profileFieldsNameFieldIndex).sendKeys(input);
    }

    public void enterEmailField(String input) {
        driver.findElements(profileFields).get(profileFieldsEmailFieldIndex).sendKeys(input);
    }

    public void enterPasswordField(String input) {
        driver.findElements(profileFields).get(profileFieldsPasswordFieldIndex).sendKeys(input);
    }

}

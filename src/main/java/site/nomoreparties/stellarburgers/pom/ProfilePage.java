package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    public static final String PROFILE_PAGE_URL = ConstructorPage.MAIN_PAGE_URL + "/account/profile";

    private WebDriver driver;

    private By profileLink = By.xpath(".//a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9']");

    private By profileFields = By.xpath(".//a[@class='text input__textfield text_type_main-default input__textfield-disabled']");
    private By editButtons = By.xpath(".//div[@class='input__icon input__icon-action']");

    private int profileFieldsNameFieldIndex = 0;

    private int editButtonsNameEditButtonIndex = 0;

    private int profileFieldsEmailFieldIndex = 1;

    private int editButtonsEmailEditButtonIndex = 1;

    private int profileFieldsPasswordFieldIndex = 2;

    private int editButtonsPasswordEditButtonIndex = 2;

    private By cancelLink = By.className("button_button__33qZ0 button_button_type_secondary__3-tsA button_button_size_medium__3zxIa");

    private By saveButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa");

    private By ordersHistoryLink = By.className("Account_link__2ETsJ text text_type_main-medium text_color_inactive");

    private By ordersHistoryArea = By.xpath(".//a[@class='OrderHistory_link__1iNby']");

    private By signOutLink = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    private By infoLabel = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
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
        driver.findElement(signOutLink).click();
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

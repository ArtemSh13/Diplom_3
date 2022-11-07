package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site";

    private WebDriver driver;

    private Header header;

    private By assembleBurgerLabel = By.className("text text_type_main-large mb-5 mt-10");

    private By bunsTab = By.xpath(".//span[text()='Булки']");

    private By saucesTab = By.xpath(".//span[text()='Соусы']");

    private By stuffingTab = By.xpath(".//span[text()='Начинки']");

    private By bunsHeader = By.xpath(".//h2[text()='Булки']");

    private By burgerIngredientAreas = By.className("BurgerIngredients_ingredients__list__2A-mT");

    private By saucesHeader = By.xpath(".//h2[text()='Соусы']");

    private By stuffingHeader = By.xpath(".//h2[text()='Начинки']");

    private By burgerConstructorArea = By.className("BurgerConstructor_basket__list__l9dp_");

    private By totalLabel = By.className("text text_type_digits-medium mr-3");

    private By signInOrOrderButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
        header = new Header(driver);
    }

    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }

    public void clickSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    public void clickStuffingTab() {
        driver.findElement(stuffingTab).click();
    }

    public int getTotal() {
        return Integer.parseInt(driver.findElement(totalLabel).getText());
    }

    public boolean isSignedIn() {
        return driver.findElement(signInOrOrderButton).getText().equals("Оформить заказ");
    }

    public void clickSignInOrOrderButton() {
        driver.findElement(signInOrOrderButton).click();
    }

}

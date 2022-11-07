package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    private WebDriver driver;

    private By headerLinks = By.className("AppHeader_header__linkText__3q_va ml-2");

    private int constructorButtonIndex = 0;

    private int ordersFeedButtonIndex = 1;

    private By stellarBurgersLink = By.className("AppHeader_header__logo__2D0X2");

    private int profileLinkIndex = 2;

    public void clickConstructorButton() {
        driver.findElements(headerLinks).get(constructorButtonIndex).click();
    }

    public void clickOrdersFeedButton() {
        driver.findElements(headerLinks).get(ordersFeedButtonIndex).click();
    }

    public void clickStellarBurgersLink() {
        driver.findElement(stellarBurgersLink).click();
    }

    public void clickPersonalAreaLink() {
        driver.findElements(headerLinks).get(profileLinkIndex).click();
    }
}

package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.MessageFormat;

public class Header {

    private WebDriver driver;

    private By stellarBurgersLink = By.className("AppHeader_header__logo__2D0X2");

    private String headerElementsXpath = ".//*[@class='AppHeader_header__linkText__3q_va ml-2' and text()={0}]";

    private By headerConstructorButton = By.xpath(MessageFormat.format(headerElementsXpath,"'Конструктор"));
    private By headerFeedButton = By.xpath(MessageFormat.format(headerElementsXpath,"'Лента Заказов'"));
    private By headerProfileButton = By.xpath(MessageFormat.format(headerElementsXpath,"'Личный Кабинет'"));

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructorButton() {
        driver.findElement(headerConstructorButton).click();
    }

    public void clickOrdersFeedButton() {
        driver.findElement(headerFeedButton).click();
    }

    public void clickStellarBurgersLink() {
        driver.findElement(stellarBurgersLink).click();
    }

    public void clickPersonalAreaLink() {
        driver.findElement(headerProfileButton).click();
    }
}

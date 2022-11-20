package site.nomoreparties.stellarburgers.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    private WebDriver driver;

    private By stellarBurgersLink = By.className("AppHeader_header__logo__2D0X2");

    private String headerElementsXpath = ".//*[@class='AppHeader_header__linkText__3q_va ml-2' and text()=";
    private By headerConstructorButton = By.xpath(headerElementsXpath + "'Конструктор']");
    private By headerFeedButton = By.xpath(headerElementsXpath + "'Лента Заказов']");
    private By headerProfileButton = By.xpath(headerElementsXpath + "'Личный Кабинет']");

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

    public void clickProfileButton() {
        driver.findElement(headerProfileButton).click();
    }
}

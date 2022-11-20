import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.pom.ConstructorPage;
import site.nomoreparties.stellarburgers.pom.SignInPage;
import site.nomoreparties.stellarburgers.pom.SignUpPage;

import java.util.Random;

public class ConstructorTest {

    private WebDriver driver;
    private SignUpPage signUpPage;
    private SignInPage signInPage;
    private String name;
    private String email;
    private String password;
    private Random random;

    @Before
    public void setUp() {
        random = new Random();
        name = "name" + random.nextInt();
        email = "some" + random.nextInt() + "@yandex.ru";
        password = "qW-1234";
        driver = new ChromeDriver();
        driver.get(SignUpPage.SIGN_UP_PAGE_URL);
        signUpPage = new SignUpPage(driver);
        System.out.println("Pseudorandom name is " + name);
        System.out.println("Pseudorandom email is " + email);
        signUpPage.signUp(name, email, password);
        driver.get(SignInPage.LOG_IN_PAGE_URL);
    }

    // переход по клику на «Конструктор»
    @Test
    public void goToConstructorPageViaConstructorClick() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(email, password);
        signInPage.header.clickProfileButton();
        signInPage.header.clickConstructorButton();
    }

    // переход по клику на логотип Stellar Burgers
    @Test
    public void goToConstructorPageViaLogoClick() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(email, password);
        signInPage.header.clickProfileButton();
        signInPage.header.clickStellarBurgersLogo();
    }

    // переход к разделу «Булки»
    @Test
    public void goToBunsTab() {
        driver.get(ConstructorPage.MAIN_PAGE_URL);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickStuffingTab();
        constructorPage.clickBunsTab();
    }

    // переход к разделу «Соусы»
    @Test
    public void goToSaucesTab() {
        driver.get(ConstructorPage.MAIN_PAGE_URL);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSaucesTab();
    }

    // переход к разделу «Начинки»
    @Test
    public void goToStuffingTab() {
        driver.get(ConstructorPage.MAIN_PAGE_URL);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickStuffingTab();
    }

    @After
    public void teardown() {
        driver.quit();
    }


}

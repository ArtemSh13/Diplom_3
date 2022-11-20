import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.pom.ConstructorPage;
import site.nomoreparties.stellarburgers.pom.PasswordRetrievalPage;
import site.nomoreparties.stellarburgers.pom.SignInPage;
import site.nomoreparties.stellarburgers.pom.SignUpPage;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SignInTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    // вход по кнопке «Войти в аккаунт» на главной
    @Test
    public void signInViaButtonOnConstructorPage() {
        driver.get(ConstructorPage.MAIN_PAGE_URL);
        driver.manage().window().maximize();
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSignInOrOrderButton();
        assertEquals("The Sign Up page isn't opened", SignInPage.LOG_IN_PAGE_URL, driver.getCurrentUrl());
    }

    // вход через кнопку «Личный кабинет»
    @Test
    public void signInViaProfileButton() {
        driver.get(ConstructorPage.MAIN_PAGE_URL);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.header.clickProfileButton();
        assertEquals("The Sign Up page isn't opened", SignInPage.LOG_IN_PAGE_URL, driver.getCurrentUrl());
    }

    // вход через кнопку в форме регистрации
    @Test
    public void signInViaLinkOnSignUpPage() {
        driver.get(SignUpPage.SIGN_UP_PAGE_URL);
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSignInLink();
        assertEquals("The Sign Up page isn't opened", SignInPage.LOG_IN_PAGE_URL, driver.getCurrentUrl());
    }

    // вход через кнопку в форме восстановления пароля
    @Test
    public void signInViaLinkOnPasswordRetrievalPage() {
        driver.get(PasswordRetrievalPage.PASSWORD_RETRIEVAL_PAGE_URL);
        PasswordRetrievalPage passwordRetrievalPage = new PasswordRetrievalPage(driver);
        passwordRetrievalPage.clickSignInLink();
        assertEquals("The Sign Up page isn't opened", SignInPage.LOG_IN_PAGE_URL, driver.getCurrentUrl());
    }

    // авторизация только что зарегистрированного юзера
    @Test
    public void signInJustSignedUpUser() {
        Random random = new Random();
        String name = "name" + random.nextInt();
        String email = "some" + random.nextInt() + "@yandex.ru";
        String password = "qW-1234";
        System.out.println("Pseudorandom name is " + name);
        System.out.println("Pseudorandom email is " + email);
        driver.get(SignUpPage.SIGN_UP_PAGE_URL);
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp(name, email, password);
        driver.get(SignInPage.LOG_IN_PAGE_URL);
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(email, password);
    }


    @After
    public void teardown() {
        driver.quit();
    }


}

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.pom.ConstructorPage;
import site.nomoreparties.stellarburgers.pom.SignInPage;
import site.nomoreparties.stellarburgers.pom.SignUpPage;

import java.util.Random;

public class ProfileTest {

    private WebDriver driver;
    private SignUpPage signUpPage;
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
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(email, password);
    }

    @Test
    public void goToProfileViaHeaderLink() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.header.clickProfileButton();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}

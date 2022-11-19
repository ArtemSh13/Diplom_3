import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.pom.SignUpPage;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SignUpTest {

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
        System.out.println("Pseudorandom name is " + name);
        email = "some" + random.nextInt() + "@yandex.ru";
        System.out.println("Pseudorandom email is " + email);
        driver = new ChromeDriver();
        driver.get(SignUpPage.SIGN_UP_PAGE_URL);
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void successfulRegistrationTest() {
        password = "qWe-rTY-123";
        signUpPage.signUp(name, email, password);
        assertTrue("A valid password marked as invalid", signUpPage.isPasswordCorrect());
        assertFalse("Not registered user marked as registered", signUpPage.isUserAlreadySignedUp());
        assertTrue("Sign In page isn't opened", driver.findElement(By.xpath(".//div[@class='Auth_login__3hAey']")).isDisplayed());
    }

    @Test
    public void failedRegistrationWithInvalidPasswordTest() {
        password = "1234";
        signUpPage.signUp(name, email, password);
        assertFalse("No message about invalid password", signUpPage.isPasswordCorrect());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

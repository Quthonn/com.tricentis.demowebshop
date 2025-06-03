package uiTests;
import config.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class Auth extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Feature("Тестирование авторизации")
    @Story("Пользователь авторизуется вводом почты и пароля")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("positive")
    @Test
    @DisplayName("Тест авторизации на сайт")
    @Owner("Quthon")
    @Description("Этот тест проверяет, что пользователь может авторизоваться.")
    public void auth() {
        loginPage.openLoginPage()
                .setMail(MAIL)
                .setPassword(PASSWORD)
                .loginButtonClick()
                .checkAuth(MAIL);
    }
}

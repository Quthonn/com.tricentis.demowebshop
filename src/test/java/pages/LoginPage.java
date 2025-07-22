package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {
    private SelenideElement
    openLoginPageClick = $(".ico-login"),
    mailClick = $("#Email"),
    passwordClick = $("#Password"),
    loginButton = $(".login-button"),
    mail = $$("a[href='/customer/info']").get(0);

    public LoginPage openSite() {
        Allure.step("Открытие сайта", () -> {
            open("/");
        });
        return this;
    }

    public LoginPage openLoginPage() {
        Allure.step("Переход в окно авторизации", () -> {
            openLoginPageClick.click();
        });
        return this;
    }

    public LoginPage setMail(String value) {
        Allure.step("Ввод почты", () -> {
            mailClick.setValue(value);
        });
        return this;
    }

    public LoginPage setPassword(String value) {
        Allure.step("Ввод пароля", () -> {
            passwordClick.setValue(value);
        });
        return this;
    }

    public LoginPage loginButtonClick() {
        Allure.step("Нажать кнопку 'Log in'", () -> {
            loginButton.click();
        });
        return this;
    }

    public LoginPage checkAuth(String value) {
        Allure.step("Проверка авторизации", () -> {
            assertEquals(value,
                    mail.getText());
        });
        return this;
    }
}

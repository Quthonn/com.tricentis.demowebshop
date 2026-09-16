package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {
    private SelenideElement
    openLoginPageClick = $(".ico-login"),
    mailClick = $("#Email"),
    passwordClick = $("#Password"),
    loginButton = $(".login-button"),
    mail = $$("a[href='/customer/info']").get(0);

    @Step("Открыть сайт")
    public LoginPage openSite() {
        open("/");

        return this;
    }

    @Step("Переход в окно авторизации")
    public LoginPage openLoginPage() {
        openLoginPageClick.click();

        return this;
    }

    @Step("Ввод почты")
    public LoginPage setMail(String value) {
        mailClick.setValue(value);

        return this;
    }

    @Step("Ввод пароля")
    public LoginPage setPassword(String value) {
        passwordClick.setValue(value);

        return this;
    }

    @Step("Нажать кнопку 'Log in'")
    public LoginPage loginButtonClick() {
        loginButton.click();

        return this;
    }

    @Step("Проверка авторизации")
    public LoginPage checkAuth(String value) {
        assertEquals(value, mail.getText());

        return this;
    }
}

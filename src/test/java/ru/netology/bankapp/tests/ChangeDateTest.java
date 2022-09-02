package ru.netology.bankapp.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.bankapp.data.DataGenerator;
import ru.netology.bankapp.data.UserInfo;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ChangeDateTest {
    UserInfo user;

    @BeforeEach
    public void Preps() {
        user = DataGenerator.User.generateUser("ru", 7, 8);
        open("http://localhost:9999");
    }

    @Test
    void shouldSendFormWithCorrectData() {
        $("[data-test-id=\"city\"] input").setValue(user.getCity());
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] input").setValue(user.getFirstDate());
        $("[data-test-id=\"name\"] input").setValue(user.getName());
        $("[data-test-id=\"phone\"] input").setValue(user.getPhoneNumber());
        $("[data-test-id=\"agreement\"]").click();
        $(".grid-col .button").click();
        $("[data-test-id=\"success-notification\"] .notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + user.getFirstDate()), Duration.ofSeconds(15))
                .shouldBe(visible);
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=\"date\"] input").setValue(user.getSecondDate());
        $(".grid-col .button").click();
        $("[data-test-id=\"replan-notification\"] .notification__content").shouldHave(Condition.text("У вас уже запланирована встреча на другую дату. Перепланировать?"), Duration.ofSeconds(15))
                .shouldBe(visible);
        $(".notification__content .button").click();
        $("[data-test-id=\"success-notification\"] .notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + user.getSecondDate()), Duration.ofSeconds(15))
                .shouldBe(visible);
    }
}

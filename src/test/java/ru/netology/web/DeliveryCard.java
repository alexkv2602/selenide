package ru.netology.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.BACK_SPACE;

class DeliveryCard {
    @Test
    void shouldDeliveryFormWorks() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("span[data-test-id = city]").click();
        $("input[placeholder=Город]").setValue("Москва");
        $("span[class=menu-item__control]").click();
        // get current date + 3 days
        LocalDate currentDate = LocalDate.now().plusDays(4);
        String expectedDate = currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        $x("//input[@placeholder='Дата встречи']").sendKeys(BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE, BACK_SPACE);
        $x("//input[@placeholder='Дата встречи']").setValue(expectedDate);
        $x("//td[@class='calendar__day calendar__day_state_current']").click();
        $("span[data-test-id=name]").click();
        $("input[name=name]").setValue("Иванушки Интернешнл");
        $("span[data-test-id=phone]").click();
        $("input[name=phone]").setValue("+98765432101");
        $("label[data-test-id=agreement]").click();
        $x("//span[contains(text(), 'Забронировать')]").click();
        $(withText("Успешно!")).should(appear,Duration.ofSeconds(11));
        $x("//div[contains(text(), 'Успешно!')]");
    }
}


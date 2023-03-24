package ru.netology.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String getDate(int daysToAdd) {
        LocalDate currentDate = LocalDate.now().plusDays(daysToAdd);
        return currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

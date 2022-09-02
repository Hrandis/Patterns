package ru.netology.bankapp.data;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class User {
        public static UserInfo generateUser(String locale, int dayShift1, int dayShift2) {
            Faker faker = new Faker(new Locale(locale));
            return new UserInfo(faker.address().cityName(),
                    LocalDate.now().plusDays(dayShift1).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    LocalDate.now().plusDays(dayShift2).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }
    }
}

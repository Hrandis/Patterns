package ru.netology.bankapp.data;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class User {
        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new UserInfo(faker.address().cityName(),
                    LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    LocalDate.now().plusDays(8).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }
    }
}

package ru.yandex.praktikum;

import org.apache.commons.lang3.RandomStringUtils;

public class UserAccountData {
    private final String loginJson;
    private final String passwordJson;
    private final String nameJson;
    private final String email;
    private final String password;
    private final String name;
    private final String passwordIncorrect;

    public UserAccountData() {
        email = "mishas@mail.ru";
        password = "43215ww";
        name = "Mikle";
        passwordIncorrect = RandomStringUtils.randomAlphabetic(5);
        loginJson = "\"email\": \"" + email;
        nameJson = "\"name\": \"" + name;
        passwordJson = "\"password\": \"" + password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordJson() {
        return passwordJson;
    }

    public String getNameJson() {
        return nameJson;
    }

    public String getLoginJson() {
        return loginJson;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordIncorrect() {
        return passwordIncorrect;
    }
}



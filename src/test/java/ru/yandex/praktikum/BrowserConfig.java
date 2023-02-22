package ru.yandex.praktikum;

import org.aeonbits.owner.Config;

public interface BrowserConfig extends Config {

    @DefaultValue("Chrome")
    String browser();
}

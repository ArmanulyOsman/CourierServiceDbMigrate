package com.example.courierservicedbmigrate.model;

import lombok.Getter;

@Getter
public enum CourierPushNotification {

    NEW_TASK_NOTIFICATION("Новое отправление", "Вам назначено новое отправление №"),
    CANCEL_TASK_NOTIFICATION("Отмена отправления", "Отменено отправление №");

    private final String title;
    private final String message;

    CourierPushNotification(String title, String message) {
        this.title = title;
        this.message = message;
    }
}


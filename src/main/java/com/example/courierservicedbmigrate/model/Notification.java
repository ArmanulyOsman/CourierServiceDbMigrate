package com.example.courierservicedbmigrate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Notification {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("task_id")
    private Long taskId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("message")
    private String message;

    @JsonProperty("is_read")
    private Boolean isRead;

    @JsonProperty("notification_type")
    private CourierPushNotification notificationType;

    @JsonProperty("created_by")
    private Long createdBy;

    @JsonProperty("created_date")
    private String createdDate;

    @JsonProperty("last_modified_by")
    private Long lastModifiedBy;

    @JsonProperty("last_modified_date")
    String lastModifiedDate;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getRead() {
        return isRead;
    }

    public CourierPushNotification getNotificationType() {
        return notificationType;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", isRead=" + isRead +
                ", notificationType='" + notificationType + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate='" + createdDate + '\'' +
                ", lastModifiedBy=" + lastModifiedBy +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                '}';
    }
}

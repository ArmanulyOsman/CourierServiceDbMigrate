package com.example.courierservicedbmigrate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attribute {
    @JsonProperty("task_id")
    private Long taskId;

    public Long getTaskId() {
        return taskId;
    }

    public Attribute(Long taskId) {
        this.taskId = taskId;
    }
}

package com.example.courierservicedbmigrate.service;

import com.example.courierservicedbmigrate.model.Attribute;
import com.example.courierservicedbmigrate.model.CourierPushNotification;
import com.example.courierservicedbmigrate.model.FinalMessage;
import com.example.courierservicedbmigrate.model.Notification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MigrateService {

    private final String RESOURCE_NAME = "/notification-local.json";
    private final long NEW_TASK_TEMPLATE_ID = 3L;
    private final long CANCEL_TASK_TEMPLATE_ID = 4L;

    ObjectWriter ow = new ObjectMapper().writer();

    public List<Notification> readNotification() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Notification>> typeReference = new TypeReference<>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream(RESOURCE_NAME);
        try {
            List<Notification> notifications = objectMapper.readValue(inputStream,typeReference);

            for (Notification notification : notifications) {
                System.out.println("Readed notification: {}" +  notification.toString());
            }

            return notifications;
        } catch (IOException e){
            System.out.println(("Unable to save file: {}" + e.getMessage()));
        }
        return null;
    }

    public void writeInsertsToFile(List<Notification> notifications) throws IOException {
        for (Notification notification : notifications) {
            var query = mapToPush(notification);
            writeToFile(query);
            System.out.println("Written: " + query);
        }
    }

    private String mapToPush(Notification notification) throws JsonProcessingException {
        String sqlQuery = "INSERT INTO push (created_date, read_date, " +
                "user_id, message_template_id, attributes, final_message, status) VALUES (";

        StringBuilder writer = new StringBuilder();
        writer.append(sqlQuery);
        writer.append("'" + notification.getCreatedDate() + "', ");

        writer.append(getReadDate(notification.getLastModifiedDate()));

        writer.append(notification.getUserId() + ", ");

        long template_id = notification.getNotificationType() == CourierPushNotification.NEW_TASK_NOTIFICATION
                ? NEW_TASK_TEMPLATE_ID
                : CANCEL_TASK_TEMPLATE_ID;
        writer.append(template_id + ", ");

        writer.append("'" + ow.writeValueAsString(new Attribute(notification.getBarcode())) + "', ");

        writer.append("'" + ow.writeValueAsString(new FinalMessage(notification.getMessage())) + "', ");

        String status = notification.getRead() ? "READ" : "SENT";
        writer.append("'" + status + "' ); ");

        return writer.toString();
    }

    private String getReadDate(String lastModifiedDate) {
        if (lastModifiedDate == null) {
            return "null, ";
        }
        return "'" + lastModifiedDate + "', ";
    }

    public void writeToFile(String content) throws IOException {
        File file = new File("output/data.txt"); // можно задать любую папку
        file.getParentFile().mkdirs(); // создаёт директории, если их нет

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(content);
            writer.newLine();
        }
    }
}

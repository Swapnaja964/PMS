package com.pm.analyticsservice.kafka;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import patient.events.PatientEvent;

@Component
public class PatientEventsListener {
    private static final Logger log = LoggerFactory.getLogger(PatientEventsListener.class);

    @KafkaListener(topics = "patient", groupId = "analytics-service")
    public void onMessage(ConsumerRecord<String, String> record) {
        try {
            String base64Value = record.value();
            byte[] bytes = Base64.getDecoder().decode(base64Value);
            PatientEvent event = PatientEvent.parseFrom(bytes);
            log.info("Analytics received patient event [offset={}, partition={}]: patientId={}, name={}, email={}, type={}",
                    record.offset(), record.partition(), event.getPatientId(), event.getName(), event.getEmail(), event.getEventType());
        } catch (Exception ex) {
            log.warn("Analytics failed to decode value at offset {}: {}", record.offset(), record.value(), ex);
        }
    }
}

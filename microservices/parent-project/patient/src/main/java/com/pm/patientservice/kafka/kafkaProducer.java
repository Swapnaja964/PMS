package com.pm.patientservice.kafka;

import java.util.Base64;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.pm.patientservice.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import patient.events.PatientEvent;

@Service
public class kafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public kafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Patient patient)
    {
        PatientEvent event = PatientEvent.newBuilder()
        .setPatientId(patient.getId().toString())
        .setName(patient.getName())
        .setEmail(patient.getEmail())
        .setEventType("PATIENT_CREATED")
        .build();

        try{
            String base64Value = Base64.getEncoder().encodeToString(event.toByteArray());
            kafkaTemplate.send("patient", base64Value);
        }catch(Exception e)
        {
            LoggerFactory.getLogger(kafkaProducer.class).error("Error sending PatientCreated event: {}", event, e);
        }
    }
}

package com.pm.patientservice.mapper;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient) {

        PatientResponseDTO dto = new PatientResponseDTO();

        dto.setId(
            patient.getId() != null ? patient.getId().toString() : null
        );

        dto.setName(patient.getName());
        dto.setEmail(patient.getEmail());
        dto.setAddress(patient.getAddress());

        dto.setDateOfBirth(
            patient.getDateOfBirth() != null 
                ? patient.getDateOfBirth().toString() 
                : null
        );
        System.out.println(patient.getName());
        return dto;
    }
}

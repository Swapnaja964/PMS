package com.pm.patientservice.mapper;
import java.time.LocalDate;

import com.pm.patientservice.dto.PatientRequestDTO;
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

    public static Patient toModel(PatientRequestDTO patientRequestDTO) 
    {
    Patient patient = new Patient();
    patient.setName(patientRequestDTO.getName());
    patient.setAddress(patientRequestDTO.getAddress());
    patient.setEmail(patientRequestDTO.getEmail());
    patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
    patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
    return patient;
    }
}

package com.pm.patientservice.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pm.patientservice.model.patient;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<patient, UUID> {

}

package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PatientTest {
    @Test
    void testCanCreatePatient() {
        Patient patient = Patient.createDeveloper("Carlos", List.of(Patient.Symptom.LACK_OF_SLEEP));
        assertThat(patient).isNotNull();
    }

    @Test
    void testPatientCanChangeStatusToHealthy() {
        Patient patient = Patient.createDeveloper("Carlos", List.of(Patient.Symptom.ALCOHOL_DEPENDENT));
        patient.changeToHealthy();
        assertThat(patient.isSick()).isFalse();
    }

    @Test
    void PatientEnterAsSick() {
        Patient patient = Patient.createDeveloper("Carlos", List.of(Patient.Symptom.LACK_OF_SLEEP));
        assertThat(patient.isSick()).isTrue();
    }

    @Test
    void someSymptomsAreConsideredAsHealthyStatus() {
        Patient patient = Patient.createDeveloper("Carlos", List.of(Patient.Symptom.ALCOHOL_DEPENDENT));
        assertThat(patient.isSick()).isFalse();
    }

    @Test
    void givenAPatientItNeedToHasSymptoms() {
        Patient patient = Patient.createDeveloper("Carlos", List.of(Patient.Symptom.ALCOHOL_DEPENDENT));
        Assertions.assertThat(patient.getSymptoms()).isNotEmpty();
        Assertions.assertThat(patient.getSymptoms().get(0)).isEqualTo(Patient.Symptom.ALCOHOL_DEPENDENT);
    }
}

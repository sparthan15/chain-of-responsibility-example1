package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HospitalTest {

    @Test
    void canCreateHospital() {
        Hospital hospital = Hospital.create("Acme");
        Assertions.assertThat(hospital).isNotNull();
    }

    @Test
    void hospitalCanReceivePatients() {
        Hospital hospital = Hospital.create("Acme");
        hospital.receive(Patient.createDeveloper("Navneet", List.of(Patient.Symptom.LACK_OF_SLEEP)));
        Assertions.assertThat(hospital.getPatients()).isNotEmpty();
    }

    @Test
    void givenTheHospitalReceivePatientsTheyGotHealthyAfterTreatment() {
        Hospital hospital = Hospital.create("Acme");
        hospital.receive(Patient.createDeveloper("Navneet", List.of(Patient.Symptom.LACK_OF_SLEEP)));
        hospital.receive(Patient.createDeveloper("Navneet", List.of(Patient.Symptom.ALCOHOL_DEPENDENT)));
        hospital.receive(Patient.createDeveloper("Navneet", List.of(Patient.Symptom.EXCESS_OF_MONEY)));
        hospital.attend();
        Assertions.assertThat(hospital.getPatients()
                        .stream()
                        .noneMatch(p -> p.isSick()))
                .isFalse();
    }
}

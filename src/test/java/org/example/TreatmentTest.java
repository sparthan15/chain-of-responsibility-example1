package org.example;

import org.example.treatment.Treatment;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TreatmentTest {
    @Test
    void insomniaCanBeTreated() {
        Patient insomniaPatient = Patient.createDeveloper("Durga", List.of(Patient.Symptom.LACK_OF_SLEEP));
        Treatment insomnia = Treatment.insomnia();
        assertThat(insomniaPatient).isNotNull();
        insomnia.treat(insomniaPatient);
        assertThat(insomniaPatient.isSick()).isFalse();
    }
    @Test
    void crazinessCanBeTreated(){
        Patient crazyPatient = Patient.createDeveloper("Durga", List.of(Patient.Symptom.EXCESS_OF_MONEY));
        Treatment craziness = Treatment.craziness();
        assertThat(crazyPatient).isNotNull();
        craziness.treat(crazyPatient);
        assertThat(crazyPatient.isSick()).isFalse();
    }
    @Test
    void healthyPatientCanBeTreated(){
        Patient healthyPatient = Patient.createDeveloper("Durga", List.of(Patient.Symptom.ALCOHOL_DEPENDENT));
        assertThat(healthyPatient).isNotNull();
        Treatment.healthiness().treat(healthyPatient);
        assertThat(healthyPatient.isSick()).isFalse();
    }
    @Test
    void crazinessCanNotBeTreatedWithInsomniaTreatment(){
        Patient crazyPatient = Patient.createDeveloper("Durga", List.of(Patient.Symptom.EXCESS_OF_MONEY));
        assertThat(crazyPatient).isNotNull();
        Treatment.insomnia().treat(crazyPatient);
        assertThat(crazyPatient.isSick()).isTrue();
    }
    @Test
    void lackOfSleepCanNotBeTreatedWithCrazinessTreatment(){
        Patient insomniaPatient = Patient.createDeveloper("Durga", List.of(Patient.Symptom.LACK_OF_SLEEP));
        assertThat(insomniaPatient).isNotNull();
        Treatment.craziness().treat(insomniaPatient);
        assertThat(insomniaPatient.isSick()).isTrue();
    }
}

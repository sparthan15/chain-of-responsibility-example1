package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SymptomsTest {
    @Test
    void canCreateSymptoms(){
        Patient.Symptom s = Patient.Symptom.ALCOHOL_DEPENDENT;
        assertThat(s).isNotNull();

    }
}

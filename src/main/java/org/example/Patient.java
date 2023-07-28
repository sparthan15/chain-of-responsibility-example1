package org.example;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Patient {
    private final String name;
    private List<Symptom> symptoms;
    private PatientStatus status;

    public boolean isSick() {
        return this.status.equals(PatientStatus.SICK);
    }

    public void changeToHealthy() {
        this.status = PatientStatus.HEALTHY;
    }

    enum PatientStatus {
        SICK, HEALTHY;
    }

    public enum Symptom {
        LACK_OF_SLEEP,
        ALCOHOL_DEPENDENT,
        EXCESS_OF_MONEY;
    }

    public static Patient createDeveloper(String name, List<Symptom> symptoms) {
        PatientStatus status = symptoms.contains(Symptom.ALCOHOL_DEPENDENT) ? PatientStatus.HEALTHY : PatientStatus.SICK;
        return new Patient(name, symptoms, status);
    }
}

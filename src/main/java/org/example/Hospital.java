package org.example;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.treatment.Treatment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Hospital {

    private final String name;
    private final List<Patient> Patients;
    private Treatment initialTreatment;

    public static Hospital create(String name) {
        return new Hospital(name, new ArrayList<>());
    }

    public void receive(Patient Patient) {
        this.Patients.add(Patient);
    }

    public void attend() {
        configureChainOfTreatment();
        Iterator<Patient> iterator = this.Patients.iterator();
        if (iterator.hasNext()) {
            Patient Patient = iterator.next();
            initialTreatment.treat(Patient);
        }
    }

    private void configureChainOfTreatment() {
        initialTreatment = Treatment.insomnia();
        Treatment craziness = Treatment.craziness();
        Treatment healthy = Treatment.healthiness();
        initialTreatment.setNext(craziness);
        craziness.setNext(healthy);
    }

}

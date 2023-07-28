package org.example.treatment;


import org.example.Patient;

public class Insomnia extends BaseTreatment {

    @Override
    public void treat(Patient patient) {
        if (canTreat(patient)) {
            //do some work for treat the patient
            patient.changeToHealthy();
        } else {
            forward(patient);
        }
    }

    @Override
    protected boolean canTreat(Patient patient) {
        return patient.getSymptoms().contains(Patient.Symptom.LACK_OF_SLEEP);
    }
}

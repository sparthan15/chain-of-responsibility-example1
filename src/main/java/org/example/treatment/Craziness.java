package org.example.treatment;

import org.example.Patient;

class Craziness extends BaseTreatment {

    @Override
    public void treat(Patient patient) {
        if (canTreat(patient)) {
            //do something here for make the patient healthy
            patient.changeToHealthy();
        } else {
            forward(patient);
        }
    }

    @Override
    protected boolean canTreat(Patient patient) {
        return patient.getSymptoms().contains(Patient.Symptom.EXCESS_OF_MONEY);
    }
}

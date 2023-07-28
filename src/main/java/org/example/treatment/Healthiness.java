package org.example.treatment;

import org.example.Patient;

class Healthiness extends BaseTreatment {

    @Override
    public void treat(Patient patient) {
        if (canTreat(patient)) {
            //patient.changeToHealthy();
            //if needed patient could be diagnosed as sick...
        } else {
            forward(patient);
        }
    }

    @Override
    protected boolean canTreat(Patient patient) {
        return patient.getSymptoms().contains(Patient.Symptom.ALCOHOL_DEPENDENT);
    }
}

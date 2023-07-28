package org.example.treatment;

import org.example.Patient;

public interface Treatment {
    static Treatment insomnia() {
        return new Insomnia();
    }

    static Treatment craziness() {
        return new Craziness();
    }

    static Treatment healthiness() {
        return new Healthiness();
    }

    void setNext(Treatment treatment);

    void treat(Patient Patient);
}

package org.example.treatment;

import lombok.Getter;
import org.example.Patient;

@Getter
public abstract class BaseTreatment implements Treatment {

    protected Treatment next;

    @Override
    public void setNext(Treatment treatment) {
        this.next = treatment;
    }

    protected abstract boolean canTreat(Patient Patient);

    protected void forward(Patient Patient) {
        if (next != null)
            next.treat(Patient);
    }
}

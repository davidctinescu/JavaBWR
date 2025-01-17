package com.dev.javabwr;

import com.dev.javabwr.PTable;

public class Atom {
    private final PTable element;
    private final int neutrons;

    public Atom(PTable element, int neutrons) {
        this.element = element;
        this.neutrons = neutrons;
    }

    public PTable getElement() {
        return element;
    }

    public int getNeutrons() {
        return neutrons;
    }

    public int getMassNumber() {
        return element.getAtomicNumber() + neutrons;
    }

    public double getNeutronToProtonRatio() {
        return (double) neutrons / element.getAtomicNumber();
    }

    public boolean isStable() {
        int protons = element.getAtomicNumber();
        double ratio = getNeutronToProtonRatio();

        if (protons <= 20) {
            return ratio >= 0.9 && ratio <= 1.1;
        } else if (protons <= 50) {
            return ratio >= 1.2 && ratio <= 1.4;
        } else if (protons <= 82) {
            return ratio >= 1.3 && ratio <= 1.5;
        } else {
            return false;
        }
    }

    public String predictDecayType() {
        if (isStable()) {
            return "Stable isotope, no decay.";
        }

        int protons = element.getAtomicNumber();
        double ratio = getNeutronToProtonRatio();

        if (protons > 82) {
            return "Likely alpha decay (too heavy).";
        } else if (ratio > 1.2) {
            return "Likely beta-minus decay (too many neutrons).";
        } else if (ratio < 1.0) {
            return "Likely beta-plus decay or electron capture (too few neutrons).";
        } else {
            return "Unstable, but decay mode uncertain.";
        }
    }

    @Override
    public String toString() {
        return String.format("Atom: %s\nAtomic Number: %d\nNeutrons: %d\nMass Number: %d\nNeutron-to-Proton Ratio: %.2f\nStability: %s\nDecay Type: %s",
                element.getName(),
                element.getAtomicNumber(),
                neutrons,
                getMassNumber(),
                getNeutronToProtonRatio(),
                isStable() ? "Stable" : "Unstable",
                predictDecayType());
    }
}

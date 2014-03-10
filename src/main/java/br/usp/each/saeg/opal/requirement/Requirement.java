package br.usp.each.saeg.opal.requirement;

public class Requirement {

    private boolean covered;

    public Requirement() {
        covered = false;
    }

    public void cover() {
        covered = true;
    }

    public boolean isCovered() {
        return covered;
    }

}

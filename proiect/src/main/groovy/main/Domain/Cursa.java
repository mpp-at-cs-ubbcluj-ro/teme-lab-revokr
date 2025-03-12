package main.Domain;

public class Cursa {
    String id;
    String nume;
    String capacitateMotor;
    Integer nrParticipantiPosibili;

    public Cursa(String id, String nume, String capacitateMotor, Integer nrParticipantiPosibili) {
        this.id = id;
        this.nume = nume;
        this.capacitateMotor = capacitateMotor;
        this.nrParticipantiPosibili = nrParticipantiPosibili;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCapacitateMotor() {
        return capacitateMotor;
    }

    public void setCapacitateMotor(String capacitateMotor) {
        this.capacitateMotor = capacitateMotor;
    }

    public Integer getNrParticipantiPosibili() {
        return nrParticipantiPosibili;
    }

    public void setNrParticipantiPosibili(Integer nrParticipantiPosibili) {
        this.nrParticipantiPosibili = nrParticipantiPosibili;
    }
}

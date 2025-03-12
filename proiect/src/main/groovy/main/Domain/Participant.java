package main.Domain;

public class Participant {
    String id;
    String name;
    String CNP;
    String capacitateMotor;
    String echipa;

    public Participant(String id, String name, String CNP, String capacitateMotor, String echipa) {
        this.id = id;
        this.name = name;
        this.CNP = CNP;
        this.capacitateMotor = capacitateMotor;
        this.echipa = echipa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getCapacitateMotor() {
        return capacitateMotor;
    }

    public void setCapacitateMotor(String capacitateMotor) {
        this.capacitateMotor = capacitateMotor;
    }

    public String getEchipa() {
        return echipa;
    }

    public void setEchipa(String echipa) {
        this.echipa = echipa;
    }
}

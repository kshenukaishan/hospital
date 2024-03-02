package models;

public class Doctor {

    private int id;
    private String doctor_name;
    private String specialty;

    public Doctor() {
    }

    public Doctor(int id, String doctor_name, String specialty) {
        this.id = id;
        this.doctor_name = doctor_name;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", doctor_name='" + doctor_name + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}

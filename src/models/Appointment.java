package models;

public class Appointment {

    private int id;
    private int doctor_id;
    private int patient_id;
    private String date_time;

    public Appointment() {
    }

    public Appointment(int id, int doctor_id, int patient_id, String date_time) {
        this.id = id;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.date_time = date_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctor_id=" + doctor_id +
                ", patient_id=" + patient_id +
                ", date_time='" + date_time + '\'' +
                '}';
    }
}

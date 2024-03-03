package dto;

public class PatientDto {

    private int id;
    private String patient_name;
    private int age;
    private String address;

    public PatientDto() {
    }

    public PatientDto(int id, String patient_name, int age, String address) {
        this.id = id;
        this.patient_name = patient_name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "id=" + id +
                ", patient_name='" + patient_name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

package sections;

import models.Patient;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PatientMenu {

    public static void patientSection(List<Patient> patients, Scanner input){

        String[] patientsMenuItems = new String[6];
        patientsMenuItems[0] = "(1) Add Patient";
        patientsMenuItems[1] = "(2) Find Patient";
        patientsMenuItems[2] = "(3) Update Patient";
        patientsMenuItems[3] = "(4) Delete Patient";
        patientsMenuItems[4] = "(5) View All Patients";
        patientsMenuItems[5] = "(6) Exit";

        while(true){
            int selectedInput = MainMenu.printMenu(patientsMenuItems, input);

            switch(selectedInput){
                case 0:
                    addPatients(patients, input);
                    break;
                case 1:
                    findPatientById(patients, input);
                    break;
                case 2:
                    updatePatient(patients, input);
                    break;
                case 3:
                    deletePatient(patients, input);
                    break;
                case 4:
                    viewAllPatients(patients);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void viewAllPatients(List<Patient> patients) {
        patients.stream().forEach(System.out::println);
    }

    private static void deletePatient(List<Patient> patients, Scanner input) {
        System.out.println("Enter Patient id in order to Delete!");
        int id = input.nextInt();
        patients.stream().filter(patient -> patient.getId() == id).findFirst();
        System.out.println("Patient has deleted!");
        patients.stream().forEach(System.out::println);
    }

    private static void updatePatient(List<Patient> patients, Scanner input) {
        System.out.println("Enter the id in order to Update");
        int id = input.nextInt();
        Patient patientToUpdate = patients.get(id - 1);

        boolean updateStatus = true;

        while (updateStatus){
            System.out.println("Enter new Name");
            String newName = input.nextLine();
            patientToUpdate.setPatient_name(newName);
            input.nextLine();

            System.out.println("Enter new Age");
            int newAge = input.nextInt();
            patientToUpdate.setAge(newAge);
            input.nextLine();

            System.out.println("Enter new Address");
            String newAddress = input.nextLine();
            patientToUpdate.setAddress(newAddress);

            System.out.println("Patient updated successfully!");
            updateStatus = false;
        }
        patients.stream().forEach(System.out::println);
    }

    private static void findPatientById(List<Patient> patients, Scanner input) {
        System.out.println("Enter Patient id in order to Display!");
        int id = input.nextInt();
        Optional<Patient> patientFind = patients.stream().filter(patient -> patient.getId() == id).findFirst();
        System.out.println(patientFind);
    }

    private static void addPatients(List<Patient> patients, Scanner input) {
        boolean addStatus = true;
        while (addStatus){

            Patient patient = new Patient();
            System.out.println("Enter patient id");
            int id = input.nextInt();
            patient.setId(id);
            input.nextLine();

            System.out.println("Enter patient name");
            String name = input.nextLine();
            patient.setPatient_name(name);

            System.out.println("Enter patient age");
            int age = input.nextInt();
            patient.setAge(age);
            input.nextLine();

            System.out.println("Enter patient address");
            String address = input.nextLine();
            patient.setAddress(address);
            patients.add(patient);

            System.out.println("Patient added successfully!");

            System.out.println("Need to add another patient?");
            System.out.println("(1) Yes");
            System.out.println("(2) No");
            int answer = input.nextInt();

            if (answer != 1) {
                addStatus = false;
            } else {
                addStatus = true;
            }
        }
        patients.stream().forEach(System.out::println);
    }
}

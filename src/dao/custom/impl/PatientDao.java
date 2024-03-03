package dao.custom.impl;

import dao.CrudDao;
import models.Patient;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PatientDao implements CrudDao<Patient> {

    @Override
    public void viewAll(List<Patient> list) {
        list.forEach(System.out::println);
    }

    @Override
    public void delete(List<Patient> list, Scanner input) {
        System.out.println("Enter Patient id in order to Delete!");
        int id = input.nextInt();
        list.stream().filter(patient -> patient.getId() == id).findFirst();
        System.out.println("Patient has deleted!");
        list.stream().forEach(System.out::println);
    }

    @Override
    public void update(List<Patient> list, Scanner input) {
        System.out.println("Enter the id in order to Update");
        int id = input.nextInt();
        Patient patientToUpdate = list.get(id - 1);

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
        list.stream().forEach(System.out::println);
    }

    @Override
    public void findById(List<Patient> list, Scanner input) {
        System.out.println("Enter Patient id in order to Display!");
        int id = input.nextInt();
        Optional<Patient> patientFind = list.stream().filter(patient -> patient.getId() == id).findFirst();
        System.out.println(patientFind);
    }

    @Override
    public void add(List<Patient> list, Scanner input) {
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
            list.add(patient);

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
        list.stream().forEach(System.out::println);
    }
}

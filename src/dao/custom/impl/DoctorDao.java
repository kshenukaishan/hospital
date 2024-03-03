package dao.custom.impl;

import dao.CrudDao;
import models.Doctor;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DoctorDao implements CrudDao<Doctor> {

    @Override
    public void viewAll(List<Doctor> list) {
        list.stream().forEach(System.out::println);
    }

    @Override
    public void delete(List<Doctor> list, Scanner input) {
        System.out.println("Enter the Doctor's ID");
        int id = input.nextInt();
        list.stream().filter(doctor -> doctor.getId() != id).forEach(System.out::println);
        Doctor doctor = list.get(id - 1);
        list.remove(doctor);
        System.out.println("Doctor has deleted!");
    }

    @Override
    public void update(List<Doctor> list, Scanner input) {
        System.out.println("Enter doctor ID for Updating!");
        int id = input.nextInt();
        Doctor doctor = list.get(id - 1);

        boolean updateStatus = true;

        while(updateStatus){
            System.out.println("Enter new Name");
            String newName = input.nextLine();
            doctor.setDoctor_name(newName);
            input.nextLine();

            System.out.println("Enter new Specialty");
            String newSpecialty = input.nextLine();
            doctor.setSpecialty(newSpecialty);

            System.out.println("Doctor updated successfully!");

            updateStatus = false;
        }
        list.stream().forEach(System.out::println);
    }

    @Override
    public void findById(List<Doctor> list, Scanner input) {
        System.out.println("Enter the Doctor ID to display");
        int id = input.nextInt();
        Optional<Doctor> doctorFind = list.stream().filter(doctor -> doctor.getId() == id).findFirst();
        System.out.println(doctorFind);
    }

    @Override
    public void add(List<Doctor> list, Scanner input) {
        boolean addStatus = true;

        while(addStatus){

            Doctor doctor = new Doctor();
            System.out.println("Enter Doctor's ID");
            int id = input.nextInt();
            doctor.setId(id);
            input.nextLine();

            System.out.println("Enter Doctor's name");
            String name = input.nextLine();
            doctor.setDoctor_name(name);

            System.out.println("Enter the specialty");
            String specialty = input.nextLine();
            doctor.setSpecialty(specialty);
            list.add(doctor);

            System.out.println("Doctor has added successfully!");

            System.out.println("Need to add another Doctor?");
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

package dao.custom.impl;

import dao.CrudDao;
import dao.custom.AppointmentDao;
import models.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AppointmentDaoImpl implements AppointmentDao {

    @Override
    public void viewAll(List<Appointment> list) {
        list.stream().forEach(System.out::println);
    }

    @Override
    public void delete(List<Appointment> list, Scanner input) {
        System.out.println("Enter the appointment ID");
        int id = input.nextInt();
        list.stream().filter(appointment -> appointment.getId() != id).forEach(System.out::println);
        Appointment appointment = list.get(id - 1);
        list.remove(appointment);
        System.out.println("Appointment has deleted!");
    }

    @Override
    public void update(List<Appointment> list, Scanner input) {
        System.out.println("Enter Appointment ID for update");
        int id = input.nextInt();
        Appointment appointmentUpdate = list.get(id);

        boolean updateStatus = true;

        while(updateStatus){

            System.out.println("Enter new DoctorId");
            int newDoctorId = input.nextInt();
            appointmentUpdate.setDoctor_id(newDoctorId);
            input.nextLine();

            System.out.println("Enter new PatientId");
            int newPatientId = input.nextInt();
            appointmentUpdate.setPatient_id(newPatientId);
            input.nextLine();

            System.out.println("Enter new date-time");
            String newDateTime = input.nextLine();
            appointmentUpdate.setDate_time(newDateTime);
            input.nextLine();

            System.out.println("Appointment has updated");
            updateStatus = false;
        }
        list.stream().forEach(System.out::println);
    }

    @Override
    public void findById(List<Appointment> list, Scanner input) {
        System.out.println("Enter Appointment Id to find");
        int id = input.nextInt();
        Optional<Appointment> appointmentToFind = list.stream().filter(appointment -> appointment.getId() == id).findFirst();
        System.out.println(appointmentToFind);
    }

    @Override
    public void add(List<Appointment> list, Scanner input) {
        boolean addStatus = true;

        while(addStatus){

            Appointment appointment = new Appointment();

            System.out.println("Enter Appointment Id");
            int id = input.nextInt();
            appointment.setId(id);
            input.nextLine();

            System.out.println("Enter Doctor's id");
            int doctorsId = input.nextInt();
            appointment.setDoctor_id(doctorsId);
            input.nextLine();

            System.out.println("Enter Patient's id");
            int patientId = input.nextInt();
            appointment.setPatient_id(patientId);
            input.nextLine();

            System.out.println("Enter the date");
            String date = input.nextLine();
            appointment.setDate_time(date);

            list.add(appointment);

            System.out.println("Appointment has added!");

            System.out.println("Need to add another appointment?");
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

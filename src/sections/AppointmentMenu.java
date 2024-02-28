package sections;

import models.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AppointmentMenu {

    public static void appointmentSection(List<Appointment> appointments, Scanner input){

        String[] appointmentsMenuItems = new String[6];

        appointmentsMenuItems[0] = "(1) Add Appointments";
        appointmentsMenuItems[1] = "(2) Find Appointments";
        appointmentsMenuItems[2] = "(3) Update Appointments";
        appointmentsMenuItems[3] = "(4) Delete Appointments";
        appointmentsMenuItems[4] = "(5) View All DAppointments";
        appointmentsMenuItems[5] = "(6) Exit";

        while(true){

            int selectedMenuItem = MainMenu.printMenu(appointmentsMenuItems, input);

            switch (selectedMenuItem){
                case 0:
                    addAppointment(appointments, input);
                    break;
                case 1:
                    findAppointmentById(appointments, input);
                    break;
                case 2:
                    updateAppointment(appointments, input);
                    break;
                case 3:
                    deleteAppointment(appointments, input);
                    break;
                case 4:
                    viewAllAppointments(appointments);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void viewAllAppointments(List<Appointment> appointments) {
        appointments.stream().forEach(System.out::println);
    }

    private static void deleteAppointment(List<Appointment> appointments, Scanner input) {
        System.out.println("Enter the appointment ID");
        int id = input.nextInt();
        appointments.stream().filter(appointment -> appointment.getId() != id).findFirst();
        Appointment appointment = appointments.get(id - 1);
        appointments.remove(appointment);
        System.out.println("Appointment has deleted!");
    }

    private static void updateAppointment(List<Appointment> appointments, Scanner input) {
        System.out.println("Enter Appointment ID for update");
        int id = input.nextInt();
        Appointment appointmentUpdate = appointments.get(id);

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
        appointments.stream().forEach(System.out::println);
    }

    private static void findAppointmentById(List<Appointment> appointments, Scanner input) {
        System.out.println("Enter Appointment Id to find");
        int id = input.nextInt();
        Optional<Appointment> appointmentToFind = appointments.stream().filter(appointment -> appointment.getId() == id).findFirst();
        System.out.println(appointmentToFind);
    }

    private static void addAppointment(List<Appointment> appointments, Scanner input) {
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

            appointments.add(appointment);

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
        appointments.stream().forEach(System.out::println);
    }
}

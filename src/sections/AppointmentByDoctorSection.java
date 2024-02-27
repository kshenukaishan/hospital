package sections;

import models.Appointment;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppointmentByDoctorSection {

    public static void viewAppointmentsByDoctorId(List<Appointment> appointments, Scanner input){

        System.out.println("Enter the doctor's ID");

        int id = input.nextInt();

        appointments.stream()
                .filter(appointment -> appointment.getDoctor_id() == id)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

}

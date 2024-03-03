package sections;

import dao.custom.impl.AppointmentDaoImpl;
import models.Appointment;

import java.util.List;
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
        new AppointmentDaoImpl().viewAll(appointments);
    }

    private static void deleteAppointment(List<Appointment> appointments, Scanner input) {
       new AppointmentDaoImpl().delete(appointments, input);
    }

    private static void updateAppointment(List<Appointment> appointments, Scanner input) {
        new AppointmentDaoImpl().update(appointments, input);
    }

    private static void findAppointmentById(List<Appointment> appointments, Scanner input) {
       new AppointmentDaoImpl().findById(appointments, input);
    }

    private static void addAppointment(List<Appointment> appointments, Scanner input) {
        new AppointmentDaoImpl().add(appointments, input);
    }
}

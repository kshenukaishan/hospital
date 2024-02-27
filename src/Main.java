import models.Appointment;
import models.Doctor;
import models.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hospital Management System");

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Hospital Management System.");

        String[] menuItems = new String[5];

        List<Patient> patients = new ArrayList<>();
        List<Doctor> doctors = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();

        menuItems[0] = "(1) Patients Management";
        menuItems[1] = "(2) Doctors Management";
        menuItems[2] = "(3) Appointments Management";
        menuItems[3] = "(4) View Appointments by Doctor's ID";
        menuItems[4] = "(5) Exit";

        while(true){

            int selectedInput = 0;

            switch (selectedInput){
                case 0:
                    System.out.println("You are in Patients Section");
                    break;
                case 1:
                    System.out.println("You are in Doctors Section");
                    break;
                case 2:
                    System.out.println("You are in Appointments Section");
                    break;
                case 3:
                    System.out.println("View All Appointments by Doctors ID");
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
            }
        }

    }
}

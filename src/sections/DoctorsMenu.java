package sections;

import models.Doctor;

import java.util.List;
import java.util.Scanner;

public class DoctorsMenu {

    public static void doctorSection(List<Doctor> doctors, Scanner input){

        String[] doctorsMenuItems = new String[6];

        doctorsMenuItems[0] = "(1) Add Doctor";
        doctorsMenuItems[1] = "(2) Find Doctor";
        doctorsMenuItems[2] = "(3) Update Doctor";
        doctorsMenuItems[3] = "(4) Delete Doctor";
        doctorsMenuItems[4] = "(5) View All Doctors";
        doctorsMenuItems[5] = "(6) Exit";

    }

}

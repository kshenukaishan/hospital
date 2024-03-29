package sections;

import bo.BoFactory;
import bo.custom.DoctorBo;
import dao.DaoFactory;
import dao.custom.DoctorDao;
import models.Doctor;

import java.util.List;
import java.util.Scanner;

public class DoctorsMenu {

    private static DoctorBo doctorBo = BoFactory.getBo(BoFactory.BoType.DOCTOR);

    public static void doctorSection(List<Doctor> doctors, Scanner input){

        String[] doctorsMenuItems = new String[6];

        doctorsMenuItems[0] = "(1) Add Doctor";
        doctorsMenuItems[1] = "(2) Find Doctor";
        doctorsMenuItems[2] = "(3) Update Doctor";
        doctorsMenuItems[3] = "(4) Delete Doctor";
        doctorsMenuItems[4] = "(5) View All Doctors";
        doctorsMenuItems[5] = "(6) Exit";

        subMenuSection(doctors, input, doctorsMenuItems);

    }

    private static void subMenuSection(List<Doctor> doctors, Scanner input, String[] doctorsMenuItems) {
        while(true){

            int selectedMenuItem = MainMenu.printMenu(doctorsMenuItems, input);

            switch (selectedMenuItem){
                case 0:
                    addDoctors(doctors, input);
                    break;
                case 1:
                    findDoctorById(doctors, input);
                    break;
                case 2:
                    updateDoctor(doctors, input);
                    break;
                case 3:
                    deleteDoctor(doctors, input);
                    break;
                case 4:
                    viewAllDoctors(doctors);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void viewAllDoctors(List<Doctor> doctors) {
        doctorBo.viewAll(doctors);
    }

    private static void deleteDoctor(List<Doctor> doctors, Scanner input) {
        doctorBo.delete(doctors, input);
    }

    private static void updateDoctor(List<Doctor> doctors, Scanner input) {
        doctorBo.update(doctors, input);
    }

    private static void findDoctorById(List<Doctor> doctors, Scanner input) {
        doctorBo.findById(doctors, input);
    }
    private static void addDoctors(List<Doctor> doctors, Scanner input) {
        doctorBo.add(doctors, input);
    }
}

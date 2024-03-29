package sections;

import bo.BoFactory;
import bo.custom.PatientBo;
import dao.DaoFactory;
import dao.custom.PatientDao;
import models.Patient;

import java.util.List;
import java.util.Scanner;

public class PatientMenu {

    private static PatientBo patientBo = BoFactory.getBo(BoFactory.BoType.PATIENT);

    public static void patientSection(List<Patient> patients, Scanner input){

        String[] patientsMenuItems = new String[6];
        patientsMenuItems[0] = "(1) Add Patient";
        patientsMenuItems[1] = "(2) Find Patient";
        patientsMenuItems[2] = "(3) Update Patient";
        patientsMenuItems[3] = "(4) Delete Patient";
        patientsMenuItems[4] = "(5) View All Patients";
        patientsMenuItems[5] = "(6) Exit";

        subMenuSection(patients, input, patientsMenuItems);
    }

    private static void subMenuSection(List<Patient> patients, Scanner input, String[] patientsMenuItems) {
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
        patientBo.viewAll(patients);
    }

    private static void deletePatient(List<Patient> patients, Scanner input) {
        patientBo.delete(patients, input);
    }

    private static void updatePatient(List<Patient> patients, Scanner input) {
        patientBo.update(patients, input);
    }

    private static void findPatientById(List<Patient> patients, Scanner input) {
        patientBo.findById(patients, input);
    }

    private static void addPatients(List<Patient> patients, Scanner input) {
        patientBo.add(patients, input);
    }
}

package dao;

import models.Patient;

import java.util.List;
import java.util.Scanner;

public interface CrudDao<T> {

    void viewAll(List<T> patients);
    void deletePatient(List<T> patients, Scanner input);
    void updatePatient(List<T> patients, Scanner input);
    void findPatientById(List<T> patients, Scanner input);
    void addPatients(List<T> patients, Scanner input);

}

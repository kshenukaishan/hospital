package bo.custom.impl;

import bo.custom.PatientBo;
import dao.DaoFactory;
import dao.custom.PatientDao;
import models.Patient;

import java.util.List;
import java.util.Scanner;

public class PatientBoImpl implements PatientBo {

    private PatientDao patientDao = DaoFactory.getDao(DaoFactory.DaoType.PATIENT);

    @Override
    public void viewAll(List<Patient> list) {
        patientDao.viewAll(list);
    }

    @Override
    public void delete(List<Patient> list, Scanner input) {
        patientDao.delete(list, input);
    }

    @Override
    public void update(List<Patient> list, Scanner input) {
        patientDao.update(list, input);
    }

    @Override
    public void findById(List<Patient> list, Scanner input) {
        patientDao.findById(list, input);
    }

    @Override
    public void add(List<Patient> list, Scanner input) {
        patientDao.add(list, input);
    }
}

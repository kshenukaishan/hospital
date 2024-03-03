package bo.custom.impl;

import bo.custom.DoctorBo;
import dao.DaoFactory;
import dao.custom.DoctorDao;
import models.Doctor;

import java.util.List;
import java.util.Scanner;

public class DoctorBoImpl implements DoctorBo {

    private DoctorDao doctorDao = DaoFactory.getDao(DaoFactory.DaoType.DOCTOR);

    @Override
    public void viewAll(List<Doctor> list) {
        doctorDao.viewAll(list);
    }

    @Override
    public void delete(List<Doctor> list, Scanner input) {
        doctorDao.delete(list, input);
    }

    @Override
    public void update(List<Doctor> list, Scanner input) {
        doctorDao.update(list, input);
    }

    @Override
    public void findById(List<Doctor> list, Scanner input) {
        doctorDao.findById(list, input);
    }

    @Override
    public void add(List<Doctor> list, Scanner input) {
        doctorDao.add(list, input);
    }
}

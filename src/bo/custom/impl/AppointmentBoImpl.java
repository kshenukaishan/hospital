package bo.custom.impl;

import bo.custom.AppointmentBo;
import dao.DaoFactory;
import dao.custom.AppointmentDao;
import models.Appointment;

import java.util.List;
import java.util.Scanner;

public class AppointmentBoImpl implements AppointmentBo {

    private AppointmentDao appointmentDao = DaoFactory.getDao(DaoFactory.DaoType.APPOINTMENT);

    @Override
    public void viewAll(List<Appointment> list) {
        appointmentDao.viewAll(list);
    }

    @Override
    public void delete(List<Appointment> list, Scanner input) {
        appointmentDao.delete(list, input);
    }

    @Override
    public void update(List<Appointment> list, Scanner input) {
        appointmentDao.update(list, input);
    }

    @Override
    public void findById(List<Appointment> list, Scanner input) {
        appointmentDao.findById(list, input);
    }

    @Override
    public void add(List<Appointment> list, Scanner input) {
        appointmentDao.add(list, input);
    }
}

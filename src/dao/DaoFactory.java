package dao;

import dao.impl.AppointmentDao;
import dao.impl.DoctorDao;
import dao.impl.PatientDao;

public class DaoFactory {

    private DaoFactory daoFactory;

    private DaoFactory(){

    }

    public enum DaoType{
        PATIENT, DOCTOR, APPOINTMENT;
    }

    public static <T> T getDao(DaoType daoType){
        switch (daoType){
            case PATIENT:
                return (T) new PatientDao();
            case DOCTOR:
                return (T) new DoctorDao();
            case APPOINTMENT:
                return (T) new AppointmentDao();
            default:
                return null;
        }
    }
}

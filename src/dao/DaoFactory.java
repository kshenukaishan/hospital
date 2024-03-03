package dao;

import dao.custom.impl.AppointmentDaoImpl;
import dao.custom.impl.DoctorDaoImpl;
import dao.custom.impl.PatientDaoImpl;

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
                return (T) new PatientDaoImpl();
            case DOCTOR:
                return (T) new DoctorDaoImpl();
            case APPOINTMENT:
                return (T) new AppointmentDaoImpl();
            default:
                return null;
        }
    }
}

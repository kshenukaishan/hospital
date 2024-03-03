package bo;

import bo.custom.impl.AppointmentBoImpl;
import bo.custom.impl.DoctorBoImpl;
import bo.custom.impl.PatientBoImpl;

public class BoFactory {

    private BoFactory boFactory;

    private BoFactory(){

    }

    public enum BoType{
        PATIENT, DOCTOR, APPOINTMENT
    }

    public static <T> T getBo(BoType boType){
        switch (boType){
            case PATIENT:
                return (T) new PatientBoImpl();
            case DOCTOR:
                return (T) new DoctorBoImpl();
            case APPOINTMENT:
                return (T) new AppointmentBoImpl();
            default:
                return null;
        }
    }

}

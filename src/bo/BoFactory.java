package bo;

public class BoFactory {

    private BoFactory boFactory;

    private BoFactory(){

    }

    public enum BoType{
        PATIENT, DOCTOR, APPOINTMENT
    }

    public static <T> T getBo(BoType boType){
        return null;
    }

}

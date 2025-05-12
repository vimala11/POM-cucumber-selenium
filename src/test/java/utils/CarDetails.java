package utils;

import java.util.List;

public class CarDetails {
    private final String regNo;
    private final String makeModel;
    private final String year;

    private static List<String> registrationsList;

    public CarDetails(String regNo, String makeModel, String year) {
        this.regNo = regNo;
        this.makeModel = makeModel;
        this.year = year;
    }

    public String getRegNo() {
            return regNo;
        }

    public String getMakeModel() {
            return makeModel;
        }

    public String getYear() {return year; }

    public static void setRegistrations(List<String> registrations) {
        registrationsList = registrations;
    }
    public static List<String> getRegistrations() {
        return registrationsList;
    }

}

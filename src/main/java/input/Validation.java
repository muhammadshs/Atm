package input;

import exp.InvalidInputException;

public class Validation {
    public static int valInt(Object value){
        int num;
        try {
            num=(int) value;
        }
        catch (Exception e){
            throw new InvalidInputException();
        }
        return num;
    }
    public static String valStr(Object value){
        String val;
        try {
            val=(String) value;
        }
        catch (Exception e){
            throw new InvalidInputException();
        }
        return val;
    }
    public static double valDouble(Object value){
        double num;
        try {
            num=(double) value;
        }
        catch (Exception e){
            throw new InvalidInputException();
        }
        return num;
    }
}

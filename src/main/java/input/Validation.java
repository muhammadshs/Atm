package input;

import exp.InvalidInputException;

public class Validation {
    public static int valInt(String value){

            char[] ch = value.toCharArray();
            for (char cha : ch) {
                try {
                    int a = (int) cha;
                } catch (Exception e) {
                    return -1;
                }

            }
            return Integer.parseInt(value);

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

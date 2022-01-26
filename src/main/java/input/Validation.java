package input;

import exp.InvalidInputException;

public class Validation {
    public static int valInt(String value) throws InvalidInputException{

            char[] ch = value.toCharArray();
            for (char cha : ch) {
                try {
                    int a = (int) cha;
                } catch (Exception e) {
                    throw new InvalidInputException();

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
    public static double valDouble(String value){
        char[] ch = value.toCharArray();
        for (char cha : ch) {
            try {
                double a = (double) cha;
            } catch (Exception e) {
                throw new InvalidInputException();

            }

        }
        return Double.parseDouble(value);
    }
}

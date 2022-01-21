public class Util {
    public static boolean checkNumeric (String message) {
        char[] ch = message.toCharArray();
        for (char cha : ch) {
            try {
                int a = (int) cha;
            } catch (Exception e) {
                return false;
            }

        }
        return true;
    }

}
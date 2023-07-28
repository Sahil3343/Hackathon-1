import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Question_6 {

    public static int TotalDecodes(String InputString) {
        try {
            int[] Result = new int[InputString.length() + 1];
            Result[0] = 1;
            Result[1] = 1;

            for (int i = 2; i <= InputString.length(); i++) {
                int Digit = Integer.parseInt(InputString.substring(i - 1, i));
                if (Digit >= 1 && Digit <= 9) {
                    Result[i] = Result[i] + Result[i - 1];
                }

                int TwoDigits = Integer.parseInt(InputString.substring(i - 2, i));
                if (TwoDigits >= 10 && TwoDigits <= 26) {
                    Result[i] = Result[i] + Result[i - 2];
                }
            }

            return Result[InputString.length()];
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {
        String InputString = "123";
        System.out.println("Possibilities - " + TotalDecodes(InputString));
    }
}

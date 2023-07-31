import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Question_6 {

    public static int TotalDecodes(String InputString) {
        try {
            //Initiating Result List.
            int[] Result = new int[InputString.length() + 1];
            //Setting Result[0] as 1 because is empty string is present then only 1 possible solution.
            Result[0] = 1;
            //Setting Result[1] as 1 because if string consists 1 integer then only 1 possible solution.
            Result[1] = 1;

            //Iterating the string
            for (int i = 2; i <= InputString.length(); i++) {
                //Logic for single digits.
                //Using substrings to retrieve single digit.
                int Digit = Integer.parseInt(InputString.substring(i - 1, i));
                //checking if the digit is between 1 and 9 (inclusive)
                if (Digit >= 1 && Digit <= 9) {
                    Result[i] = Result[i] + Result[i - 1];
                }

                //Logic for two digits.
                //Using substring to retrieve two digits.
                int TwoDigits = Integer.parseInt(InputString.substring(i - 2, i));
                //Checking if the two-digit number is between 10 and 26 (inclusive)
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
        System.out.println("Input String - " + InputString); //123
        System.out.println("Possibilities - " + TotalDecodes(InputString)); //Expected Output - 3
    }
}

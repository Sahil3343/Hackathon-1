public class Question_2 {

    private static String ZipString(String InputString) {
        try {
            //Checking if the string has only 1 character
            if (InputString.length() == 1) {
                return InputString + 1;
            }

            int CharCount = 0;
            StringBuilder OutputString = new StringBuilder();

            //Iterating the string
            for (int i = 0; i < InputString.length() - 1; i++) {
                //Getting Current Character
                char CurrentChar = InputString.charAt(i);

                //Checking if the next char is same as CurrentChar
                while (i < InputString.length() && InputString.charAt(i) == CurrentChar) {
                    CharCount++;
                    i++;
                }

                //Appending the result
                OutputString.append(CurrentChar).append(CharCount);
                CharCount = 0;
                i--;
            }

            return OutputString.toString();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return "Error";
        }
    }

    public static void main(String[] args) {
        String InputString = "aabbbbbttttdlll";  //aabbbbbttttdlll
        System.out.println("Input String - " + InputString); //Input - aabbbbbttttdlll
        System.out.println("Output String - " + ZipString(InputString)); //Expected Output - a2b5t4d1l3

    }
}

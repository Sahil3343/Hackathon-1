import java.util.ArrayList;
import java.util.Arrays;

public class Question_4 {



    private static double TypingTime(String[] InputWords, char[] RightHand, char[] LeftHand) {
        try {
            String PreviousHand = "";
            ArrayList<String> PreviousWords = new ArrayList<>();
            ArrayList<Double> TimeTaken = new ArrayList<>();
            double TotalTimeTaken = 0;

            for (int i = 0; i < InputWords.length; i++) {
                //Checking if word already written or not
                if (!PreviousWords.isEmpty() && PreviousWords.contains(InputWords[i])) {
                    int Index = PreviousWords.indexOf(InputWords[i]);
                    double Time = TimeTaken.get(Index) / 2;
                    PreviousWords.add(InputWords[i]);
                    TimeTaken.add(Time);
                    TotalTimeTaken = TotalTimeTaken + Time;
                } else {
                    double TempTime = 0;
                    String CurrentWord = InputWords[i];
                    //Iterating the word to calculate time
                    for (int j = 0; j < InputWords[i].length(); j++) {
                        int Find = Arrays.binarySearch(RightHand, CurrentWord.charAt(j));
                        if (j == 0) {
                            TempTime = 0.2;

                            if (Find >= 0) {
                                PreviousHand = "RIGHT";
                            } else {
                                PreviousHand = "LEFT";
                            }
                        } else {
                            if (Find >= 0 && PreviousHand.equals("RIGHT")) {
                                //Same Hand (Right)
                                TempTime = TempTime + 0.4;
                                PreviousHand = "RIGHT";
                            } else if (Find < 0 && PreviousHand.equals("LEFT")) {
                                //Same Hand (Left)
                                TempTime = TempTime + 0.4;
                                PreviousHand = "LEFT";
                            } else if (Find < 0 && PreviousHand.equals("RIGHT")) {
                                //Different Hand (Right to left)
                                TempTime = TempTime + 0.2;
                                PreviousHand = "LEFT";
                            } else {
                                //Different Hand (Left to Right)
                                TempTime = TempTime + 0.2;
                                PreviousHand = "RIGHT";
                            }
                        }
                    }

                    TotalTimeTaken = TotalTimeTaken + TempTime;
                    PreviousWords.add(InputWords[i]);
                    TimeTaken.add(TempTime);
                }
            }

            return TotalTimeTaken;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {
        String[] InputWords = new String[] { "fdjkd", "dfjdk", "dfd", "fdjkd", "kkjjk" };
        char[] RightHand = new char[] { 'j', 'k' };
        char[] LeftHand = new char[] { 'd', 'f' };
        System.out.println("Time Taken - " + TypingTime(InputWords, RightHand, LeftHand) + " seconds");
    }
}

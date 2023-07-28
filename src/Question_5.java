import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.stream.Collectors;

public class Question_5 {

    private final static String MANUTD = "manutd";
    private final static String ARSENAL = "arsenal";
    private final static String LYON = "lyon";
    private final static String FCBARCA = "fcbarca";
    private final static String A = "A";
    private final static String B = "B";
    private final static String C = "C";
    private final static String D = "D";



    private static void FirstSecondPlace(String[][] InputMatch, int[][] InputGoals) {
        try {
            HashMap<String, Integer> TeamWinning = new HashMap<>();
            HashMap<String, Integer> GoalDifference = new HashMap<>();

            TeamWinning.put(A, 0);
            TeamWinning.put(B, 0);
            TeamWinning.put(C, 0);
            TeamWinning.put(D, 0);

            GoalDifference.put(A, 0);
            GoalDifference.put(B, 0);
            GoalDifference.put(C, 0);
            GoalDifference.put(D, 0);

//        TeamWinning.put(MANUTD, 0);
//        TeamWinning.put(ARSENAL, 0);
//        TeamWinning.put(LYON, 0);
//        TeamWinning.put(FCBARCA, 0);
//
//        GoalDifference.put(MANUTD, 0);
//        GoalDifference.put(ARSENAL, 0);
//        GoalDifference.put(LYON, 0);
//        GoalDifference.put(FCBARCA, 0);

            for (int i = 0; i < InputMatch.length; i++) {
                String[] CurrentMatch = InputMatch[i];
                int[] CurrentScore = InputGoals[i];
                for (int j = 0; j < CurrentMatch.length - 1; j++) {
                    String WinnerTeam = "";
                    String LoserTeam = "";
                    int WinnerScore = -1;
                    int LoserScore = -1;
                    boolean TieFlag = false;
                    //Checking which score is higher
                    if (CurrentScore[j] > CurrentScore[j + 1]) {
                        //First team has won
                        WinnerScore = CurrentScore[j];
                        LoserScore = CurrentScore[j + 1];
                        WinnerTeam = CurrentMatch[j];
                        LoserTeam = CurrentMatch[j + 1];
                        TieFlag = false;
                    } else if (CurrentScore[j] < CurrentScore[j + 1]) {
                        //Second team has won
                        WinnerScore = CurrentScore[j + 1];
                        LoserScore = CurrentScore[j];
                        WinnerTeam = CurrentMatch[j + 1];
                        LoserTeam = CurrentMatch[j];
                        TieFlag = false;
                    } else {
                        //Tie
                        WinnerScore = CurrentScore[j];
                        LoserScore = CurrentScore[j + 1];
                        WinnerTeam = CurrentMatch[j];
                        LoserTeam = CurrentMatch[j + 1];
                        TieFlag = true;
                    }

                    if (TieFlag) {
                        //Updating Total points according to tie policy
                        int PreviousWinningCountTeamOne = TeamWinning.get(WinnerTeam);
                        TeamWinning.replace(WinnerTeam, PreviousWinningCountTeamOne + 1);

                        int PreviousWinningCountTeamTwo = TeamWinning.get(LoserTeam);
                        TeamWinning.replace(LoserTeam, PreviousWinningCountTeamTwo + 1);
                    } else {
                        //Updating Total points according to win policy
                        int PreviousWinningCount = TeamWinning.get(WinnerTeam);
                        TeamWinning.replace(WinnerTeam, PreviousWinningCount + 3);
                    }

                    //Updating Goal Difference
                    int WinnerGoalDifference = WinnerScore - LoserScore;
                    int WinnerPreviousGoalDifference = GoalDifference.get(WinnerTeam);
                    GoalDifference.replace(WinnerTeam, WinnerPreviousGoalDifference + WinnerGoalDifference);

                    int LoserGoalDifference = LoserScore - WinnerScore;
                    int LoserPreviousGoalDifference = GoalDifference.get(LoserTeam);
                    GoalDifference.replace(LoserTeam, LoserPreviousGoalDifference + LoserGoalDifference);
                }
            }

            int MaxScore = -1;
            int SecondHighest = -1;
            String FirstPlace = "";
            String SecondPlace = "";

            //Finding Which Team has won
            for (String Key : TeamWinning.keySet()) {
                int Score = TeamWinning.get(Key);
                if (Score > MaxScore) {
                    MaxScore = Score;
                    FirstPlace = Key;
                } else if (Score == MaxScore)  {
                    if (GoalDifference.get(FirstPlace) > GoalDifference.get(Key)) {
                        SecondPlace = Key;
                    } else {
                        SecondPlace = FirstPlace;
                        FirstPlace = Key;
                    }
                } else {
                    //When points are the same then looking at Goal difference
                    if (TeamWinning.get(Key) > SecondHighest && TeamWinning.get(Key) < MaxScore) {
                        SecondPlace = Key;
                        SecondHighest = TeamWinning.get(Key);
                    }
                }
            }

            System.out.println("First Place - " + FirstPlace);
            System.out.println("Second Place - " + SecondPlace);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void main(String[] args) {
        //{ MANUTD, ARSENAL }, { LYON, MANUTD }, { FCBARCA, LYON },
        //            { FCBARCA, ARSENAL }, { MANUTD, FCBARCA }, { ARSENAL, LYON }, { ARSENAL, MANUTD }, { MANUTD, LYON }, { ARSENAL, FCBARCA },
        //            { LYON, FCBARCA }, { LYON, ARSENAL }, { FCBARCA, MANUTD }}
        String[][] InputMatch = new String[][] {{ A, B }, { A, C }, { A, D },
                { B, A }, { B, C }, { B, D }, { C, A }, { C, B }, { C, D },
                { D, A }, { D, B }, { D, C }};

        // { { 8, 2 }, { 1, 2 }, { 0, 0 }, { 5, 1 }, { 3, 1 }, { 6, 0 }, { 0, 0 },
        //            { 4, 2 }, { 2, 2 }, { 0, 3 }, { 1, 0 }, { 0, 1 }}
        int[][] InputGoals = new int[][] { { 3, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 }, { 4, 0 }, { 0, 0 }, { 0, 0 },
                { 0, 0 }, { 1, 0 }, { 3, 0 }, { 0, 0 }, { 0, 0 }};

        FirstSecondPlace(InputMatch, InputGoals);
    }
}

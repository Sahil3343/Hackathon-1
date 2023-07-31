import java.sql.SQLOutput;
import java.util.*;

public class Question_3 {



    private static String TruckQueue(int[] Trucks) {
        try {
            //Initializing PerpendicularRoad and FinalQueue
            Stack<Integer> PerpendicularRoad = new Stack<>();
            Queue<Integer> FinalQueue = new PriorityQueue<>();

            //Retrieving smallest truck for setting starting point
            int MinTruck = Arrays.stream(Trucks).min().getAsInt();
            int CurrentTruck = MinTruck;

            //Iterating through the array
            for (int i = 0; i < Trucks.length; i++) {
                //Searching for match using CurrentTruck. If found, then adding it to the FinalQueue
                //and incrementing CurrentTruck
                if (Trucks[i] == CurrentTruck) {
                    FinalQueue.add(Trucks[i]);
                    CurrentTruck++;

                    //Checking the perpendicular road for any match (If PerpendicularRoad not empty)
                    while (!PerpendicularRoad.isEmpty() && PerpendicularRoad.peek() == CurrentTruck) {
                        FinalQueue.add(PerpendicularRoad.pop());
                        CurrentTruck++;
                    }

                } else {
                    //As CurrentTruck not equal to Trucks[i] appending the truck to the perpendicular road
                    PerpendicularRoad.add(Trucks[i]);
                }
            }

            //If PerpendicularRoad empty means FinalQueue is completely populated
            if (PerpendicularRoad.isEmpty()) {
                return "Yes";
            } else {
                return "No";
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return "Error";
        }
    }

    public static void main(String[] args) {
        int[] Trucks = new int[] { 5, 1, 2, 4, 3 };
        System.out.println("Input List - " + Arrays.toString(Trucks)); //Input - 5, 1, 2, 4, 3
        System.out.println(TruckQueue(Trucks)); //Expected Output - Yes
    }
}

import java.sql.SQLOutput;
import java.util.*;

public class Question_3 {



    private static String TruckQueue(int[] Trucks) {
        try {
            Stack<Integer> PerpendicularRoad = new Stack<>();
            Queue<Integer> FinalQueue = new PriorityQueue<>();

            int MinTruck = Arrays.stream(Trucks).min().getAsInt();
            int CurrentTruck = MinTruck;

            //Iterating through the array
            for (int i = 0; i < Trucks.length; i++) {
                //Searching for match
                if (Trucks[i] == CurrentTruck) {
                    FinalQueue.add(Trucks[i]);
                    CurrentTruck++;

                    //Checking the perpendicular road for any match
                    while (!PerpendicularRoad.isEmpty() && PerpendicularRoad.peek() == CurrentTruck) {
                        FinalQueue.add(PerpendicularRoad.pop());
                        CurrentTruck++;
                    }

                } else if (!PerpendicularRoad.isEmpty()) {
                    if (PerpendicularRoad.lastElement() == CurrentTruck) {
//                        FinalQueue.add(PerpendicularRoad.lastElement());
//                        PerpendicularRoad.pop();
//                        CurrentTruck++;
                    } else {
                        PerpendicularRoad.add(Trucks[i]);
                    }
                } else {
                    PerpendicularRoad.add(Trucks[i]);
                }
            }

            if (PerpendicularRoad.isEmpty()) {
                return "Yes";
            } else {
                return "No";
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        int[] Trucks = new int[] { 4, 1, 5, 3, 2 };
        System.out.println(TruckQueue(Trucks));
    }
}

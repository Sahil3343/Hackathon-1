import java.util.Arrays;

public class Question_1 {

    private static int[] RearrangingArray(int[] InputArray) {
        try {
            //Setting two pointers for moving elements within the same Array
            int LeftPointer = 0;
            int RightPointer = InputArray.length - 1;

            //Iterating Through Entire Array
            for (int i = 0; i < InputArray.length - 1; i++) {
                if (InputArray[LeftPointer] == 0) {
                    while (LeftPointer < RightPointer) {
                        //Swapping Two elements of the array
                        if (InputArray[RightPointer] != 0) {
                            InputArray[LeftPointer] = InputArray[RightPointer];
                            InputArray[RightPointer] = 0;
                            RightPointer--;
                            LeftPointer++;
                        } else {
                            RightPointer--;
                        }
                    }

                    if (LeftPointer < RightPointer) {
                        break;
                    }
                } else {
                    LeftPointer++;
                }
            }

            return InputArray;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new int[] { 0 };
        }
    }

    public static void main(String[] args) {
        int[] InputArray = new int[] { 1, 2, -4, 0, -1, 0, 3, 7, 0, 5, 0, 1, -1, 0 };
        System.out.println("Input Array - " + Arrays.toString(InputArray));
        System.out.println("Output Array - " + Arrays.toString(RearrangingArray(InputArray)));
    }
}

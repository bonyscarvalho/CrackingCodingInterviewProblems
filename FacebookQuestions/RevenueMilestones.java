package FacebookQuestions;

import java.util.Arrays;

public class RevenueMilestones {
    public static void main(String[] args) {
        int revenues[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int milestones[] = {100, 200, 500};
        int expected[] = {4, 6, 10};
        int[] output = getMilestoneDays(revenues, milestones);
        Arrays.stream(output).forEach(value -> System.out.print(value + " "));
        System.out.println();

        int revenues_1[] = {100, 200, 300, 400, 500};
        int milestones_1[] = {300, 800, 1000, 1400};
        int expected_1[] = {2, 4, 4, 5};
        int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
        Arrays.stream(output_1).forEach(value -> System.out.print(value + " "));
        System.out.println();

        int revenues_2[] = {700, 800, 600, 400, 600, 700};
        int milestones_2[] = {3100, 2200, 800, 2100, 1000};
        int expected_2[] = {5, 4, 2, 3, 2};
        int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
        System.out.println();
        Arrays.stream(output_2).forEach(value -> System.out.print(value + " "));
    }

    private static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        int[] output = new int[milestones.length];
        if(revenues.length == 0)return output;

        for(int idx = 1; idx < revenues.length; idx++){
            revenues[idx] += revenues[idx - 1];
        }
        //Arrays.stream(revenues).forEach(value -> System.out.print(value + " "));

        for(int idx = 0; idx < milestones.length; idx++){
            int milestone = milestones[idx];

            int leftPtr = 0;
            int rightPtr = revenues.length - 1;
            int greaterMilestonePtr = -1;

            while (leftPtr <= rightPtr){
                int midPtr = (leftPtr + rightPtr)/2;
                if(revenues[midPtr] == milestone){
                    greaterMilestonePtr = midPtr + 1;
                    break;
                }else if(revenues[midPtr] > milestone){
                    greaterMilestonePtr = midPtr + 1;
                    rightPtr = midPtr - 1;
                }else {
                    leftPtr = midPtr + 1;
                }
            }
            output[idx] = greaterMilestonePtr;
        }

        return output;
    }
}

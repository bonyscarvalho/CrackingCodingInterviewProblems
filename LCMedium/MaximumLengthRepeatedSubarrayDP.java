package LeetCodeMedium;

import java.util.Arrays;

public class MaximumLengthRepeatedSubarrayDP {
    public static void main(String[] args) {

        int[] nums1 = {1,0,0,0,1,0,0,1,0,0};      //{1,2,3,2,1};
        int[] nums2 = {0,1,1,1,0,1,1,1,0,0};      //{3,2,1,4,7};
        //[0,1,1,1,1]
        //[1,0,1,0,1]
        System.out.println("EVEN/ODD:" + findLength(nums1, nums2));
        System.out.println("MEMO: " + findLengthTwoDMemo(nums1, nums2));


    }

    public static int findLengthTwoDMemo(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    memo[i][j] = memo[i-1][j-1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }

    public static int findLength(int[] nums1, int[] nums2) {
        int num1Len = nums1.length, num2Len = nums2.length;

        if(num1Len == 0 || num2Len == 0)return 0;
        int[] bigger = num1Len > num2Len ? nums1 : nums2;
        int[] smaller = num1Len > num2Len ? nums2 : nums1;

        int[] evenEdits = new int[num2Len + 1];
        int[] oddEdits = new int[num2Len + 1];
        //Arrays.fill(evenEdits, 0);

        System.out.println();
        System.out.println("Num1: ");
        Arrays.stream(nums1).forEach(value -> System.out.print(" " + value));
        System.out.println();
        System.out.println("Num2: ");
        Arrays.stream(nums2).forEach(value -> System.out.print(" " + value));
        System.out.println();


        int[] currEdits, prevEdits;
        int maxLen = 0;

        for(int i = 1; i <= nums1.length; i++){

            if(i % 2 == 1){
                currEdits = oddEdits;
                prevEdits = evenEdits;
            }else{
                currEdits = evenEdits;
                prevEdits = oddEdits;
            }

            //currEdits[0] = 0;
            //Set both values for currEdits match or no match else it will take the older values and give you wrong result
            for(int j = 1; j <= nums2.length; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    currEdits[j] = prevEdits[j - 1] + 1;
                }else{
                    currEdits[j] = 0;
                }

//                if(currEdits[j] > maxLen){
//                    maxLen = currEdits[j];
//                }
//                else{
//                    currEdits[j] = Math.max(prevEdits[j - 1], Math.max(prevEdits[j], currEdits[j - 1]));
//                }

            }
//            System.out.println();
//            System.out.println("Curr Edits: " + i);
//            Arrays.stream(currEdits).forEach(value -> System.out.print(" " + value));
//            System.out.println();
//            System.out.println("Prev Edits: " + i);
//            Arrays.stream(prevEdits).forEach(value -> System.out.print(" " + value));
//            System.out.println();
        }

        //return maxLen;
        //return bigger.length % 2 == 0 ? evenEdits[smaller.length] : oddEdits[smaller.length];
        return num1Len % 2 == 0 ? evenEdits[num2Len] : oddEdits[num2Len];
    }
}

package LeetCodeMedium;

import java.util.Arrays;

public class IntersectionOfNums {

    public static void main(String[] args)
    {
        int[] nums1 = {6, 5, 8, 4, 2, 1, 1, 6};
        int[] nums2 = {7, 6, 3, 5, 2, 1};
        int[] intersections = intersections(nums1, nums2);
        int[] intersectionApp = intersectionsNoSpace(nums1, nums2);
        Arrays.stream(intersectionApp).forEach(value -> System.out.println(value + " "));
    }

    private static int[] intersectionsNoSpace(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int num1Idx = 0, num2Idx = 0, resultIdx = 0;

        while (num1Idx < nums1.length && num2Idx < nums2.length){
            if(nums1[num1Idx] == nums2[num2Idx]){
                //Checking if the last resultIdx was not the same number as we want unique
                if(resultIdx == 0 || nums1[num1Idx] != nums1[resultIdx - 1]){
                    nums1[resultIdx++] = nums1[num1Idx];
                }
                num1Idx++;
                num2Idx++;
            }else if(nums1[num1Idx] > nums2[num2Idx]){
                num2Idx++;
            }else {
                num1Idx++;
            }
        }

        return Arrays.copyOf(nums1, resultIdx);
    }

    public static int[] intersections(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] intersections = new int[nums1.length];
        int resultIndex = 0;

        int l = 0, r = 0;
        while (l < nums1.length && r < nums2.length) {
            int left = nums1[l], right = nums2[r];

            if (right == left) {
                intersections[resultIndex++] = right;

                while (l < nums1.length && left == nums1[l])
                    l++;
                while (r < nums2.length && right == nums2[r])
                    r++;
                continue;
            }
            if (right > left)
                while (l < nums1.length && left == nums1[l])
                    l++;
            else
                while (r < nums2.length && right == nums2[r])
                    r++;

        }

        return Arrays.copyOf(intersections, resultIndex);
    }


}

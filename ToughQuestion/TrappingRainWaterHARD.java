package LeetCodeHard;

public class TrappingRainWaterHARD {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};         //{0,1,0,2,1,0,1,3,2,1,2,1};
        //{0,1,0,2,1,0,1,3,2,1,2,1};
        //{0,3,3,3,3,3,3,3,2,2,2,1};
        //{0,1,1,2,2,2,2,3,3,3,3,3};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        if(height == null || height.length < 3)return 0;  // as the bucket size should be greater then 3

        int heightLen = height.length;
        int[] leftMax = new int[heightLen], rightMax = new int[heightLen];
        leftMax[0] = height[0]; rightMax[heightLen - 1] = height[heightLen - 1];

        for(int idx = 1; idx < heightLen; idx++){
            leftMax[idx] = Math.max(leftMax[idx - 1], height[idx]);
        }
        for(int idx = heightLen - 2; idx >= 0; idx--){
            rightMax[idx] = Math.max(rightMax[idx + 1], height[idx]);
        }

        int maxWaterVol = 0;
        for(int idx = 0; idx < heightLen; idx++){
            int minHeight = Math.min(leftMax[idx], rightMax[idx]);
            maxWaterVol += (minHeight - height[idx]);
        }
        System.out.println("maxWaterVol: "+maxWaterVol);
        return maxWaterVol;
    }
}

package DynamicProgramming;

import java.util.Arrays;

//45. Jump Game II
//55. Jump Game
public class MinJumps {
    public static void main(String[] args) {
        int[] jumpsValid = {2,3,1,1,4};
        int[] jumpsInValid = {3,2,1,0,4};

        System.out.println(jump(jumpsValid));
        System.out.println(jump(jumpsInValid));
        System.out.println(jumpNoSpace(jumpsValid));
    }

    private static int jumpNoSpace(int[] nums) {
        if(nums.length == 0) return 0;
        //INVALID : 3,2,1,0,4
        int farthestJump = 0;   //the MAX long jump you can take from currIdx
        int currMaxJump = 0, totalJumps = 0;

        for(int idx = 0; idx < nums.length - 1; idx++){
            farthestJump = Math.max(farthestJump, (idx + nums[idx]));

            if(farthestJump >= nums.length - 1){
                totalJumps++;
                return totalJumps;
            }

            if(idx == currMaxJump){
                //when the idx reaches currMaxJump then the totalJump will be incremented and curr will be the long jump it can take
                totalJumps++;
                currMaxJump = farthestJump;
            }
        }

        return totalJumps;
    }

    public static int jump(int[] nums) {
        if(nums.length == 0) return 0;  //true

        Integer[] minJump = new Integer[nums.length];
        Arrays.fill(minJump, Integer.MAX_VALUE);
        minJump[0] = 0;
        Integer[] path = new Integer[nums.length];

        for(int idx = 1; idx < nums.length; idx++){
            int firstPtr = 0;
            while (firstPtr < idx){
                int jumps = firstPtr + nums[firstPtr];
                if(jumps >= idx){
                    minJump[idx] = Math.min(minJump[idx], 1 + minJump[firstPtr]);
                    //path[]
                }
                firstPtr++;
            }
        }

        return minJump[nums.length - 1] == Integer.MAX_VALUE ? -1 : minJump[nums.length - 1];
    }
}

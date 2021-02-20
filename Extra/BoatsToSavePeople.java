package Extra;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        //people = [3,5,3,4], limit = 5
        //people = [3,2,2,1], limit = 3
        int [] people = {3,5,3,4};
        int limit = 5;
        int numOfBoats = findTheNumOfBoatsReq(people, limit);
        System.out.println("We require "+ numOfBoats+ " to save people");

    }

    private static int findTheNumOfBoatsReq(int[] people, int limit) {
        if(people.length == 0 || limit <= 0) return 0;

        Arrays.sort(people);    //1,2,2,3
        int numOfBoats = 0;
        int left = 0, right = people.length - 1;

        while (left <= right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;

            }else{
                right--;
            }
            numOfBoats++;
        }

        return numOfBoats;
    }
}

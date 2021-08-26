package LeetCodeHard;

import java.util.*;

//1235. Maximum Profit in Job Scheduling
public class MaximumProfitJobScheduling {
    public static void main(String[] args) {
        int[] startTime1 = {1,2,3,3}, endTime1 = {3,4,5,6}, profit1 = {50,10,40,70};
        int[] startTime2 = {1,2,3,4,6}, endTime2 = {3,5,10,6,9}, profit2 = {20,20,100,70,60};

        System.out.println(jobScheduling(startTime1,endTime1,profit1));
        System.out.println(jobScheduling(startTime2,endTime2,profit2));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobsWithProfit = new ArrayList<>();

        for(int idx = 0; idx < profit.length; idx++){
            ArrayList<Integer> currJobWProfit = new ArrayList<>();
            currJobWProfit.add(startTime[idx]);
            currJobWProfit.add(endTime[idx]);
            currJobWProfit.add(profit[idx]);
            jobsWithProfit.add(currJobWProfit);
        }

        Collections.sort(jobsWithProfit, (a,b) -> a.get(0)- b.get(0));  //sort by start time in ascending order

        return findMaxProfit(jobsWithProfit);
    }

    private static int findMaxProfit(List<List<Integer>> jobsWithProfit) {
        if(jobsWithProfit.size() == 1) return jobsWithProfit.get(0).get(2);

        int maxProfit = 0;
        int len = jobsWithProfit.size();
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>((a, b) -> (a.get(0) - b.get(0)));  // sort by smallest endTime

        for(int idx = 0; idx < len; idx++){
            List<Integer> currJob = jobsWithProfit.get(idx);
            int startTime = currJob.get(0), endTime = currJob.get(1), profit = currJob.get(2);

            //comparing the startTime with the end time of last job
            while (!priorityQueue.isEmpty() && startTime >= priorityQueue.peek().get(0)){
                maxProfit = Math.max(maxProfit, priorityQueue.peek().get(1));
                priorityQueue.poll();
            }

            //VERY IMP:Adding the maxProfit from the pq and adding it to all the jobs
            // which having start time after end time of previous jobs
            List<Integer> combinedJob = new ArrayList<>();
            combinedJob.add(endTime);
            combinedJob.add(maxProfit + profit);

            priorityQueue.add(combinedJob);
        }

        while (!priorityQueue.isEmpty()){
            maxProfit = Math.max(maxProfit, priorityQueue.peek().get(1));
            priorityQueue.poll();
        }

        return maxProfit;
    }
}

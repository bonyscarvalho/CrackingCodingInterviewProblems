package LeetCodeMedium.DisjointAndDFS;

import java.util.*;

public class AccountsMergeDSUWayConfusing {

    public static class DisJointSetUnion{
        Map<Integer, Integer> disjointSetsLeader;
        Map<Integer, Integer> disjointSetsRank;
        int totalSets;

        public DisJointSetUnion(int totalSets){
            this.totalSets = totalSets;
            this.disjointSetsLeader = new HashMap<>();
            this.disjointSetsRank = new HashMap<>();
            createSets(totalSets);
        }

        private void createSets(int totalSets) {
            for (int idx = 1; idx <= totalSets; idx++){
                disjointSetsLeader.put(idx, idx);
                disjointSetsRank.put(idx, 1);
            }
        }

        private void union(int x, int y){
            int leaderOfX = find(x);
            int leaderOfY = find(y);

            if(leaderOfX == leaderOfY){
                return;
            }
            //Union By Rank
            if(disjointSetsRank.get(leaderOfY) > disjointSetsRank.get(leaderOfX)){
                int temp = leaderOfY;
                leaderOfY = leaderOfX;
                leaderOfX = temp;
            }

            disjointSetsLeader.put(leaderOfY, leaderOfX);
            int updatedRankOfX = disjointSetsRank.get(leaderOfX) + disjointSetsRank.get(leaderOfY);
            disjointSetsRank.put(leaderOfX, updatedRankOfX);
            totalSets--;
        }

        private int find(int x) {
            if(disjointSetsLeader.get(x) != x){
                int absLeaderParent = find(disjointSetsLeader.get(x));
                //Path Compression to point directly to main Leader
                disjointSetsLeader.put(x, absLeaderParent);
                return absLeaderParent;
            }
            return x;
        }
    }

    public static void main(String[] args)
    {
        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"});
        List<String> account2 = Arrays.asList(new String[]{"John","johnsmith@mail.com","john00@mail.com"});
        List<String> account3 = Arrays.asList(new String[]{"Mary","mary@mail.com"});
        List<String> account4 = Arrays.asList(new String[]{"John","johnnybravo@mail.com"});
        //accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]

        accounts.add(account1);accounts.add(account2);accounts.add(account3);accounts.add(account4);
        List<List<String>> mergedAccounts = accountsMerge(accounts);
        System.out.println(mergedAccounts);
    }

    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> mergedAccounts = new ArrayList<>();

        DisJointSetUnion disJointSetUnion = new DisJointSetUnion(10);

        Map<String, String> emailToNameMap = new HashMap<>();
        Map<String, Integer> emailToIDMap = new HashMap<>();

        int id = 1;

        for(List<String> account : accounts){
            String name = "";
            for(String email : account){
                if(name == ""){
                    name = email;
                    continue;
                }

                emailToNameMap.put(email, name);
                if(!emailToIDMap.containsKey(email)){
                    emailToIDMap.put(email, id++);
                }

                //1 --> as email starts from 1
                disJointSetUnion.union(emailToIDMap.get(account.get(1)), emailToIDMap.get(email));  //for first element the parent to parent mapping is already done
            }
        }

//        System.out.println("UNION: " + disJointSetUnion.disjointSetsLeader);
//
//        System.out.println("RANKS: " + disJointSetUnion.disjointSetsRank);


        Map<Integer, List<String>> emailList = new HashMap<>();

        for(String email : emailToNameMap.keySet()){
            //System.out.println("EMAIL: " + email);
            String name =  emailToNameMap.get(email);
            int leaderIdx = disJointSetUnion.find(emailToIDMap.get(email));
            //System.out.println("Leader Idx: " + name +" "+leaderIdx);
            emailList.computeIfAbsent(leaderIdx, x-> new ArrayList<>()).add(email); //emailList.get(leaderIdx).add(email);
        }

        for(List<String> emails : emailList.values()){
            System.out.println("Emails Last List: " + emails);
            Collections.sort(emails);
            emails.add(0, emailToNameMap.get(emails.get(0)));
        }

        return new ArrayList<>(emailList.values());
    }
}

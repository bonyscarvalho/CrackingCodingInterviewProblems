package LeetCodeMedium.DisjointAndDFS;

import java.util.*;
//O(AlogA)
public class AccountsMerge {
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

        Map<String, String> emailToNameMap = new HashMap<>();   //Used to store Email --> Name Map to grab it at the end
        Map<String, HashSet<String>> emailGraph = new HashMap<>();  //Used to store email to Nodes of other Email in Set

        for(List<String> account : accounts){
            String name = account.get(0);
            //For Account with Just Name and No Email
            if(account.size() == 1){
                List<String> list = new LinkedList<>();
                list.add(name);
                mergedAccounts.add(list);
                continue;
            }

            String firstEmail = account.get(1);
            emailToNameMap.put(firstEmail, name);
            //Putting inside the graph the email if not present
            //Just like checking if the email node is already there or no
            if(!emailGraph.containsKey(firstEmail)){
                emailGraph.put(firstEmail, new HashSet<>());    //Hashset as you don't need to point to same node 2 times
            }

            for(int idx = 2; idx < account.size(); idx++){
                String email = account.get(idx);

                //Adding email to name mapping for all emails
                //Doesn't matter even if we add double as it won't change the value as email are distinct
                emailToNameMap.put(email, name);
                if(!emailGraph.containsKey(email)){
                    emailGraph.put(email, new HashSet<>());
                }
                //Adding nodes connection from firstEmail to all the next emails
                //Like an undirected graph
                emailGraph.get(firstEmail).add(email);
                emailGraph.get(email).add(firstEmail);
            }
        }

        Set<String> visitedEmail = new HashSet<>(); // For DFS to check
        for(String email : emailToNameMap.keySet()){            //Getting the list of all emails and traversing through it
            String name = emailToNameMap.get(email);
            List<String> mergedList = new LinkedList<>();

            if(visitedEmail.contains(email)){
                continue;
            }
            findEmailConnectionsDFS(email, emailGraph, visitedEmail, mergedList);
            Collections.sort(mergedList);
            mergedList.add(0, name);
            mergedAccounts.add(mergedList);
        }

        return mergedAccounts;
    }

    private static void findEmailConnectionsDFS(String email, Map<String, HashSet<String>> emailGraph, Set<String> visitedEmail, List<String> mergedList) {
        if(visitedEmail.contains(email)){
            return;
        }

        visitedEmail.add(email);
        mergedList.add(email);

        for(String connectedEmail : emailGraph.get(email)){
            findEmailConnectionsDFS(connectedEmail, emailGraph, visitedEmail, mergedList);
        }
    }
}

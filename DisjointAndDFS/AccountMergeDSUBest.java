package LeetCodeMedium.DisjointAndDFS;

import java.util.*;

//O(ALogA) --> If we used union-by-rank, this complexity improves to O(A \alpha(A)) \approx O(A)O(Aα(A))≈O(A), where \alphaα is the Inverse-Ackermann function.
class AccountMergeDSUBest {
    static class UnionFind{
        int[] parent;
        int[] rank;
        int size;

        public UnionFind(int size){ //makeSet
            parent = new int[size];
            for(int i=0;i<size;i++){
                parent[i] = i;
            }
            rank = new int[size];
            this.size = size;
        }

        public int find(int element){
            if(parent[element] != element){
                int absParent = find(parent[element]);
                parent[element] = absParent;
                return absParent;
            }
            return element;
        }

        public void union(int x,int y){
            int xp = find(x);
            int yp = find(y);
            if(xp == yp) return;
            if(rank[xp] < rank[yp]){
                parent[xp] = yp;
            }else if(rank[yp] < rank[xp]){
                parent[yp] = xp;
            }else{
                parent[yp] = xp;
                rank[xp]++;
            }
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> finalList = new LinkedList<>();

        if(accounts.size() == 0){
            return finalList;
        }

        UnionFind uF = new UnionFind(accounts.size());
        HashMap<String,Integer> map = new HashMap<>();

        //accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],
        //              ["John","johnsmith@mail.com","john00@mail.com"],
        //              ["Mary","mary@mail.com"],
        //              ["John","johnnybravo@mail.com"]]
        for(int i=0;i<accounts.size();i++){
            List<String> account = accounts.get(i);
            for(int j =1;j<account.size();j++){
                String email = account.get(j);
                map.putIfAbsent(email,i);   //you only put the email if it is absent else not
                //so over here the group of emails will form a single group and they will be mapped together
                uF.union(map.get(email),i); // as the first email is mapped to 0 and the current IDX is 1 the union(0, 1)
            }
        }

        HashMap<Integer,List<String>> indexEmail = new HashMap<>();

        for(String email : map.keySet()){
            int root = uF.find(map.get(email)); //here you find the root of all elements and put them in single list
            indexEmail.putIfAbsent(root,new LinkedList<>());    //creating root if absent
            indexEmail.get(root).add(email);
        }
        //indexEmail:{0=[johnsmith@mail.com, john00@mail.com, john_newyork@mail.com], 2=[mary@mail.com], 3=[johnnybravo@mail.com]}

        for(Integer index : indexEmail.keySet()){
            List<String> account = new LinkedList<>();
            account.add(accounts.get(index).get(0));    //Name Added

            List<String> emails = indexEmail.get(index);    //Emails
            Collections.sort(emails);

            account.addAll(emails);
            finalList.add(account);
        }
        for (int idx = 0; idx < uF.rank.length; idx++){
            System.out.println("IDX: " + idx + " Rank: " + uF.rank[idx]);
        }

        return finalList;
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
}

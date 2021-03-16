package Extra;

import java.util.*;

public class ReorganiseString {
    public static void main(String[] args) {
        String str = "aaabb";

        System.out.println("Reorganised String: " + reorganizedString(str));
    }

    private static String reorganizedString(String str) {
        if(str.length() <= 1) return str;

        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : str.toCharArray()){
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(counts.get(o1) > counts.get(o2)) return -1;
                if(counts.get(o1) < counts.get(o2)) return 1;
                return 0;
            }
        });

        pq.addAll(counts.keySet());
        StringBuilder result = new StringBuilder();

        while (pq.size() > 1){
            char curr = pq.remove();
            char next = pq.remove();

            result.append(curr).append(next);
            counts.put(curr, counts.get(curr) - 1);
            counts.put(next, counts.get(next) - 1);

            if(counts.get(curr) > 0) pq.add(curr);
            if(counts.get(next) > 0) pq.add(next);
        }

        if(!pq.isEmpty()){
            char ch = pq.remove();
            if(counts.get(ch) > 1){
                return " ";
            }
            result.append(ch);
        }
        return result.toString();
    }
}

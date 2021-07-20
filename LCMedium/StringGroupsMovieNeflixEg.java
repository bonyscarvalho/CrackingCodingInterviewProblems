package LeetCodeMedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringGroupsMovieNeflixEg {
    public static void main(String[] args) {
        // Driver code
        String titles[] = {"duel","dule","speed","spede","deul","cars"};
        List<List<String>> gt = groupTitles(titles);
        String query = "spede";
// Searching for all titles
        for (List<String> g : gt){
            if (g.contains(query))
                System.out.println(g);
        }
    }

    private static List<List<String>> groupTitles(String[] titles) {
        List<List<String>> groupTitles = new ArrayList<>();

        if(titles.length == 0)return groupTitles;
        Map<String, List<String>> titleMap = new HashMap<>();

        for(String title : titles){
            int[] delimeter = new int[26]; //think of the movie name as lowercase only

            for(char ch : title.toCharArray()){
                int charIdx = ch - 'a';
                delimeter[charIdx]++;
            }
            StringBuilder anagramKey = new StringBuilder();
            for(int num : delimeter){
                anagramKey.append("#").append(num);
            }
            String key = anagramKey.toString();

            if(!titleMap.containsKey(key)){
                titleMap.put(key, new ArrayList<String>());
            }
            titleMap.get(key).add(title);
        }
        System.out.println(titleMap);

        return new ArrayList<List<String>>(titleMap.values());
    }
}

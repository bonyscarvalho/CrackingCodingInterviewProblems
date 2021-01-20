package ChapterArraysAndStrings;

public class OneEditAway {
    public static void main(String args[]){
        String set11 = "pale", set12 = "ple";
        String set21 = "pales", set22 = "pale";
        String set31 = "pale", set32 = "bale";
        String set41 = "pale", set42 = "bake";

        Boolean set1Result = isOneEditAway(set11, set12);
        Boolean set2Result = isOneEditAway(set21, set22);
        Boolean set3Result = isOneEditAway(set31, set32);
        Boolean set4Result = isOneEditAway(set41, set42);

        System.out.println("Results : " + set1Result + set2Result + set3Result + set4Result);
    }
    
    //Comparing both the Strings and following the base cases
    private static Boolean isOneEditAway(String set11, String set12) {
        if(Math.abs(set11.length() - set12.length()) > 1) return false;

        String bigger = set11.length() > set12.length() ? set11 : set12;
        String smaller = set11.length() > set12.length() ? set12 : set11;

        int indexB = 0, indexS = 0;
        boolean editFlag = false;

        while ((indexS < smaller.length()) && (indexB < bigger.length())){
            if(smaller.charAt(indexS) != bigger.charAt(indexB)){
                if(smaller.length() == bigger.length()){
                    indexS++;
                }
                if(editFlag) return false;
                editFlag = true;
                indexB++;
            }else {
                indexS++;
                indexB++;
            }

        }
        return true;
    }
}

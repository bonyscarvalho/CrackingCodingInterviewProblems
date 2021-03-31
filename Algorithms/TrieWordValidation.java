package Algorithms;

import java.util.*;

public class TrieWordValidation {
    private static TrieNode root;

    public TrieWordValidation(String[] dicts){
        root = new TrieNode("*");
    }

    static class TrieNode{
        String prefix;
        HashMap<Character, TrieNode> childrens;
        boolean isWord;
        int numOfWordsCount;
        private TrieNode(String prefix){
            this.prefix = prefix;
            this.childrens = new HashMap<>();
            this.numOfWordsCount = 0;
        }
    }

    //Space: O(n.L.Constant(Map)) Query/Insert/Delete/Update: O(L) length of Nodes
    public static void main(String args[]) {
        String [] words = {"gayle", "gary", "geena", "alex", "andy", "app", "application", "xyz"};
        TrieWordValidation trieWordValidation= new TrieWordValidation(words);

        for (String word : words){
            insertWords(word);
        }

//        Set<Character> wordKeys = root.childrens.keySet();
//        for (Character key : wordKeys){
//            System.out.println("Key: " + key+" Prefix: "+root.childrens.get(key));
//        }
        System.out.println("Remove: " + removeWord("xyz"));

        List<String> prefixedWords = getWordsFromPrefix("xyz");
        System.out.println(prefixedWords);
//
//        System.out.println(deleteWord("application"));
//
//        List<String> deleteTest = getWordsFromPrefix("application");
//        System.out.println(deleteTest);
//        updateWord("gary","bary");
//
//        List<String> updateTest = getWordsFromPrefix("gary");
//        System.out.println(updateTest);
    }

    private static boolean removeWord(String word) {
        Stack<TrieNode> stack = new Stack<TrieNode>();
        TrieNode n = root;
        stack.add(n);

        for (char c : word.toCharArray()) {
            n = n.childrens.get(c);
           // n = n.next[c];
            if (n == null)//word not found
            {
                return false;
            }
            stack.add(n);
        }

        if (!n.isWord){ //word not found
            return false;
        }

        n.isWord = false;

        if (!n.childrens.isEmpty()) {   //word is a prefix
            return true;
        }

        //word is not a prefix
        stack.pop();
        n = stack.pop();
        while (!stack.isEmpty() && n.numOfWordsCount == 1) {
            n.childrens.clear();
            if (n.isWord) {
                return true;
            }
            n = stack.pop();
        }
        return true;
    }//remove


    private static void updateWord(String oldWord, String newWord){
        deleteWord(oldWord);
        insertWords(newWord);
    }

    private static boolean deleteWord(String word) {
        TrieNode currNode = root;

        for(int charIdx = 0; charIdx < word.length(); charIdx++){
            if(currNode == null){
                System.out.println("No Word contains for "+ word);
                return false;
            }
            currNode = currNode.childrens.get(word.charAt(charIdx));
        }
        currNode.isWord = false;
        return true;
    }

    private static List<String> getWordsFromPrefix(String prefix) {
        List<String> results = new LinkedList<String>();
        TrieNode currNode = root;

        for (char ch: prefix.toCharArray()){
            if(currNode.childrens.containsKey(ch)){
                System.out.println("Inside contains: " + ch);
                currNode = currNode.childrens.get(ch);
            }else {
                return results;
            }
        }

        findAllMatchingWords(currNode, results);
        return results;
    }

    private static void findAllMatchingWords(TrieNode currNode, List<String> results) {
        if(currNode.isWord){
            //System.out.println("Word "+currNode.prefix);
            results.add(currNode.prefix);
        }
        for (char ch : currNode.childrens.keySet()){
            findAllMatchingWords(currNode.childrens.get(ch),results);
        }
    }

    private static void insertWords(String word) {
        TrieNode currNode = root;

        for (int charIdx = 0; charIdx < word.length(); charIdx++){
            if(!currNode.childrens.containsKey(word.charAt(charIdx))){
                System.out.println(word.charAt(0) + " : "+ word.substring(0, charIdx + 1));
                currNode.childrens.put(word.charAt(charIdx),new TrieNode(word.substring(0, charIdx + 1)));
            }
            currNode = currNode.childrens.get(word.charAt(charIdx));
            if(charIdx == word.length() - 1){
                currNode.isWord = true;
            }
            currNode.numOfWordsCount++;
        }
    }
}

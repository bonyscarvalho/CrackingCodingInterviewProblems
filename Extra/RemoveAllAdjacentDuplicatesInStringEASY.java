package Extra;

import java.util.Stack;

//1047. Remove All Adjacent Duplicates In String
public class RemoveAllAdjacentDuplicatesInStringEASY {
    public static void main(String[] args) {
        String s = "azxxzy";
        System.out.println(removeDuplicatesStack(s));
        System.out.println(removeDuplicates(s));

    }

    public static String removeDuplicates(String s) {
        if(s.length() == 0) return "";
        StringBuilder res = new StringBuilder();
        int resLen = 0;

        for(char currChar : s.toCharArray()){
            if(resLen != 0 && res.charAt(resLen - 1) == currChar){
                res.deleteCharAt(resLen - 1);
                resLen--;
            }else{
                res.append(currChar);
                resLen++;
            }
        }

        return res.toString();
    }

    public static String removeDuplicatesStack(String s) {
        if(s.length() == 0) return "";

        Stack<Character> stack = new Stack<>();

        for(char currChar : s.toCharArray()){
            if(!stack.isEmpty() && (stack.peek() == currChar)){
                stack.pop();
            }else{
                stack.push(currChar);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}

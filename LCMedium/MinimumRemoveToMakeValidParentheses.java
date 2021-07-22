package LeetCodeMedium;

import java.util.Stack;

//1249. Minimum Remove to Make Valid Parentheses
public class MinimumRemoveToMakeValidParentheses {
    public static void main(String args[]) {
        String s1 = "(a(b(c)d)", s2 = "lee(t(c)o)de)", s3 = "))((";
        System.out.println(minRemoveToMakeValid(s1));
        System.out.println(minRemoveToMakeValid(s2));
        System.out.println(minRemoveToMakeValid(s3));
        System.out.println(minRemoveToMakeValidPlusMinusApp(s1));
        System.out.println(minRemoveToMakeValidPlusMinusApp(s2));
        System.out.println(minRemoveToMakeValidPlusMinusApp(s3));
    }
    public static String minRemoveToMakeValidPlusMinusApp(String s) {
        if(s.length() == 0) return "";

        StringBuilder result = new StringBuilder();
        int openBracketsCount = 0;
        StringBuilder sb = new StringBuilder();

        for(char curr : s.toCharArray()){
            if(curr == '('){
                openBracketsCount++;
            }else if(curr == ')'){
                if (openBracketsCount == 0){    //we don't need to add this as closing brackets can't be before opening
                    continue;
                }
                openBracketsCount--;
            }
            sb.append(curr);
        }

        for(int idx = sb.length() - 1; idx >= 0; idx--){
            if(sb.charAt(idx) == '(' && openBracketsCount > 0){ //there is opening brackets at last which is also invalid
                openBracketsCount--;
                continue;
            }
            result.append(sb.charAt(idx));
        }


        return result.reverse().toString();
    }

    public static String minRemoveToMakeValid(String s) {
        if(s.length() == 0) return "";

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        char[] str = s.toCharArray();
        //lee(t(c)o)de)
        for(int idx = 0; idx < str.length; idx++){
            if(str[idx] == '('){
                stack.push(idx);    //Storing the Index of Open so that if it is invalid it can be marked as * in 2nd pass
            }else if(str[idx] == ')'){
                if(stack.isEmpty()){    //there is no Opening brackets so mark as invalid
                    str[idx] = '*';
                }else{
                    stack.pop();    //Valid bracket
                }
            }
        }
        while (!stack.isEmpty()){
            str[stack.pop()] = '*'; //if there are any opening brackets remaining mark them as invalid
        }

        for (int idx = 0; idx < str.length; idx++){
            if(str[idx] != '*'){
                result.append(str[idx]);
            }
        }

        return result.toString();
    }
}

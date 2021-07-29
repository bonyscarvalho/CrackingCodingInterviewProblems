package Extra;

import java.util.Stack;

//844. Backspace String Compare
public class BackspaceStringCompareEASY {
    public static void main(String[] args) {
        String s1 = "ab#c", t1 = "ad#c", s2 = "a##c", t2 = "#a#c";
        String s = "a#c", t = "b";

        System.out.println(backspaceCompare(s1, t1));
        System.out.println(backspaceCompare(s2, t2));
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String S, String T) {
        if(S.length() == 0 || T.length() == 0) return false;

        int sPtr = S.length() - 1, tPtr = T.length() - 1;
        int skipS = 0, skipT = 0;

        //Comparing S and removing String from back
        while (sPtr >= 0 || tPtr >= 0){
            while (sPtr >= 0){
                if(S.charAt(sPtr) == '#'){
                    sPtr--;
                    skipS++;
                }else if(skipS > 0){
                    sPtr--;
                    skipS--;
                }else{
                    break;
                }
            }
            //Comparing T and removing String from back
            while (tPtr >= 0){
                if(T.charAt(tPtr) == '#'){
                    tPtr--;
                    skipT++;
                }else if(skipT > 0){
                    tPtr--;
                    skipT--;
                }else{
                    break;
                }
            }

            if(sPtr >= 0 && tPtr >= 0 && S.charAt(sPtr) != T.charAt(tPtr)){
                return false;
            }
            if((sPtr >= 0) != (tPtr >= 0)){
                return false;
            }
            sPtr--;
            tPtr--;
        }

        return true;
    }

    public static boolean backspaceCompareStackApp(String S, String T) {
        return build(S).equals(build(T));
    }

    public static String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    //     public boolean backspaceCompare(String s, String t) {
//         if(s.length() == 0 || t.length() == 0) return false;

//         Stack<Character> sStack = new Stack<>();
//         Stack<Character> tStack = new Stack<>();

//         for(char currChar : s.toCharArray()){
//             if(currChar == '#'){
//                 if(!sStack.isEmpty()){
//                     sStack.pop();
//                 }
//             }else{
//                 sStack.push(currChar);
//             }
//         }

//         for(char currChar : t.toCharArray()){
//             if(currChar == '#'){
//                 if(!tStack.isEmpty()){
//                     tStack.pop();
//                 }
//             }else{
//                 tStack.push(currChar);
//             }
//         }

//         // System.out.println(sStack.toString());
//         // System.out.println(tStack.toString());

//         return sStack.toString().equalsIgnoreCase(tStack.toString());
//     }
}

package DynamicProgramming;

//394. Decode String
public class DecodingString {
    static int index = 0;
    public static void main(String args[]) {
        String s1 = "3[a2[c]]";
        String s2 = "2[abc]3[cd]ef";
        System.out.println(decodeString(s1));
        System.out.println(decodeString(s2));
    }

    public static String decodeString(String s) {
        if (s.length() == 0)return "";

        return decodeStringRecursive(s);
    }

    private static String decodeStringRecursive(String s) {
        StringBuilder res = new StringBuilder();
        System.out.println("index: "+index);

        while (index < s.length() && s.charAt(index) != ']'){
            if(!Character.isDigit(s.charAt(index))){
                res.append(s.charAt(index));
                index++;
            }else { //DIGIT
                //"2[abc]3[cd]ef"
                int num = 0;
                while (index < s.length() && s.charAt(index) != '['){
                    num = (num * 10) + s.charAt(index) - '0';
                    index++;
                }

                index++;    //Ignore [
                String insideStr = decodeStringRecursive(s);
                index++; //Ignore ]

                while (num > 0){
                    res.append(insideStr);
                    num--;
                }
            }
        }

        return res.toString();
    }
}

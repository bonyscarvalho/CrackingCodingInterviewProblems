package LeetCodeMedium;

public class CountAndSay {

    public static void main(String[] args) {

        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if(n == 1) return "1";

        String val = "1";   //n --> 1

        for(int num = 2; num <= n; num++){ //2 to n
            char ch = val.charAt(0);
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for(int idx = 1; idx < val.length(); idx++){
                if(ch != val.charAt(idx)){
                    sb.append(count).append(ch);
                    ch = val.charAt(idx);
                    count = 0;
                }
                count++;
            }
            sb.append(count).append(ch);
            val = sb.toString();
        }

        return val;
    }
}

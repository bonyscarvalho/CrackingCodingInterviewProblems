package ChapterBigO;

public class PermutationOfString {
    public static void main(String[] args) {
        permutation("ABC", "");
    }

    private static void permutation(String str, String prefix) {
        if(str.length() == 0){
            System.out.println("Result: " + prefix);
        }else{
            for(int i = 0; i < str.length(); i++){
                String remaining = str.substring(0, i) + str.substring(i + 1);      // for i is 0 we have C remaining and for 1 be have B remaining which creates different combinations
                permutation(remaining, prefix + str.charAt(i));
            }
        }
    }
}

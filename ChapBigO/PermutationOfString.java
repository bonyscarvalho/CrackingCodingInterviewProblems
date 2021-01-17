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
                String remaining = str.substring(0, i) + str.substring(i + 1);      // for i = 0, remaining is BC and prefix is A as we add str.charAt(i), 
// for i = 0 we have C remaining and for i= 1 be have B remaining which creates different combinations
                permutation(remaining, prefix + str.charAt(i));
            }
        }
    }
}

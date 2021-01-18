public class IsUniqueStringOfCharaceters {
    public static void main(String args[]){
        String unique = "abcdefg";
        String notUnique = "abcddeeddff";
        boolean isUnique1 = isUniqueString(unique);
        boolean isUnique2 = isUniqueString(notUnique);
        System.out.println("String 1 is "+ isUnique1 + " String 2 is " + isUnique2);
    }

    private static boolean isUniqueString(String unique) {
        if(unique.length() == 0) return false;
        int checkerMask = 0;
        for(int i = 0; i < unique.length(); i++){
            int bitIndexValue = unique.charAt(i) - 'a';

            //you leftshift the current bitIndex as to compare with mask with the same Index
            // for a it will the checker is 1 b 2 c 4 d 8 e 16
            // and if that value of any previous character comes up again our check has the Index Masked and the value returned will be greater
            // than 1 which is false;
            if((checkerMask & (1 << bitIndexValue)) > 0){
                return false;
            }
            checkerMask = checkerMask | 1 << bitIndexValue;
        }
        return true;
    }

    //Efficient way with extra space of Array. Can we done in Set way too;
//    private static boolean isUniqueString(String unique) {
//        if(unique.length() == 0) return false;
//
//        int[] charCount = new int[26];
//        int i = 0;
//        while(i < unique.length()){
//            if(charCount[unique.charAt(i) - 'a']++ > 0){
//                System.out.println("Character is " + (unique.charAt(i) - 'a'));
//                return false;
//            }
//            i++;
//        }
//        return true;
//    }
}

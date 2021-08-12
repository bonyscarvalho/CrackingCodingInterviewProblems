package Extra;

//67. Add Binary
public class AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a, b));
    }
    public static String addBinary(String a, String b) {
        if(a.length() == 0 && b.length() == 0)return "";
        if(a.length() == 0) return b;
        if(b.length() == 0)return a;

        StringBuilder addition = new StringBuilder();
        int aIdx = a.length() - 1, bIdx = b.length() - 1;
        int carry = 0;

        while(aIdx >= 0 || bIdx >=0){
            int valA = aIdx < 0 ? 0 : a.charAt(aIdx) - '0';
            int valB = bIdx < 0 ? 0 : b.charAt(bIdx) - '0';

            System.out.println(valA +" " + valB);

            int sum = valA + valB + carry;
            carry = sum >= 2 ? 1 : 0;
            addition.append(sum%2);
            System.out.println("VALUES: " + valA +" " + valB + " "+ sum + " " + carry + " Sum: " + addition.toString());

            aIdx--;
            bIdx--;
        }
        if(carry == 1){
            addition.append('1');
        }

        return addition.reverse().toString();
    }
}

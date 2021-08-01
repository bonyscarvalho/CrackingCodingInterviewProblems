package FacebookQuestions;

public class RotationalCipher {

    public static void main(String args[]) {
        String input = "Zebra-493?";
        int rotationFactor = 3;
        System.out.println(rotationalCipher(input, rotationFactor));
    }

    public static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        if(input.length() == 0) return "";
        StringBuilder ciphered = new StringBuilder();
        rotationFactor = rotationFactor % 26;

        for(char curr: input.toCharArray()){
            if(Character.isDigit(curr)){
                int val = curr - '0';
                ciphered.append((val + rotationFactor) % 10);
            }else if(Character.isUpperCase(curr)){
                int valUp = (curr + rotationFactor - 65) % 26 + 65;
                //int updatedVal = valUp >  90 ? ((valUp%90)  + 64) : valUp;
                ciphered.append((char)valUp);
            }else if(Character.isLowerCase(curr)){
                int valLo = (curr + rotationFactor - 97) % 26 + 97;
                //int updatedVal = valLo <= 122 ? valLo : (96 + (valLo%122));
                ciphered.append((char)valLo);
            }else {
                ciphered.append(curr);
            }
        }

        return ciphered.toString();
    }
}

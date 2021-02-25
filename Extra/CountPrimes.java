package Extra;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String args[]) {
        int num = 50;
        int numOfPrimes = countNumberOfPrimes(num);
        System.out.println("Number of Primes: " + numOfPrimes);
    }

    private static int countNumberOfPrimes(int num) {
        if(num == 0 || num == 1) return 0;

        boolean[] count = new boolean[num];
        //Arrays.fill(count, true);         //Optimization 
//        for(int i = 2; i < num; i++){
//            count[i] = true;
//        }

        for (int i = 2; i*i < num; i++){
            if(!count[i]){
                for(int j = i; (i*j) < num; j++){
                    count[i * j] = true;
                }
            }
        }
        int primeCount = 0;
        for(int i = 2; i < num; i++){
            if(!count[i]){
                primeCount++;
                System.out.println("Prime: "+i);
            }
        }
        return primeCount;
    }
}

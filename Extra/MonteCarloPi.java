package Extra;

public class MonteCarloPi {
    public static void main(String[] args) {
        int numOfTrials = 1000000;
        Double centerX = 0.0, centerY = 0.0;
        double pi = 0.0;

        double n = 0.0;
        for(int trial  = 1; trial <= numOfTrials; trial++){
            Double x = Math.random();
            Double y = Math.random();

            if((Math.pow(x, 2) + Math.pow(y, 2)) <= 1){
                n++;
            }

            pi = (4 * n) / trial;
        }
        System.out.println("PI Value: " + pi);
    }
}

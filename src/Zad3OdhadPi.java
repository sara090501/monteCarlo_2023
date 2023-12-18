import OSPRNG.UniformContinuousRNG;

public class Zad3OdhadPi {
    public static void main(String[] args) {
        int pocetOpakovani = 1000000;
        UniformContinuousRNG xGen = new UniformContinuousRNG(0.0, 1.0);
        UniformContinuousRNG yGen = new UniformContinuousRNG(0.0, 1.0);
        int padli = 0;

        double sX = 0.5;
        double sY = 0.5;
        double r = 0.5;

        for (int i = 0; i < pocetOpakovani; i++) {
            double x = xGen.sample();
            double y = yGen.sample();

            if ((Math.pow((x-sX), 2) + Math.pow((y-sY), 2)) <= Math.pow(r, 2)) {
                padli++;
            }
        }

        double odhadPi = ((double) padli/pocetOpakovani) / Math.pow(r, 2);

        System.out.printf("Odhad pi je " + odhadPi);
    }
}

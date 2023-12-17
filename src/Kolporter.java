import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

public class Kolporter {
    public static void main(String[] args) {
        int pocetReplikacii = 100000;
        double nakupnaCena = 0.15;
        double vykupnaCena = nakupnaCena*0.65;
        TriangularRNG predajnaCenaGen = new TriangularRNG(0.25, 0.6, 0.95);
        UniformContinuousRNG dlzkaPredajaGen = new UniformContinuousRNG(250.0, 420.0);

        int pocetBalikov = 0;
        double najvyssiZisk = 0;

        for (int i = 1; i < 50; i++) {
            double napocitanyZisk = 0;

            for (int j = 1; j < pocetReplikacii; j++) {
                double predajnaCena = predajnaCenaGen.sample();
                int dopyt = (int) (dlzkaPredajaGen.sample() / 2.7) + 1;
                int nakupene = i * 10;
                int predane = Math.min(dopyt, nakupene);

                double zisk = (predajnaCena * predane) - (0.15 * nakupene) + (vykupnaCena * (nakupene - predane));

                napocitanyZisk += zisk;
            }

            double celkovyZisk = napocitanyZisk / pocetReplikacii;

            if (najvyssiZisk < celkovyZisk) {
                najvyssiZisk = celkovyZisk;
                pocetBalikov = i;
            }
        }

        System.out.print("Najvyssi zisk je " + najvyssiZisk);
        System.out.print(" pri " + pocetBalikov + " balikoch.");
    }
}

import OSPRNG.UniformContinuousRNG;

public class Zad4AOpityNamornik {
    public static void main(String[] args) {
        UniformContinuousRNG smerGen = new UniformContinuousRNG(0.0, 1.0);
        int pocetOpakovani = 100000;
        int pocetKrokov = 1000;
        double vzdialenost = 0;

        for (int i = 0; i < pocetOpakovani; i++) {
            double pohyb = 0;
            for (int j = 0; j < pocetKrokov; j++) {
                double smer = smerGen.sample();

                if (smer <= 0.5) {
                    pohyb += 1.0;
                } else {
                    pohyb -= 1.0;
                }
            }

            vzdialenost += Math.abs(pohyb);
        }

        double pozicia = vzdialenost/pocetOpakovani;

        System.out.printf("Pozicia namornika je: " + pozicia);
    }
}

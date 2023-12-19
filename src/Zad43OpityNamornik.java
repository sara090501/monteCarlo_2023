import OSPRNG.UniformContinuousRNG;

public class Zad43OpityNamornik {
    public static void main(String[] args) {
        UniformContinuousRNG smerGen = new UniformContinuousRNG(0.0, 3.0);

        int pocetOpakovani = 100000;
        int pocetKrokov = 1000;
        double vzdialenostNaX = 0;
        double vzdialenostNaY = 0;
        double vzdialenostNaZ = 0;

        for (int i = 0; i < pocetOpakovani; i++) {
            int xOs = 0;
            int yOs = 0;
            int zOs = 0;
            for (int j = 0; j < pocetKrokov; j++) {
                double smer = smerGen.sample();

                if (smer < 0.5) {
                    xOs++;
                } else if (smer < 1) {
                    xOs--;
                } else if (smer < 1.5) {
                    yOs++;
                } else if (smer < 2) {
                    yOs--;
                } else if (smer < 2.5) {
                    zOs++;
                } else {
                    zOs--;
                }
            }

            vzdialenostNaX += Math.abs(xOs);
            vzdialenostNaY += Math.abs(yOs);
            vzdialenostNaZ += Math.abs(zOs);
        }

        double vzdialenostOdZaciatkuX = vzdialenostNaX/pocetOpakovani;
        double vzdialenostOdZaciatkuY = vzdialenostNaY/pocetOpakovani;
        double vzdialenostOdZaciatkuZ = vzdialenostNaZ/pocetOpakovani;

        double vzdialenostOdZaciatku = vzdialenostOdZaciatkuX + vzdialenostOdZaciatkuY + vzdialenostOdZaciatkuZ;

        System.out.printf("Vzdialenost od zaciatku je: " + vzdialenostOdZaciatku);
    }
}

import OSPRNG.UniformContinuousRNG;

public class Zad42OpityNamornik {
    public static void main(String[] args) {
        UniformContinuousRNG smerGen = new UniformContinuousRNG(0.0, 1.0);

        int pocetOpakovani = 100000;
        int pocetKrokov = 1000;
        double vzdialenostNaX = 0;
        double vzdialenostNaY = 0;

        for (int i = 0; i < pocetOpakovani; i++) {
            int xOs = 0;
            int yOs = 0;
            for (int j = 0; j < pocetKrokov; j++) {
                double smer = smerGen.sample();

                if (smer < 0.25) {
                    xOs++;
                } else if (smer < 0.5) {
                    xOs--;
                } else if (smer < 0.75){
                    yOs++;
                } else {
                    yOs--;
                }
            }

            vzdialenostNaX += Math.abs(xOs);
            vzdialenostNaY += Math.abs(yOs);
        }

        double vzdialenostOdZaciatkuX = vzdialenostNaX/pocetOpakovani;
        double vzdialenostOdZaciatkuY = vzdialenostNaY/pocetOpakovani;

        double vzdialenostOdZaciatku = vzdialenostOdZaciatkuX + vzdialenostOdZaciatkuY;

        System.out.printf("Vzdialenost od zaciatku je: " + vzdialenostOdZaciatku);
    }
}

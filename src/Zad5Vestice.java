import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

public class Zad5Vestice {
    public static void main(String[] args) {
        UniformContinuousRNG odpovedGen = new UniformContinuousRNG(0.0, 1.0);
//        TriangularRNG odpovedGen = new TriangularRNG(0.3, 0.8, 1.0);

        int pocetOpakovani = 10000000;

        double odpovedaliRovnako2 = 0;
        double odpovedaliPravdu2 = 0;
        double odpovedaliRovnako3 = 0;
        double odpovedaliPravdu3 = 0;

        for (int i = 0; i < pocetOpakovani; i++) {
            boolean odpovedPrvej = odpovedGen.sample() < 0.8;
            boolean odpovedDruhej = odpovedGen.sample() < 0.8;
            boolean odpovedTretej = odpovedGen.sample() < 0.8;

            if (odpovedPrvej == odpovedDruhej) {
                odpovedaliRovnako2++;
                if (odpovedPrvej) {
                    odpovedaliPravdu2++;
                }
            }

            if (odpovedPrvej == odpovedDruhej && odpovedPrvej == odpovedTretej) {
                odpovedaliRovnako3++;
                if (odpovedPrvej) {
                    odpovedaliPravdu3++;
                }
            }
        }

        double pravDveOdpovedaliPravdu = (odpovedaliPravdu2 / odpovedaliRovnako2) * 100;
        double pravTriOdpovedaliPravdu = (odpovedaliPravdu3 / odpovedaliRovnako3) * 100;

        System.out.println("Dve odpovedali pravdu: " + pravDveOdpovedaliPravdu);
        System.out.println("Tri odpovedali pravdu: " + pravTriOdpovedaliPravdu);
    }
}

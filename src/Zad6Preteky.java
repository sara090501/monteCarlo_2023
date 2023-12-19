import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Zad6Preteky {
    public static void main(String[] args) {
        TriangularRNG fastGen = new TriangularRNG(40.0, 50.0, 75.0);
        TriangularRNG furiousGen = new TriangularRNG(35.0, 52.0, 80.0);

        int pocetOpakovani = 100000;

        for (int i = 0; i < pocetOpakovani; i++) {

            ArrayList<Double> times = new ArrayList<>();
            ArrayList<Integer> range = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                times.add(fastGen.sample());
                range.add(i+1);
            }
            for (int j = 0; j < 5; j++) {
                times.add(furiousGen.sample());
                range.add(i+6);
            }

//            sort
//            for (int j = 0; j < ; j++) {
//                for (int k = 0; k < ; k++) {
//
//                }
//            }
        }
    }
}

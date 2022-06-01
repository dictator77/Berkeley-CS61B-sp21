package gh2;

import deque.ArrayDeque;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class HarpHero {
    public static final double CONCERT_A = 440.0;
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {

        ArrayDeque<Harp> ad = new ArrayDeque<>();
        for (int i = 0; i < keyboard.length(); i++) {
            ad.addLast(new Harp(CONCERT_A * Math.pow(2, (i - 24) * 1.0 / 12)));
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) != -1) {
                    int index = keyboard.indexOf(key);
                    ad.get(index).pluck();
                }else {
                    continue;
                }
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (int i = 0; i < keyboard.length(); i++) {
                sample += ad.get(i).sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < keyboard.length(); i++) {
                ad.get(i).tic();
            }
            //stringC.tic();
        }
    }

}

package Utils;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    /**
     * @param min The minimum value
     * @param max The maximum value.
     * @return a pseudo-random integer between min (inclusive) and max (inclusive)
     */
    public static int randInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}

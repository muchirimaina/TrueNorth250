public class PoisonTest {

    static final int STRIPS = 10;
    static final int TOTAL_BOTTLES = 1000;

    // STEP 1: encode all bottles into strips
    public static void applyDrops(boolean[][] stripDrops) {
        for (int bottle = 0; bottle < TOTAL_BOTTLES; bottle++) {
            for (int bit = 0; bit < STRIPS; bit++) {
                if (((bottle >> bit) & 1) == 1) {
                    stripDrops[bit][bottle] = true;
                }
            }
        }
    }

    // STEP 2: simulate 7-day poison effect
    public static boolean[] runTest(boolean[][] stripDrops, int poisonedBottle) {
        boolean[] resultStrips = new boolean[STRIPS];

        for (int bit = 0; bit < STRIPS; bit++) {
            if (stripDrops[bit][poisonedBottle]) {
                resultStrips[bit] = true;
            }
        }

        return resultStrips;
    }

    // STEP 3: decode answer
    public static int decode(boolean[] strips) {
        int result = 0;

        for (int bit = 0; bit < STRIPS; bit++) {
            if (strips[bit]) {
                result |= (1 << bit);
            }
        }

        return result;
    }

    // TEST ONLY
    public static void main(String[] args) {

        int poisonedBottle = 537;

        boolean[][] stripDrops = new boolean[STRIPS][TOTAL_BOTTLES];

        applyDrops(stripDrops);

        boolean[] resultStrips = runTest(stripDrops, poisonedBottle);

        int answer = decode(resultStrips);

        System.out.println("Poisoned bottle = " + answer);
    }
}
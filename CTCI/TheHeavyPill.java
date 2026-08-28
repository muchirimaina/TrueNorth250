//Using integers Only to avoid conversion and this is a clean way to do it


public static int theHeavyPill(int[] pills) {

    int expected = 0;
    int actual = 0;

    for (int i = 0; i < pills.length; i++) {
        int count = i + 1;

        expected += count * 10;      // normal pill = 10 units
        actual += count * pills[i];  // pills are either 10 or 11 units
    }

    int diff = actual - expected;

    return diff; // directly the index
}

// TC: O(n) SC: O(1)


// Using doubles

public static int theHeavyPill(double[] bottles) {
    double expected = 0;
    double actual = 0;

    for (int i = 0; i < bottles.length; i++) {
        int count = i + 1;
        expected += count * 1.0;
        actual += count * bottles[i];
    }

    double diff = actual - expected;

    return (int) Math.round(diff / 0.1);
}

//We use double instead of float because:

//double is more precise and less likely to produce rounding errors. i.e 
// | Type   | Size   | Precision (approx)    |
// | ------ | ------ | --------------------- |
// | float  | 32-bit | ~7 decimal digits     |
// | double | 64-bit | ~15–16 decimal digits |

// TC: O(n) SC: O(1)





// Extra Missing Number XOR
int xor = 0;

for (int i = 0; i <= n; i++) {
    xor ^= i;
}

for (int num : arr) {
    xor ^= num;
}

return xor;



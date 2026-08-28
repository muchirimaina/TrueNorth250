public class EggDrop {

    public static int eggDrop(int floors, int N) {

        // Step 1: find optimal starting jump (triangular number)
        int step = 0;
        while ((step * (step + 1)) / 2 < floors) {
            step++;
        }

        int currentFloor = 0;
        int previousFloor = 0;

        // Step 2: first egg (decreasing jumps)
        while (currentFloor < floors && step > 0) {
            previousFloor = currentFloor;
            currentFloor = currentFloor + step;

            System.out.println("Drop Egg1 at: " + currentFloor);

            // simulate break condition directly
            if (currentFloor >= N) {

                // Step 3: second egg (linear search)
                for (int i = previousFloor + 1; i < currentFloor; i++) {
                    System.out.println("Drop Egg2 at: " + i);

                    if (i >= N) {
                        return i;
                    }
                }

                return currentFloor;
            }

            step--;
        }

        return floors;
    }

    public static void main(String[] args) {
        int floors = 100;
        int N = 73; // hidden critical floor

        int result = eggDrop(floors, N);
        System.out.println("Critical floor found: " + result);
    }
}



// Time Complexity
// O(√n)
// Why:
// First egg: ~√n jumps
// Second egg: worst-case ~√n linear scan
// For 100 floors → ~14 + 14 = ~28 drops

// Space Complexity
// O(1)
public class LockerNaive {

    public static void main(String[] args) {
        int n = 100;
        boolean[] lockers = new boolean[n + 1];

        for (int pass = 1; pass <= n; pass++) {
            for (int locker = 1; locker <= n; locker++) {
                if (locker % pass == 0) {
                    lockers[locker] = !lockers[locker];
                }
            }
        }

        int openCount = 0;
        for (int i = 1; i <= n; i++) {
            if (lockers[i]) openCount++;
        }

        System.out.println(openCount);
    }
}

// TC = O(n^2)
// SC= O(n) - Store only the lockers






public class LockersSimulation {

    public static void main(String[] args) {
        int n = 100;
        boolean[] lockers = new boolean[n + 1]; 
        // false = closed, true = open

        // simulate passes 1 to n
        for (int pass = 1; pass <= n; pass++) {
            for (int locker = pass; locker <= n; locker += pass) {
                lockers[locker] = !lockers[locker]; // toggle
            }
        }

        // count open lockers
        int openCount = 0;
        for (int i = 1; i <= n; i++) {
            if (lockers[i]) {
                openCount++;
                System.out.print(i + " ");
            }
        }

        System.out.println("\nOpen lockers count: " + openCount);
    }
}



// TC = O(nlogn)
// SC = O(n) - Store the lockers
 



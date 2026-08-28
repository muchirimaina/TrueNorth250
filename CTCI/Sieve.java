public class Sieve {

    public static boolean[] sieve(int max) {
        boolean[] isPrime = new boolean[max + 1];

        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        int prime = 2;

        while (prime * prime <= max) {

            crossOff(isPrime, prime);

            prime = getNextPrime(isPrime, prime);
        }

        return isPrime;
    }

    private static void crossOff(boolean[] isPrime, int prime) {
        for (int i = prime * prime; i < isPrime.length; i += prime) {
            isPrime[i] = false;
        }
    }

    private static int getNextPrime(boolean[] isPrime, int currentPrime) {
        int next = currentPrime + 1;

        while (next < isPrime.length && !isPrime[next]) {
            next++;
        }

        return next;
    }

    public static void main(String[] args) {
        boolean[] primes = sieve(20);

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
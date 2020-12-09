import java.util.Arrays;
import java.util.Scanner;

class LearningDS {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        boolean[] isPrime = new boolean[num + 1];

        for (int i = 0; i < num; i++) // initially let all are primes
            isPrime[i] = true;

        isPrime[0] = false; // 0 is not a prime number
        isPrime[1] = false; // 1 is not a prime number

        for (int i = 2; i * i <= num; i++) { // starting from 2
            if (isPrime[i]) {
                for (int j = i * i; j <= num; j += i) // make every multiple of current number false
                    isPrime[j] = false;
            }
        }

        for (int i = 0; i <= num; i++) // print
            if(isPrime[i])
                System.out.println(i);
    }
}
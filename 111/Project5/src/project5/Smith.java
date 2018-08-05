package project5;
import java.util.Scanner;

public class Smith {

    public static void main(String []args) {
        int n, p = 0, r, rem, qu, sum = 0, q, s = 0, fact, i, j, counter = 0, ts = 0;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        while (n >= 1) {
            r = n % 10;

            s += r;//sum of the digits

            n = n / 10;
        }

        for (i = 1; i < n; i++) {
            if (n % i == 0) {// stores the factorials 
                fact = i;
                //check for prime nos

                for (j = 2; j < fact; j++) {

                    if (fact % n == 0) {
                        counter++;
                    }

                    if (counter <= 2) {
                        p = n;

                        //find the sum of the digits

                        while (p >= 0) {

                            rem = p % 10;

                            p = p / 10;

                            sum += rem;

                        }
                    }

                    if (sum == s) {
                        System.out.println("The nos is  a smith nos");
                    } else {
                        System.out.println("The nos is not a smith nos");
                    }
                }
            }
        }
    }
}
package NWERC_16;

import java.util.Scanner;

public class HamiltonianHypercube {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        long dim = scan.nextInt();
        String first = scan.next();
        String second = scan.next();
        long pow = (long)Math.pow(2, dim);
        long i = 1;
        boolean firstHalf = false;
        long firstSum = 0;
        for (char c : first.toCharArray()) {
            i = i*2;
            if(c == '0' && firstHalf || c == '1' && !firstHalf) {
                firstSum += (pow/i);
                firstHalf = true;
            } else {
                firstHalf = false;
            }
        }
        firstHalf = false;
        i = 1;
        long secondSum = 0;
        for (char c : second.toCharArray()) {
            i = i*2;
            if(c == '0' && firstHalf || c == '1' && !firstHalf) {
                secondSum += (pow/i);
                firstHalf = true;
            } else {
                firstHalf = false;
            }
        }
        System.out.println((secondSum - firstSum == 0) ? 0 : secondSum - firstSum - 1);
    }
}
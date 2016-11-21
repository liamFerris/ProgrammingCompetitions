package UKIEPC_16;

import java.util.Scanner;
public class Fridge {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String fridgeInput = scan.nextLine();
        char [] charArray = fridgeInput.toCharArray();
        int [] magnitude = new int[10];

        for (char c : charArray) {
            int digit = Integer.parseInt(String.valueOf(c));
            magnitude[digit]++;
        }

        int minDigit = 0;
        int minCount = magnitude[0] + 1;

        for (int i = 1; i < 10; i++) {
            minDigit = (minCount > magnitude[i]) ? i : minDigit;
            minCount = (minCount > magnitude[i]) ? magnitude[i] : minCount;
        }

        if (minDigit != 0) {
            for (int i = 0; i <= minCount; i++){
                System.out.print(minDigit);
            }
        } else {
            System.out.print(1);
            for (int i = 0; i < minCount; i++) {
                System.out.print(minDigit);
            }
        }
    }
}
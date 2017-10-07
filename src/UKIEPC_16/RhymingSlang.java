package UKIEPC_16;

import java.util.ArrayList;
import java.util.Scanner;

public class RhymingSlang {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        String commonWord = scan.next();
        int numberOfLists = scan.nextInt();
        scan.nextLine();

        ArrayList<String>[] rhymeLists = new ArrayList[numberOfLists];
        for (int i = 0; i < numberOfLists; i++) {
            rhymeLists[i] = new ArrayList<String>();
            String line = scan.nextLine();
            boolean stillGoing = true;
            while (stillGoing) {
                String add = line.substring(line.lastIndexOf(" ") + 1, line.length());
                if (add.equals("")) {
                    stillGoing = false;
                } else {
                    rhymeLists[i].add(add);
                    if (line.lastIndexOf(" ") != -1) {
                        line = line.substring(0, line.lastIndexOf(" "));
                    } else {
                        stillGoing = false;
                    }
                }
            }
        }
        
        int numberOfSentences = scan.nextInt();
        scan.nextLine();
        ArrayList<String> sentences = new ArrayList<>();

        for (int i = 0; i < numberOfSentences; i++) {
            sentences.add(scan.nextLine());
        }

        ArrayList<String> suffix = new ArrayList();

        for (int i = 0; i < rhymeLists.length; i++) {
            if (rhymeLists[i].stream().filter(j -> commonWord.endsWith(j)).count() > 1) {
                rhymeLists[i].forEach(j -> suffix.add(j));
            }
        }
    }
}

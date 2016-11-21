package NWERC_16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExamRedistribution {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int numberOfRooms = scan.nextInt();
        ArrayList<Integer> students = new ArrayList<Integer>();

        for (int i =0; i < numberOfRooms; i++) {
            students.add(scan.nextInt());
        }

        ArrayList<Integer> studentClone = (ArrayList<Integer>) students.clone();
        Collections.sort(students);

        if (students.get(numberOfRooms - 1) > students.stream().mapToInt(i->i).sum()*2) {
            System.out.println("impossible");
        } else {
            
            for (int i = numberOfRooms - 1; i >= 0; i--) {
                System.out.print(studentClone.indexOf(students.get(i)) + 1 + " ");
                studentClone.set(studentClone.indexOf(students.get(i)), 0);
            }
        }
    }
}

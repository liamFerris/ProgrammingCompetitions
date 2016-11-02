import java.util.ArrayList;
import java.util.Scanner;

public class ProblemI {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        double costOfSeed = scan.nextDouble();
        int lawnsToSow = scan.nextInt();
        ArrayList<Double> lawnArea = new ArrayList();

        for (int i = 0; i < lawnsToSow; i++) {
            lawnArea.add(scan.nextDouble() * scan.nextDouble());
        }

        System.out.println(lawnArea.stream().mapToDouble(i -> i).sum() * costOfSeed);

    }
}

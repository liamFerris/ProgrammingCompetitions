package NWERC_16;

import java.util.ArrayList;
import java.util.Scanner;

class CarefulAscent {
    static Scanner scanner = new Scanner(System.in);

    double speedFactor;

    public static void main(String[] args) {
        int distance = scanner.nextInt();
        int time = scanner.nextInt();
        int numShields = scanner.nextInt();
        int lowerShieldBoundary;
        int upperShieldBoundary;
        int totalShieldTime = 0;
        double speed;
        int shieldTime;
        double totalSpeedFactor = 0;

        ArrayList<CarefulAscent> shieldStats = new ArrayList<>();

        for (int i = 0; i < numShields; i++) {
            CarefulAscent shield = new CarefulAscent();
            lowerShieldBoundary = scanner.nextInt();
            upperShieldBoundary = scanner.nextInt();
            shieldTime = upperShieldBoundary - lowerShieldBoundary;
            speed = scanner.nextDouble();
            totalShieldTime += shieldTime;
            shield.speedFactor = speed * shieldTime;
            shieldStats.add(shield);
        }

        for (CarefulAscent shield : shieldStats) {
            totalSpeedFactor += shield.speedFactor;
        }

        if (totalShieldTime == time) {
            System.out.println(distance/totalSpeedFactor);
        } else {
            totalSpeedFactor += time - totalShieldTime;
            System.out.println(distance/totalSpeedFactor);
        }
    }
}

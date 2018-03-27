

import java.util.Scanner;

public class Main {
    private final static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int number = input.nextInt();
        float[] result = new float[5];
        int exchange = 1, count = 0;
        for (int i = 0; i < number; i++) {
            int temp = input.nextInt();
            if (temp % 5 == 0) {
                if (temp % 2 == 0) {
                    result[0] += temp;
                }
            }
            if (temp % 5 == 1) {
                result[1] += (temp * exchange);
                exchange = -exchange;
            }
            if (temp % 5 == 2) {
                ++result[2];
            }
            if (temp % 5 == 3) {
                result[3] += temp;
                ++count;
            }
            if (temp % 5 == 4) {
                if (result[4] < temp) {
                    result[4] = temp;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                System.out.println((i==4)?"N":"N ");
            } else if (i == 3) {
                System.out.print(String.format("%.1f", result[i] / count) + " ");
            } else if ((i == 4)) {
                System.out.print((int) result[i]);
            }else {
                System.out.print((i==4)?(int) result[i]:(int) result[i] + " ");
            }
        }
    }
}
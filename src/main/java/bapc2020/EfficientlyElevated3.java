package bapc2020;

import java.util.Scanner;

public class EfficientlyElevated3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();

        int[][] heights = new int[height + 2][width + 2];
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                heights[i][j] = sc.nextInt();
            }
        }

        int amount = 0;
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                int h = heights[i][j];
                if (h <= 1) continue;
                if (/* up */ heights[i - 1][j] < h
                        /* left */ && heights[i][j - 1] < h
                        /* down */ && heights[i + 1][j] <= h
                        /* right */ && heights[i][j + 1] <= h)
                    amount++;
            }
        }

        System.out.println(amount);;
    }

}

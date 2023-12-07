package minApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 命令行扫雷(未完成)
 * @author Iammm
 * @Time 2023/12/4 18:18
 */
public class saoLeiCmd {
}

class saoLeiC {
    private final int[][][] map;
    private final int thicknes = 3;
    private final int grow;
    private final int width;
    private final int Mine_GRID = -1;
    private final int UNOPENED_GRID = -2;

    private final int floorIndex_probability = 1;
    private final int floorIndex_number = 0;
    private final int floorIndex_mine = 2;

    private final int calculateStartingPoint_X = 0;
    private final int calculateStartingPoint_Y = 0;
    private int numberOfMines;
    private int numberOfOpenedGrids;

    saoLeiC(int grow, int width, int numberOfMines) {
        this.grow = grow;
        this.width = width;
        map = new int[grow][width][thicknes];
        for (int i = 0; i < grow; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < thicknes; k++) {
                    map[i][j][k] = k == floorIndex_number ? UNOPENED_GRID : 0;
                }
            }
        }
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < numberOfMines; i++) {
            map[random.nextInt(grow)][random.nextInt(width)][floorIndex_number] = Mine_GRID;
        }
        calculate();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入宽和高,以及雷的数量");
        int grow = scanner.nextInt();
        int width = scanner.nextInt();
        int numberOfMines = scanner.nextInt();
        saoLeiC saoLeiC = new saoLeiC(grow, width, numberOfMines);
        saoLeiC.seeMap();
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            saoLeiC.open(x, y);
            saoLeiC
                    .seeMap();
        }
    }

    public void open(int x, int y) {
        map[x][y][floorIndex_number] =
                map[x][y][floorIndex_number] == UNOPENED_GRID ? UNOPENED_GRID : map[x][y][floorIndex_number] - 1;
        calculate();
    }

    private void calculate() {
        for (int i = calculateStartingPoint_X; i < grow; i++) {
            for (int j = calculateStartingPoint_Y; j < width; j++) {
                if (map[i][j][floorIndex_number] != UNOPENED_GRID) {
                    calculateProbability(i, j, map[i][j][floorIndex_mine]);
                }
            }
        }
    }

    private void calculateProbability(int x, int y, int value) {
        fillProbability(x, y, (double) value / checkTheSurroundingGrid(x, y) * 10);
        fillNumber(x, y, checkTheSurroundingGrid(x, y));
    }

    private void fillNumber(int x, int y, int numberOfMines) {
        map[x][y][floorIndex_number] = numberOfMines;
    }

    private void fillProbability(int x, int y, double value) {
        // 向x，y周围的格子增加概率
        for (minApp.coordinateC coordinateC : getNeighbors(x, y)) {
            map[coordinateC.x][coordinateC.y][floorIndex_probability] += 1;
            map[coordinateC.x][coordinateC.y][floorIndex_number] += 1;
        }
    }

    private List<coordinateC> getNeighbors(int x, int y) {
        List<coordinateC> neighbors = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                var x1 = x + i;
                var y1 = y + j;
                if (i == 0 && j == 0) {
                    continue; // 跳过当前位置
                } else if (x1 < 0 || x1 >= grow || y1 < 0 || y1 >= width) {
                    continue;
                }
                neighbors.add(new coordinateC(x1, y1));
            }
        }
        return neighbors;
    }

    private int checkTheSurroundingGrid(int x, int y) {
        int mineNum = 0;
        for (minApp.coordinateC coordinateC : getNeighbors(x, y)) {
            if (map[coordinateC.x][coordinateC.y][floorIndex_mine] == Mine_GRID) {
                mineNum++;
            }
        }
        return mineNum;
    }

    public void seeMap() {
        for (int k = 0; k < thicknes; k++) {
            for (int i = 0; i < grow; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(String.format("%3d", map[i][j][k]) + " ");
                }
                System.out.println();
            }
            System.out.println("------------------" + k + "------------------------");
        }
    }
}

class coordinateC {
    int x;
    int y;

    coordinateC(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
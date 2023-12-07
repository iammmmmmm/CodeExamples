package minApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 扫雷计算器，按行输入每一行的情况,输出两个数组，第一个数组为每个格子的雷数，第二个数组为每个格子的概率（概率越大越可能是），注意！！！这是可能性，大小只表示可能性大小，无单位，大小无限制。
 * eg：（9x9的模式）第一行 第一个格子显示0（即空白），第二个格子显示1，其余都是未打开
 * 输入： 0 1 11 22 11 22 22 22 99
 * （每个格子显示几就输入几（空白输入0），如果是未打开的输入任意大于10的整数）
 * \n
 * 第一层为数字
 * 第二层为每个格子的概率
 * 第三层为是否有雷
 *
 * @author Iammm
 * @Time 2023/12/4 11:31
 */
public class saoLei {
    private final int thicknes = 3;
    private final int BLANK_GRID = -1;
    private final int UNOPENED_GRID = -2;
    private final int floorIndex_probability = 1;
    private final int floorIndex_number = 0;
    private final int calculateStartingPoint_X = 0;
    private final int calculateStartingPoint_Y = 0;
    private int[][][] map = new int[0][0][0];
    private int grow = 0;
    private int width = 0;

    saoLei(int grow, int width) {
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
    }

    saoLei() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入长");
        int grow = scanner.nextInt();
        System.out.println("请输入宽");
        int width = scanner.nextInt();
        saoLei a = new saoLei(grow, width);
        input(scanner, a);
    }


    public static void main(String[] args) {
        new saoLei();
    }

    void input(Scanner scanner, saoLei a) {
        do {
            for (int i = 0; i < a.grow; i++) {
                for (int j = 0; j < a.width; j++) {
                    System.out.println("请输第" + (i + 1) + "行第" + (j + 1) + "列格子的值");
                    var value = scanner.nextInt();
                    a.inPut(i, j, value > 9 ? -2 : value);
                    a.seeMap();
                }
            }
            System.out.println("请输入1从头再次输入，请输入2新开下一局，输入0退出");
            var c = scanner.nextInt();
            if (c == 0) {
                a.seeMap();
                System.exit(0);
            } else if (c == 1) {
                input(scanner, a);
            } else if (c == 2) {
                new saoLei();
            }
        } while (scanner.hasNext());

    }

    public void inPut(int x, int y, int value) {
        map[x][y][floorIndex_number] = value;
        calculate();
    }

    private void calculate() {
        for (int i = calculateStartingPoint_X; i < grow; i++) {
            for (int j = calculateStartingPoint_Y; j < width; j++) {
                if (map[i][j][floorIndex_number] != UNOPENED_GRID) {
                    calculateProbability(i, j, map[i][j][floorIndex_number]);
                }
            }
        }
    }

    private void calculateProbability(int x, int y, int value) {
        fillProbability(x, y, (double) value / checkTheSurroundingGrid(x, y) * 10);
    }

    private void fillProbability(int x, int y, double value) {

        // 向x，y周围的格子增加概率
        for (minApp.coordinate coordinate : getNeighbors(x, y)) {
            if (value == 0) {
                map[coordinate.x][coordinate.y][floorIndex_probability] = 0;
            } else if (map[coordinate.x][coordinate.y][floorIndex_number] == UNOPENED_GRID) {
                map[coordinate.x][coordinate.y][floorIndex_probability] += (int) value;
            } else {
                map[coordinate.x][coordinate.y][floorIndex_probability] = 0;
            }
        }
    }

    private List<coordinate> getNeighbors(int x, int y) {
        List<coordinate> neighbors = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                var x1 = x + i;
                var y1 = y + j;
                if (i == 0 && j == 0) {
                    continue; // 跳过当前位置
                } else if (x1 < 0 || x1 >= grow || y1 < 0 || y1 >= width) {
                    continue;
                }
                neighbors.add(new coordinate(x1, y1));
            }
        }
        return neighbors;
    }

    private int checkTheSurroundingGrid(int x, int y) {
        int unOpenNum = 0;
        for (minApp.coordinate coordinate : getNeighbors(x, y)) {
            if (map[coordinate.x][coordinate.y][floorIndex_number] == UNOPENED_GRID) {
                unOpenNum++;
            }
        }
        return unOpenNum;
    }

    public void seeMap() {
        for (int k = 0; k < thicknes - 1; k++) {
            String str="-";
            System.out.println(String.format(str,"%"+(grow/2)+"s").replace(" ",str) + (k==floorIndex_number?"格子数字":"格子概率") + String.format(str,"%"+(grow/2)+"s").replace(" ",str) );
            for (int i = 0; i < grow; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(String.format("%3d", map[i][j][k]) + " ");
                }
                System.out.println();
            }
            System.out.println(String.format(str,"%"+grow+"s").replace(" ",str) );
        }
    }
}

class coordinate {
    int x;
    int y;

    coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
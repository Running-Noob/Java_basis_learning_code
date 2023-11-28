package com.f.horsechess;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author fzy
 * @date 2023/8/18 20:29
 * 马踏棋盘(DFS+回溯)
 */
public class HorseChessBoard {
    private static int y = 6;   //棋盘行数
    private static int x = 6;   //棋盘列数
    private static int[][] chessBoard = new int[y][x];   //棋盘，棋盘上的数字表示马走的顺序
    private static boolean[][] visited = new boolean[y][x];  //记录某个位置是否走过
    private static boolean finished = false;    //记录马是否遍历完棋盘

    public static void main(String[] args) {
        int startRow = 1;
        int startCol = 4;
        traversalChessBoard(startRow, startCol, 1);
        showBoard();
    }

    //编写方法，获取当前位置可以走的下一步的所有位置(用Point表示位置x、y)
    public static ArrayList<Point> nextPoints(Point curPoint) {
        ArrayList<Point> points = new ArrayList<>();
        //判断是否可以走5位置(参考韩顺平Java课程的位置布置)
        if (curPoint.x - 2 >= 0 && curPoint.y - 1 >= 0) {
            points.add(new Point(curPoint.x - 2, curPoint.y - 1));
        }
        //判断是否可以走6位置
        if (curPoint.x - 1 >= 0 && curPoint.y - 2 >= 0) {
            points.add(new Point(curPoint.x - 1, curPoint.y - 2));
        }
        //判断是否可以走7位置
        if (curPoint.x + 1 < x && curPoint.y - 2 >= 0) {
            points.add(new Point(curPoint.x + 1, curPoint.y - 2));
        }
        //判断是否可以走0位置
        if (curPoint.x + 2 < x && curPoint.y - 1 >= 0) {
            points.add(new Point(curPoint.x + 2, curPoint.y - 1));
        }
        //判断是否可以走1位置
        if (curPoint.x + 2 < x && curPoint.y + 1 < y) {
            points.add(new Point(curPoint.x + 2, curPoint.y + 1));
        }
        //判断是否可以走2位置
        if (curPoint.x + 1 < x && curPoint.y + 2 < y) {
            points.add(new Point(curPoint.x + 1, curPoint.y + 2));
        }
        //判断是否可以走3位置
        if (curPoint.x - 1 >= 0 && curPoint.y + 2 < y) {
            points.add(new Point(curPoint.x - 1, curPoint.y + 2));
        }
        //判断是否可以走4位置
        if (curPoint.x - 2 >= 0 && curPoint.y + 1 < y) {
            points.add(new Point(curPoint.x - 2, curPoint.y + 1));
        }
        return points;
    }

    /**
     * 核心算法，遍历棋盘，如果遍历成功，就把 finished 设置为 true，并将马走的每一步记录到棋盘上
     *
     * @param curRow 当前位置的行数
     * @param curCol 当前位置的列数
     * @param step   当前是第几步
     */
    public static void traversalChessBoard(int curRow, int curCol, int step) {
        //先把当前走的位置记录下来
        chessBoard[curRow][curCol] = step;
        visited[curRow][curCol] = true;
        //得到当前位置可以走的下一个位置
        ArrayList<Point> nextPoints = nextPoints(new Point(curCol, curRow));
        while (!nextPoints.isEmpty()) {
            Point point = nextPoints.remove(0);
            if (!visited[point.y][point.x]) {
                traversalChessBoard(point.y, point.x, step + 1);
            }
        }
        //当退出while时，看看是否遍历成功，如果没有成功，就重置相应的值，然后进行回溯
        if (step < x * y && !finished) {
            chessBoard[curRow][curCol] = 0;
            visited[curRow][curCol] = false;
        } else {
            finished = true;
        }
    }

    public static void showBoard() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(chessBoard[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void showVisited() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(visited[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

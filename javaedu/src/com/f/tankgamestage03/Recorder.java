package com.f.tankgamestage03;

import java.io.*;
import java.util.Vector;

/**
 * @author fzy
 * @date 2023/7/13 20:49
 * �������ڼ�¼̹�˴�ս��Ϸ�������Ϣ�����ļ�����
 */
public class Recorder {
    private static int destoryEnemyNum = 0;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFilePath = "C:\\Users\\1\\Code Project\\Java project\\file\\tankgameRecord.txt";
    private static Vector<Enemy> enemies = new Vector<>();
    private static Vector<Node> nodes = new Vector<>();

    public static int getDestoryEnemyNum() {
        return destoryEnemyNum;
    }

    public static void setDestoryEnemyNum(int destoryEnemyNum) {
        Recorder.destoryEnemyNum = destoryEnemyNum;
    }

    public static void addDestoryEnemyNum() {
        destoryEnemyNum++;
    }

    public static void setEnemies(Vector<Enemy> enemies) {
        Recorder.enemies = enemies;
    }

    public static Vector<Node> loadRecord() throws IOException {
        String line = null;
        br = new BufferedReader(new FileReader(recordFilePath));
        destoryEnemyNum = Integer.parseInt(br.readLine());
        while ((line = br.readLine()) != null) {
            String[] info = line.split(" ");
            Node node = new Node(Integer.parseInt(info[0]),
                    Integer.parseInt(info[1]),
                    TankDirect.valueOf(info[2]));
            nodes.add(node);
        }
        if (br != null) {
            br.close();
        }
        return nodes;
    }

    //��д����������Ϸ�˳�ʱ����destoryEnemyNum��ʣ�����̹�˵���Ϣ���浽recordFilePath·�����ļ���
    public static void keepRecord() throws IOException {
        bw = new BufferedWriter(new FileWriter(recordFilePath));
        bw.write(destoryEnemyNum + "");
        bw.newLine();
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (enemy.isAlive()) {
                String record = enemy.getX() + " " + enemy.getY() + " " + enemy.getDirect();   //��¼����̹����Ϣ
                bw.write(record);
                bw.newLine();
            }
        }
        if (bw != null) {
            bw.close();
        }
    }
}

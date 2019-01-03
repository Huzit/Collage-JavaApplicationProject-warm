package Warm;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Manual extends JPanel {

	public void direction (int xDirection, int yDirection, Graphics g) {
		if(xDirection == 0 && yDirection == 0 ) {
			g.drawString("Game Start", 160, 250);
			g.drawString("[press any key]",145, 270);
			}
		}

	public void gameOver(boolean gameover, Graphics g) {
		if(gameover) {
			g.setColor(Color.RED);
			g.drawString("Game Over", 170, 180);
//			g.drawString("다시 하려면 ENTER을 눌러주세요", 110, 200);
		}
	}
	
	public void manual(int MAX_SCORE, int score, int level, Graphics g) {
		g.setColor(Color.WHITE);
		for(int i=0; i<600; i++) {
			g.drawString("-",i,0);
			g.drawString("-",i,556);
		}
		for(int i=381; i<600; i++) {
			g.drawString("-",i,0);
			g.drawString("-",i,270);
		}
		for(int i=0; i<556; i++) {
			g.drawString("|",0,i);
			g.drawString("|",380,i);
			g.drawString("|",600,i);
		}
		g.drawString("↑  ↓  ←  →", 480, 310);
		g.drawString("1. 회색 안개에 닿일 때", 420, 370);
		g.drawString("2. 장외일 때", 420, 390);
		g.drawString("점수 : " + score, 420, 200);
		g.drawString("Level : " + level, 500, 200);

		g.setColor(Color.RED);
		g.drawString("[ 빨간색 : Player ]", 440, 100);
		g.drawString("레벨 증가시 안개 크기 1.2배 증가", 395, 500);
		g.drawString("레벨 증가시 웜의 속도 1.25배 증가", 395, 520);
		g.drawString("매 순간 먹이와 적의 위치 변경", 395, 540);
		g.drawString("최고 점수 : " + MAX_SCORE, 450, 250);

		Color c = new Color(0x9966CCFF);
		g.setColor(c);
		g.drawString("[ 하늘색 : 안개 ]", 445, 120);

		g.setColor(Color.YELLOW);
		g.drawString("[ 노란색 : 먹이 ]", 445, 140);
		g.drawString("- 먹이 5개 습득 -", 420, 440);

		g.setColor(Color.YELLOW);
		g.drawString("[ 조작법 ]", 420, 310);
		g.drawString("[ Game Over 조건 ]", 420, 350);
		g.drawString("[ 레벨 업 조건 ]", 420, 420);
	}
}


package Warm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Warm {
	JFrame frame;
	int WIDTH = 400;
	int HEIGHT =600;
	int radius = 5;
	int x, y = 70;;
	String gameName = "Warm Game";

	int speed = 100;
	int xDirection=0, yDirection = 0;

	int headX, headY, size = 10;

	//Making warm List
	ArrayList<Player> warm = new ArrayList<Player>();

	int foodX1, foodY1;
	int foodX2, foodY2;
	int foodX3, foodY3;
	int foodX4, foodY4;
	int foodX5, foodY5;
	int mistX, mistY;
	int mist1X, mist1Y;
	int mist2X, mist2Y;
	int score, MAX_SCORE, middle = 0;
	int level = 1;
	boolean gameover;

	public Warm() {
		init();
	}

	public void start() {	
		while (gameover == false) {
			//이동좌표
			headX += xDirection;
			headY += yDirection;
			
			//장외로 나갈시, Game Over
			//gameover를 true로 변경
			//현재의 점수가 최고 점수보다 높으면 기록 교체
			if (((headX < 0) || (headX > (WIDTH-35)/10)) || ((headY < 0) || (headY > (HEIGHT-70)/10))) {
				gameover = true;
				if(score > MAX_SCORE) 
					MAX_SCORE = score;
			}

			Player temp = warm.get(warm.size() - 1);

			for (int i = warm.size() - 1; i > 0; i--) {
				warm.set(i, warm.get(i-1));
			}

			//먹이를 먹을시 점수 증가
			//점수가 5점 모일시 레벨업
			//안개의 크기 1.5배 증가
			if ((headX == foodX1) && (headY == foodY1)) {
				score+=2;
				if(score%5 == 0) {
					setUpLevel();
				}
				warm.add(temp);
				newFood1();
				if(score%10 == 0) {
					size /= 2;
					speed = speed/5*4;
				}
				else
					size *= 1.2;
				makemist();
			}
			
			if ((headX == foodX2) && (headY == foodY2)) {
				score+=2;
				if(score%5 == 0) {
					setUpLevel();
				}
				warm.add(temp);
				newFood2();
				if(score%10 == 0) {
					size /= 2;
					speed = speed/5*4;
				}
				else
					size *= 1.2;
				makemist();
			}
			
			if ((headX == foodX3) && (headY == foodY3)) {
				score+=2;
				if(score%5 == 0) {
					setUpLevel();
				}
				warm.add(temp);
				newFood3();
				if(score%10 == 0) {
					size /= 2;
					speed = speed/5*4;
				}
				else
					size *= 1.2;
				makemist();
			}
			
			if ((headX == foodX4) && (headY == foodY4)) {
				score+=2;
				if(score%5 == 0) {
					setUpLevel();
				}
				warm.add(temp);
				newFood4();
				if(score%10 == 0) {
					size /= 2;
					speed = speed/5*4;
				}
				else
					size *= 1.2;
				makemist();
			}
			
			if ((headX == foodX5) && (headY == foodY5)) {
				score+=2;
				if(score%5 == 0) {
					setUpLevel();
				}
				warm.add(temp);
				newFood5();
				if(score%10 == 0) {
					size /= 2;
					speed = speed/5*4;
				}
				else
					size *= 1.2;
				makemist();
			}
			//안개에 닿을시 gameover를 true로 변경
			//최고점 갱신
			if ((headX == mistX) && (headY == mistY)) {
				gameover = true;
			}
			if ((headX == mist1X) && (headY == mist1Y) && score>=10) {
				gameover = true;
			}
			if ((headX == mist2X) && (headY == mist2Y) && score>=20) {
				gameover = true;
			}

			warm.set(0, new Player(headX, headY));
			frame.repaint();		//매 순간 재구성

			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
public void makemist() {
	newmist();
	newmist1();
	newmist2();
}
public void paintmist(Graphics g) {
	Color c = new Color(0x9966CCFF);
	g.setColor(c);
	g.fillOval(mistX * 10, mistY * 10, size, size);
	
	if(score>=10) 
		g.fillOval(mist1X * 10, mist1Y * 10, size, size);
	if(score>=20) {
		g.fillOval(mist1X * 10, mist1Y * 10, size, size);
		g.fillOval(mist2X * 10, mist2Y*10, size, size);
	}
	
}

	//패널 생성
	class MyPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//배경
			setBackground(Color.BLACK);	

			//지렁이
			for (Player madi : warm) {
				g.setColor(Color.RED);
				g.fillOval(madi.getX() * 10, madi.getY() * 10, 10, 10);
			}//지렁이 테두리
			for (Player madi : warm) {
				g.setColor(Color.WHITE);
				g.drawOval(madi.getX() * 10, madi.getY() * 10, 10, 10);
			}
			//랜덤한 위치에 생성되는 먹이
			g.setColor(Color.YELLOW);
			g.fillOval(foodX1 * 10, foodY1 * 10, 10, 10);
			
			g.setColor(Color.YELLOW);
			g.fillOval(foodX2 * 10, foodY2 * 10, 10, 10);
			
			g.setColor(Color.YELLOW);
			g.fillOval(foodX3 * 10, foodY3 * 10, 10, 10);

			g.setColor(Color.YELLOW);
			g.fillOval(foodX4 * 10, foodY4 * 10, 10, 10);
			
			g.setColor(Color.YELLOW);
			g.fillOval(foodX5 * 10, foodY5 * 10, 10, 10);
			//안개생성
			paintmist(g);

			Manual manual = new Manual();
			manual.direction(xDirection, yDirection, g);
			manual.manual(MAX_SCORE, score, level, g);
			manual.gameOver(gameover, g);
			}
}

	//프레임 생성
	public void init() {
		frame = new JFrame(gameName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(new MyListener());
		frame.getContentPane().add(new MyPanel());

		frame.setSize(WIDTH + 200, HEIGHT);
		frame.setVisible(true);

		makeWarm();
		newFood1();
		newFood2();
		newFood3();
		newFood4();
		newFood5();
		newmist();
		newmist1();
		newmist2();
	}
	
	public class MyListener implements KeyListener{
		@Override
		public void keyPressed(KeyEvent key) {
			switch (key.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				xDirection = -1;
				yDirection = 0;
				break;
			case KeyEvent.VK_RIGHT:
				xDirection = 1;
				yDirection = 0;
				break;
			case KeyEvent.VK_UP:
				xDirection = 0;
				yDirection = -1;
				break;
			case KeyEvent.VK_DOWN:
				xDirection = 0;
				yDirection = 1;
				break;
			case KeyEvent.VK_ENTER:
//				init();
//				BackUp();
//				start();
				break;
			}
		}
		@Override
		public void keyReleased(KeyEvent arg0) {}
		@Override
		public void keyTyped(KeyEvent arg0) {}
	}
	//크기 3짜리 웜 생성
	public void makeWarm() {
		for (int i = 0; i < 3; i++) {
			warm.add(new Player(headX - i, headY));
		}
	}

	//임의의 자리에 먹이 생성
	public void newFood1() {
		foodX1 = (int) (Math.random() * WIDTH/16);
		foodY1 = (int) (Math.random() * HEIGHT/16);		
	}
	public void newFood2() {
		foodX2 = (int) (Math.random() * WIDTH/16);
		foodY2 = (int) (Math.random() * HEIGHT/16);		
	}
	public void newFood3() { 
		foodX3 = (int) (Math.random() * WIDTH/18);
		foodY3 = (int) (Math.random() * HEIGHT/18);		
	}
	public void newFood4() {
		foodX4 = (int) (Math.random() * WIDTH/18);
		foodY4 = (int) (Math.random() * HEIGHT/18);		
	}
	public void newFood5() {
		foodX5 = (int) (Math.random() * WIDTH/20);
		foodY5 = (int) (Math.random() * HEIGHT/20);		
	}

	//안개 좌표 생성
	public void newmist() {
		mistX = (int) (Math.random() * WIDTH/15);
		mistY = (int) (Math.random() * HEIGHT/15);	
	}
	public void newmist1() {
		mist1X = (int) (Math.random() * WIDTH/15);
		mist1Y = (int) (Math.random() * HEIGHT/15);	
	}
	public void newmist2() {
		mist2X = (int) (Math.random() * WIDTH/15);
		mist2Y = (int) (Math.random() * HEIGHT/15);	
	}

	//Game Over시 최고 점수를 제외하고
	//현재 점수 레벨 안개 크기를 초기화 한다.
	public void BackUp() {
		score = 0;
		gameover = false;
		level = 1;
		size = 10;
		makeWarm();
		newFood1();
		newFood2();
		newFood3();
		newmist();
	}

	//레벨 업
	//레벨 업 시, 속도를 1.25배 증가 시킨다.
	public void setUpLevel() {
		level++;
		speed = speed/5*4;
	}
}


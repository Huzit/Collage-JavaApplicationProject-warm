package Warm;

public class Player {
	private int x;
	private int y;
	private int size;
	
	public Player(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

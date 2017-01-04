package com.yahier.androidtest.download;

public class Size {
	float current;
	int all;

	public Size(int current, int all) {
		this.current = current;
		this.all = all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public int getAll() {
		return all;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public float getCurrent() {
		return current;
	}

}

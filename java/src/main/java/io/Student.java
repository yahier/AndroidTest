package io;

import java.io.Serializable;

class Student implements Serializable {
	String name = null;
	double height;

	Student(String name, double height) {
		this.name = name;
		this.height = height;
	}

	public void setHeight(double c) {
		this.height = c;
	}
}

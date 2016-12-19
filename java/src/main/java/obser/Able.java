package obser;

import java.util.Observable;
import java.util.Observer;

public class Able extends Observable {
	
	public static void main(String[] args) {
		System.out.println("main");
		MyObserver ver = new MyObserver();
		Able able = new Able();
		able.addObserver(ver);
		
		able.setChanged();
	    able.notifyObservers();
	   
		System.out.println("count is "+able.countObservers());

	}

}

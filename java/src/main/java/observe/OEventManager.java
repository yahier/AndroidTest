package observe;

import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/** 测试Observable和Observer */
public class OEventManager extends Observable {
	static public void main(String[] args) {
		OEventManager mgr = new OEventManager();
		mgr.addObserver(new OListener());
		//mgr.addObserver(new OListener());
		//mgr.addObserver(new OListener());
		
        //mgr.fireChange("Changed. ");
        
        mgr.setChanged();
        mgr.notifyObservers("yahier");
		
	}

/*	public void fireChange(String msg) {
		setChanged();
		notifyObservers(new OEvent(msg));
	}*/
}

class OListener implements Observer {
	public void update(Observable o, Object arg) {
		System.err.println(arg);
	}
}

/*class OEvent extends EventObject {
	public OEvent(String msg) {
		super(msg);
	}
}*/

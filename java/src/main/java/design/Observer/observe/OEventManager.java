package design.Observer.observe;

import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/**
 * 测试Observable和Observer
 */
public class OEventManager extends Observable {
    static public void main(String[] args) {
        OEventManager mgr = new OEventManager();
        mgr.addObserver(new OListener());
        mgr.fireChange("Changed. ");

    }

    public void fireChange(String msg) {
        setChanged();
        notifyObservers(msg);
    }
}

class OListener implements Observer {

    public void update(Observable o, Object arg) {
        System.err.println("OListener update:" + arg);
    }
}



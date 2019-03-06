package pattern.Observer.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * 测试Observable和Observer
 * 框架中自带的功能 也就这样简单
 */
public class OEventManager extends Observable {
    static public void main(String[] args) {
        OEventManager mgr = new OEventManager();
        mgr.addObserver(new OListener());
        mgr.notify("Changed. ");

    }

    private void notify(String msg) {
        setChanged();//修改源代码中的changed字段，控制一个事件不会被监听者多次接收
        notifyObservers(msg);
    }
}

class OListener implements Observer {

    public void update(Observable o, Object arg) {
        System.err.println("OListener update:" + arg);
    }
}



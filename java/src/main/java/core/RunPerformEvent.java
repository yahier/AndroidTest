package core;

import java.util.EventObject;

public class RunPerformEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    
    private Object objsource;
    private Object message;
    
    public RunPerformEvent(Object source,Object message) {
        super(source);
        this.objsource = source;
        this.message = message;
    }
    
    public Object getObjsource() {
        return objsource;
    }

    public void setObjsource(Object objsource) {
        this.objsource = objsource;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
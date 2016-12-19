package core;

import java.util.EventObject;

public class RunPerformEvent extends EventObject {

    /**
     * –Ú¡–ªØ∞Ê±æ∫≈
     */
    private static final long serialVersionUID = 1L;
    
    private Object objsource;
    private Object message;
    
    public RunPerformEvent(Object source,Object message) {
        super(source);
        // TODO Auto-generated constructor stub
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
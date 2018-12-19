package pattern.clone;

/**
 * Created by yahier on 12/19/18.
 */

public class PointBean implements Cloneable {
    private String pointName;

    public PointBean(String pointName) {
        this.pointName = pointName;
    }

    public Object clone() {
        PointBean point = this;
        point.setPointName(getPointName());
        return point;
    }


    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }
}

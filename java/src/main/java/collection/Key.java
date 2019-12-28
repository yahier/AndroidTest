package collection;

public class Key {
    private String params1;
    private String params2;

    public Key(String params1, String params2) {
        this.params1 = params1;
        this.params2 = params2;
    }

    @Override
    public int hashCode() {
        return params1.hashCode() + params2.hashCode();
    }

    @Override
    public boolean equals(Object o) {
//        if (!(o instanceof Key)) {
//            return false;
//        }
//
//        Key key = (Key) o;
//        if (key.getParams1().equals(params1) && key.getParams2().equals(params2)) {
//            return true;
//        }
        return false;
    }

    public String getParams1() {
        return params1;
    }

    public void setParams1(String params1) {
        this.params1 = params1;
    }

    public String getParams2() {
        return params2;
    }

    public void setParams2(String params2) {
        this.params2 = params2;
    }
}

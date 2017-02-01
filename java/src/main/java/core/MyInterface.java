package core;

/**
 *
 */

public class MyInterface {
    onGrowListener mOnGrowListener;

    public static void main(String[] args) {
        MyInterface inter = new MyInterface();

        inter.setOnClickListener(new onGrowListener() {

            @Override
            public void go(MyInterface face) {
                System.out.println("main onClick");
            }
        });

    }

    public void setOnClickListener(onGrowListener listener) {
        mOnGrowListener = listener;
    }

    public interface onGrowListener {
        void go(MyInterface face);
    }

}

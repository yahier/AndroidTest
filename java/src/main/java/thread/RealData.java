package thread;

import java.util.concurrent.Callable;

/**
 * Created by yahier on 17/3/6.
 */

public class RealData implements Callable<String> {

    private String para;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
        }

        return sb.toString();
    }
}



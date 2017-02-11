package pattern;

/**
 * Created by yahier on 17/2/11.
 * 建造者模式
 */

public class BuiddingTest {
    int age;
    String name;
    String phone;

    /**
     * 这里算是一个小小的关键点
     *
     * @param build
     */
    private BuiddingTest(Build build) {
        this.age = build.age;
        this.name = build.name;
        this.phone = build.phone;
    }

    public final static void main(String[] args) {
        BuiddingTest test1 = new BuiddingTest.Build("yahier").phone("18520137573").age(27).build();
        System.out.println("phone:" + test1.phone);
    }

    public static class Build {
        int age;
        String name;
        String phone;

        public Build(String name) {
            this.name = name;
        }

        private Build age(int var) {
            this.age = var;
            return this;
        }

        private Build phone(String var) {
            this.phone = var;
            return this;
        }

        /**
         * 这里也是一个关键点
         * @return
         */
        public BuiddingTest build() {
           return new BuiddingTest(this);
        }

    }

}

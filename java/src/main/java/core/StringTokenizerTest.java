package core;

import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {

        //对第二个参数的意义解答，当前参数表示将第一个字符串，按照" "或者"m"进行拆分
        StringTokenizer tokenizer = new StringTokenizer("public static void,main", " m");
        //todo 这个方法返回的 到底是个啥意思
        int count = tokenizer.countTokens();//返回nextToken方法被调用的次数。
        System.out.println("count is " + count);


        while (tokenizer.hasMoreTokens()){
            System.out.println("next:"+tokenizer.nextToken());
        }
    }
}

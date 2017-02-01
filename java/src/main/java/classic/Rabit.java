package classic;

public class Rabit {
    int sum = 0;
    int add = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Rabit().grow(7));
    }

    public int grow(int a) {
        if (a == 1 || a == 2) return 1;
        else sum = grow(a - 1) + grow(a - 2);
        return sum;

    }

}

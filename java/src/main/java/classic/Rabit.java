package classic;

public class Rabit {
 int sum=0;
 int add=0;
	/**
	 * Mar.21,2011  by yahier
	 * 关于 1 1 2 3 5 8 13 21的问题
	 * 觉得这次写的很简洁  哈哈
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(new Rabit().grow(7));
		}
	
	public int grow(int a){
		if(a==1||a==2) return 1;
		else  sum=grow(a-1)+grow(a-2);return sum;
		
	}

}

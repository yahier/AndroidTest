package classic;

public class Flower {

	/**怎么叫做水仙花数呢
	 * 关键是程序如何得到这个三位数的各位的数
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		for(int i=100;i<1000;i++){
			int g=i%10;    //得到个位上的数
			int s=(i%100-g)/10;   //得到后两位的数 减去个位 除以10 得到十位
			int b=(i-g-s*10)/100;   //得到百位
			
			if(i==b*b*b+s*s*s+g*g*g) 
			System.out.println(i);
			
			
			
			
		}
		
		
	}

}

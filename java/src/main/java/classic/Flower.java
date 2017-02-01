package classic;

public class Flower {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		for(int i=100;i<1000;i++){
			int g=i%10;
			int s=(i%100-g)/10;
			int b=(i-g-s*10)/100;
			
			if(i==b*b*b+s*s*s+g*g*g) 
			System.out.println(i);
			
			
			
			
		}
		
		
	}

}

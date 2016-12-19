package classic;

public class Sushu {

	/*Mar.21,2011
	 * *这个题目是要求输出100到200之间所有的素数
	 * 思路就是将本数除以从0开始 到本身的数，所有的都没有除断的话 就是素数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		new Sushu().pick();
	}

	
	private void pick(){
		for(int i=100;i<200;i++){
		  for(int j=1;j<15;j++)
             
			  
			 if(i%j!=0)System.out.print(i);
		  
		  
		}
		
		
	}
	
	
	
	
	
}

package classic;

public class Sushu {

	/*Mar.21,2011
	 * *�����Ŀ��Ҫ�����100��200֮�����е�����
	 * ˼·���ǽ��������Դ�0��ʼ ��������������еĶ�û�г��ϵĻ� ��������
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

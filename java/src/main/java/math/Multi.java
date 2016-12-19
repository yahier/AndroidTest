package math;

public class Multi {
	static int a = 99;//

	public static void main(String[] args) {
		//supertable(a);
		dou();
		
	}

	//�����˷���   ��� a*a
	static void supertable(int a) {
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + " = " + j * i+"   ");
			}
			System.out.println();
		}
	}
	
	static void dou(){
		for(int i=11;i<=50;i++){
			System.out.print(i + "*" + i + " = " + i * i+"   ");
			if(i%10==0){
				System.out.println();
			}
		}
	}
}

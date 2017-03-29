package confused;



public class Pitch {
	static int ts = 0;
	 int fs = 1;//
	static int hs = 5;//
	static int tsscope = 5000;//

	public static void main(String[] args) {
		new Pitch().fT(0);
	}

	public  int fT(int t) {
		if (t == tsscope) {
			System.out.println("==");
			return 0;
		} else {
			if ((t - 1) % hs == 0 && fs <= hs) {
				if (fs == hs) {
					System.out.println("222 " + ts + " 333");
				}
				fs += 1;
				return fT((t - 1) / 5 * 4);
			} else {
				fs = 1;
				return fT(ts += 1);
			}
		}
	}

}

package confused;


//猴子分桃问题 是  有一堆桃子  分别来了五个猴子  
//每次都是分得五堆多一个 扔掉一个后 拿走其中一堆  求开始最少有多少桃子
public class Pitch {
	static int ts = 0;// 桃子总数
	 int fs = 1;// 记录分的次数
	static int hs = 5;// 猴子数...
	static int tsscope = 5000;// 桃子数的取值范围.太大容易溢出.

	public static void main(String[] args) {
		new Pitch().fT(0);
	}

	public  int fT(int t) {
		if (t == tsscope) {
			// 当桃子数到了最大的取值范围时取消递归
			System.out.println("结束");
			return 0;
		} else {
			if ((t - 1) % hs == 0 && fs <= hs) {
				if (fs == hs) {
					System.out.println("桃子数 = " + ts + " 时满足分桃条件");
				}
				fs += 1;
				return fT((t - 1) / 5 * 4);// 返回猴子拿走一份后的剩下的总数
			} else {
				// 没满足条件
				fs = 1;// 分的次数重置为1
				return fT(ts += 1);// 桃子数加+1
			}
		}
	}

}

package string;

import java.util.Arrays;
import java.util.Random;

public class GetRandom {
	public static void main(String[] args) {
		GetRandom g = new GetRandom();
		g.get5RandomIndex(10);
		
		
	}

	/**
	 * 在limitation内 得到5个随机不重复
	 */
	void get5RandomIndex(int lengthOfArray) {
		if (lengthOfArray < 5)
			return;
		StringBuffer sb = new StringBuffer();
		int[] a = new int[lengthOfArray];
		for (int i = 0; i < lengthOfArray; i++) {
			a[i] = i;
			if (i < lengthOfArray - 1)
				sb.append(i + "#");
			else {
				sb.append(i);
				break;
			}
		}
		// 上面已经组成了0#1#2#...#(lengthOfArray-1)

		// 下面删掉其中一些 留下5个数
		String s = sb.toString();
		Random random = new Random();
		for (int i = 0; i < lengthOfArray - 5; i++) {
			int in = Math.abs(random.nextInt()) % (lengthOfArray-i);
			System.out.println("删掉的下标是   "+in);
			a=deleteGet(a,in);
			
		}
		
		System.out.println(Arrays.toString(a));
	}

	// 删除这个index在indexs字段中
	String deleteIndex(String str, int value) {
		StringBuffer sb = new StringBuffer();
		try {
			String[] strs = str.split("#");
			boolean startExchange = false;
			for (int i = 0; i < strs.length; i++) {
				if (value == Integer.parseInt(strs[i])) {
					startExchange = true;
				}

				if (startExchange) {
					if (i + 1 < strs.length)
						strs[i] = strs[i + 1];
				}
			}
			for (int i = 0; i < strs.length - 1; i++) {

				if (i != (strs.length - 2))
					sb.append(strs[i] + "#");
				else
					sb.append(strs[i]);
			}
		} catch (Exception e) {
			return "0#1";
		}
		// System.out.println("after   "+sb.toString());
		return sb.toString();

	}

	int[] deleteGet(int[] a, int index) {
		int[] b = new int[a.length - 1];// 构建返回的数组
		for (int i = 0; i < a.length-1; i++) {
			if (i >= index) {
				b[i] = a[i+1];
			} else
				b[i] = a[i];
		}
		return b;
	}
}

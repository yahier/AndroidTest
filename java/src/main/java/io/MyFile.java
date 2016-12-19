package io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

/**����File��ļ�ֵ 
 * date:2012.10.8*/
public class MyFile {
	public static void main(String[] args) {
		MyFile main = new MyFile();
		main.test1("D://yahier/3.txt");
	}

	void test1(String path) {
		File file = new File(path);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File newFile = new File("D://ya/ya2.txt");
		System.out.println("   " + file.renameTo(newFile));
	//	listRoot(newFile);
		testFilter(newFile);

	}

	void listRoot(File file) {
		File[] files = file.listRoots();
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getAbsolutePath());
			String[] names = files[i].list();
			System.out.println(names.length);
			for (int j = 0; j < names.length; j++) {
				System.out.println(names[j]);
			}

			if (i == 0)
				break;
		}
	}

	//û���ҵ�FilenameFilter�ļ�ֵ
	void testFilter(File file) {
		file.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String filename) {
				// TODO Auto-generated method stub
				System.out.println(123);
				return false;
			}
		});
	}
}

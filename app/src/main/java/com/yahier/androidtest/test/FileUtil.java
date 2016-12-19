package com.yahier.androidtest.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;



import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.yahier.androidtest.R;

public class FileUtil {
	public static String part_xls = Environment.getExternalStorageDirectory()
			.getPath()  + "/part.xls";
	public static String common_problems = Environment.getExternalStorageDirectory()
			.getPath()  + "/commom_problems.xls";

	/**
	 * 复制万年历xls文件到sd中
	 * @param context
	 */
	public static void copyToSdcard(Context context,String filePath) {
		System.out.println("开始复制 表格文件");
		File file = new File(filePath);
		if (file.exists()) {
			System.out.println("已经存贮  不用再复制");
			return;
		}

		InputStream inputstream = context.getResources().openRawResource(R.raw.common_problems);
		byte[] buffer = new byte[1024];
		int count = 0;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(common_problems));
			while ((count = inputstream.read(buffer)) > 0) {
				fos.write(buffer, 0, count);
			}
			System.out.println("FileUtil     表格数据 复制完成");
			fos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("FileUtil     请检查你的存储卡");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

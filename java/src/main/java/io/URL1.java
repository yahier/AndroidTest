package io;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URL1 {
	void Tbaidu() {
		try {
			URL url = new URL("http://www.baidu.com/");
			URLConnection con = url.openConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

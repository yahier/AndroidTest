package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;

public class routeIp {

	private static String getWanPacket() throws IOException {
		URL url = new URL(
				"http://192.168.1.1:80/userRpm/StatusRpm.htm?Connect=yahier0010&wan=iwish.2008");
		InputStream ins = null;
		try {
			ins = url.openConnection().getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					ins));
			String str;
			StringBuffer wanPacket = new StringBuffer();
			while ((str = reader.readLine()) != null) {
				wanPacket.append(str);
			}
			return wanPacket.toString();
		} finally {
			if (ins != null) {
				ins.close();
			}
		}
	}

	public static void main(String[] args) {

		try {
			System.out.println(1);
			System.out.println(getWanPacket());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}

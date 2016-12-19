package core;

import java.util.ResourceBundle;

public class PropertyTest {
	public static void main(String[] args) {
		
		ResourceBundle res= ResourceBundle.getBundle("message");
		System.out.println(res.getString("cc.yahier.welcome"));
		System.out.println(res.getString("cc.yahier.name"));
		System.out.println(2);
	}

}

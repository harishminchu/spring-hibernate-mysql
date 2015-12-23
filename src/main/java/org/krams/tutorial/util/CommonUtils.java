package org.krams.tutorial.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class CommonUtils {

	public void sendSms(String to, String message) {
		try {
			String email = "n.hari1988@gmail.com";
			String user = "harishminchu";
			String pass = "Minchu_22";
			String number = to;
			String msg = message;
			String mURL = "http://www.onl9class.com/smsapi/smsir.php?email="
					+ email + "&user=" + user + "&pass=" + pass + "&number="
					+ number + "&msg=" + URLEncoder.encode(msg, "UTF-8");
			;
			URL url = new URL(mURL);
			BufferedReader reader = null;
			reader = new BufferedReader(new InputStreamReader(url.openStream(),
					"UTF-8"));
			for (String line; (line = reader.readLine()) != null;) {
				System.out.println("Delivery Msg" + line);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

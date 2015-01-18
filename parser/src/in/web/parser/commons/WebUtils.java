package in.web.parser.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebUtils {

	public static String downloadPage(String url) {
		URL link;
		InputStream is = null;
		BufferedReader br;
		String line;

		StringBuffer content = new StringBuffer("");

		try {
			link = new URL(url);
			is = link.openStream();
			br = new BufferedReader(new InputStreamReader(is));

			while ((line = br.readLine()) != null) {
				content.append(line);
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException ioe) {

			}
		}

		return content.toString();
	}
}

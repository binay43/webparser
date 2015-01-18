package in.web.parser.commons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class WebConnect {
	static URL url;
	
	public static void connectWebUrl() throws IOException {
		Properties prop = new Properties();
		InputStream inputConfig = new FileInputStream("WebContent\\WEB-INF\\properties\\web.properties") ;	
		
		prop.load(inputConfig);
		url = new URL(prop.getProperty("msnUrl"));
		
		URLConnection conn = url.openConnection();
		// open the stream and put it into BufferedReader

		//save to this filename
		String fileName = "src\\resources\\test.html";
		storeFile(fileName,conn);
		
	}
	
	private static void storeFile(String fileName, URLConnection conn) throws IOException {
		BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));

		String inputLine;
		File file = new File(fileName);

		if (!file.exists()) {
			file.createNewFile();
		}

		//FileWriter to write file
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);

		while ((inputLine = br.readLine()) != null) {
			bw.write(inputLine);
		}

		bw.close();
		br.close();

		System.out.println("Done");
		
	}

}

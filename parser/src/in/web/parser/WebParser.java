package in.web.parser;

import in.web.parser.commons.WebConnect;
import in.web.parser.scraper.Scraping01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;


public class WebParser {
	public static void main(String[] args) throws IOException {
		
		WebConnect.connectWebUrl();
		
		//this is my comment
		Scraping01 scraping01 = new Scraping01();
		scraping01.run();
	}
}

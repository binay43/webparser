package in.web.parser.commons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
	final static Charset ENCODING = StandardCharsets.UTF_8;

	public static List<String> readSmallTextFileUTF8(String aFileName) throws IOException {
		Path path = Paths.get(aFileName);
		return Files.readAllLines(path, ENCODING);
	}

	public static void writeSmallTextFileUTF8(List<String> aLines, String aFileName)
			throws IOException {
		Path path = Paths.get(aFileName);
		Files.write(path, aLines, ENCODING);
	}

	public static String readLargeTextFileUTF8(String aFileName) throws IOException {
		StringBuffer buffer = new StringBuffer();
		Path path = Paths.get(aFileName);
		try (Scanner scanner = new Scanner(path, ENCODING.name())) {
			while (scanner.hasNextLine()) {
				buffer.append(scanner.nextLine());
			}
		}
		return buffer.toString();
	}

	public static String readLargeTextFileAlternateUTF8(String aFileName) throws IOException {
		StringBuffer buffer = new StringBuffer();
		Path path = Paths.get(aFileName);
		try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
		}
		return buffer.toString();
	}

	public static void writeLargerTextFileUTF8(String aFileName, List<String> aLines)
			throws IOException {
		Path path = Paths.get(aFileName);
		try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
			for (String line : aLines) {
				writer.write(line);
				writer.newLine();
			}
		}
	}
}

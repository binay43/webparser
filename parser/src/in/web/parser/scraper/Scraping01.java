package in.web.parser.scraper;

import in.web.parser.commons.FileUtils;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Scraping01 {

	public void run() {
		Document doc = readDocument();

		// Selecting by tagname
		run1(doc);
		run2(doc);
		run9(doc);
		run10(doc);
		//run3(doc);
		//run4(doc);

		// Selecting by attributes
		//run5(doc);
		run6(doc);
		//run7(doc);

		// Selecting by tag content
		//run8(doc);

	}

	private void run1(Document document) {
		System.out.println("run1:");

		XPath xpath = XPathFactory.newInstance().newXPath();
		try {
			NodeList nodes = (NodeList) xpath.evaluate
					//("//h2", document,
					("//title", document,
							
					XPathConstants.NODESET);

			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getTextContent());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		System.out.println("");
	}

	private void run2(Document document) {
		System.out.println("run2:");

		XPath xpath = XPathFactory.newInstance().newXPath();
		try {
			NodeList nodes = (NodeList) xpath.evaluate("//div/p", document,
					XPathConstants.NODESET);

			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getTextContent());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		System.out.println("");
	}
	private void run9(Document document) {
		System.out.println("run9:");

		XPath xpath = XPathFactory.newInstance().newXPath();
		try {
			NodeList nodes = (NodeList) xpath.evaluate("//div/div/spam", document,
					XPathConstants.NODESET);

			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getTextContent());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		System.out.println("");
	}

	private void run3(Document document) {
		System.out.println("run3:");

		XPath xpath = XPathFactory.newInstance().newXPath();
		try {
			NodeList nodes = (NodeList) xpath.evaluate("//*/div/p", document,
					XPathConstants.NODESET);

			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getTextContent());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		System.out.println("");
	}

	private void run4(Document document) {
		System.out.println("run4:");

		XPath xpath = XPathFactory.newInstance().newXPath();
		try {
			NodeList nodes = (NodeList) xpath.evaluate(
					"//*[name()='h1' or name()='h2']", document,
					XPathConstants.NODESET);

			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getTextContent());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		System.out.println("");
	}

	private void run5(Document document) {
		System.out.println("run5:");

		XPath xpath = XPathFactory.newInstance().newXPath();
		try {
			NodeList nodes = (NodeList) xpath.evaluate("//*[@style]", document,
					XPathConstants.NODESET);

			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getTextContent());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		System.out.println("");
	}

	private void run6(Document document) {
		System.out.println("run6:");

		XPath xpath = XPathFactory.newInstance().newXPath();
		try {
			NodeList nodes = (NodeList) xpath.evaluate("//*[@class='topstorytit']",
					document, XPathConstants.NODESET);

			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getTextContent());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		System.out.println("");
	}
	private void run10(Document document) {
		System.out.println("run10:");

		XPath xpath = XPathFactory.newInstance().newXPath();
		try {
			NodeList nodes = (NodeList) xpath.evaluate("//*[@id='breakingnewsinner']",
					document, XPathConstants.NODESET);

			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getTextContent());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		System.out.println("");
	}
	

	private void run7(Document document) {
		System.out.println("run7:");

		XPath xpath = XPathFactory.newInstance().newXPath();
		String str;
		try {
			str = (String) xpath.evaluate("//h1[@class='bookTitle']", document,
					XPathConstants.STRING);

			System.out.println(str);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		System.out.println("");
	}

	private void run8(Document document) {
		System.out.println("run8:");

		XPath xpath = XPathFactory.newInstance().newXPath();
		try {
			NodeList nodes = (NodeList) xpath.evaluate(
					"//h2[contains(., 'One')]", document,
					XPathConstants.NODESET);

			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getTextContent());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		System.out.println("");
	}

	private Document readDocument() {
		String content = null;
		try {
			content = FileUtils
					//.readLargeTextFileUTF8("src/resources/index.html");
					.readLargeTextFileUTF8("src/resources/test.html");
		} catch (IOException e) {

		}

		TagNode tagNode = new HtmlCleaner().clean(content);
		System.out.println(tagNode);
		Document doc = null;
		try {
			doc = new DomSerializer(new CleanerProperties()).createDOM(tagNode);
			System.out.println(doc);
			return doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}

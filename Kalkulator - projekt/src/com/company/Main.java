package com.company;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Scanner;

public class Main {

    public static void main(String argv[]) {
        System.out.println();
        System.out.println();
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Podaj kwotę EUR do wymiany: ");
        while (scanner1.hasNext()) {
            if (scanner1.hasNextFloat()) {
                break;
            } else {
                setLines();
                System.out.println("Podaj ponownie kwotę w EUR, błędna wartość: " + scanner1.next());
                System.out.print("Podaj kwotę EUR do wymiany: ");
            }
        }
        float valueIn = scanner1.nextFloat();
        if (valueIn >= 0) {
            System.out.println();
            System.out.print("Kwota EUR do wymiany: " + valueIn);
            System.out.println();

            try {
                File file = new File("waluty-daily.xml");
                DocumentBuilderFactory docBuildFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuild = docBuildFactory.newDocumentBuilder();
                Document document = docBuild.parse(file);
                document.getDocumentElement().normalize();
                NodeList nodeLst = document.getElementsByTagName("Cube");
                System.out.print("Waluta: ");
                String currencyOut = scanner2.nextLine().toUpperCase();

                for (int s = 2; s < nodeLst.getLength(); s++)
                {
                    Node firstNode = nodeLst.item(s);

                    if (firstNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element firstElement = (Element) firstNode;
                        if(currencyOut.equals(firstElement.getAttribute("currency")))
                        {
                            NodeList firstNodeElementntLst = firstElement.getElementsByTagName("Cube");
                            Element firstNodeElementnt = (Element) firstNodeElementntLst.item(0);
                            if (currencyOut.equals(firstElement.getAttribute("currency")))
                            {
                                String currencyRate = firstElement.getAttribute("rate");
                                System.out.print("Kurs: " + currencyRate + " - ");
                                float fValue = Float.parseFloat(0 + currencyRate);
                                fValue = fValue * valueIn;
                                System.out.println("Wartość: " + fValue);
                            }
                        }
                    } else {
                        System.out.println("Błąd");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Podana wartość jest błędna!");
        }
    }
    public static void setLines() {
        System.out.println();
        System.out.println();
    }
}




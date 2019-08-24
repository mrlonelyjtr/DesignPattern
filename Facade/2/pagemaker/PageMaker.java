package pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {}

    public static void makeLinkPage(String filename) {
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Link page");
            Properties mailprop = Database.getProperties("./xxx/maildata");
            Enumeration en = mailprop.propertyNames();
            while (en.hasMoreElements()) {
                String mailaddr = (String) en.nextElement();
                String username = mailprop.getProperty(mailaddr);
                writer.mailto(mailaddr, username);
            }
            writer.close();
            System.out.println(filename + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
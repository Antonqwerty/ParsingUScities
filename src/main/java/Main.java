import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> usCitiesEng = new ArrayList<String>();
        ArrayList<String> usCitiesRus = new ArrayList<String>();
        Document doc;
        try {
            doc = Jsoup.connect("https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D0%B3%D0%BE%D1%80%D0%BE%D0%B4%D0%BE%D0%B2_%D0%A1%D0%A8%D0%90_%D1%81_%D0%BD%D0%B0%D1%81%D0%B5%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5%D0%BC_%D0%B1%D0%BE%D0%BB%D0%B5%D0%B5_100_%D1%82%D1%8B%D1%81%D1%8F%D1%87_%D0%B6%D0%B8%D1%82%D0%B5%D0%BB%D0%B5%D0%B9").get();
            System.out.println("\n");
            System.out.println(doc.title() + ":" + "\n");
            Elements allLinksEng = doc.select("td:nth-child(2) i:nth-child(3)");
            Elements allLinksRus = doc.select(".sortable tr td:nth-child(2) a");

            for (Element el : allLinksEng) {
                usCitiesEng.add(el.text());
            }
            for (Element el : allLinksRus) {
                usCitiesRus.add(el.text());
            }
            System.out.println(usCitiesEng.size() + " " + "Eng:");
            System.out.println(usCitiesEng);
            System.out.println("\n");
            System.out.println(usCitiesRus.size() + " " + "Rus:");
            System.out.println(usCitiesRus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

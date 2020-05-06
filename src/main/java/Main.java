import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<String>();
        Document doc;
        try {
            doc = Jsoup.connect("https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D0%B3%D0%BE%D1%80%D0%BE%D0%B4%D0%BE%D0%B2_%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D0%B8").get();
            System.out.println(doc.title() + "\n");

            // вытаскиваем из документа ссылки попадающие под шаблон и засовываем в alllinks
            Elements allLinks = doc.select("#mw-content-text tr td:nth-child(3) a");

            //создается переменная эль в которую попадают по очередно из коллекции allinks
            for (Element el : allLinks) {
                System.out.println(el.text());
                cities.add(el.text());
            }
            System.out.println(cities.size());
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
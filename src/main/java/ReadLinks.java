import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class ReadLinks
{
    private static Set<String> uniqueURL = new HashSet<String>();


    public void getLinks(String url) {

        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a");

            if (links.isEmpty()) {
                return;
            }

            links.stream().map((link) -> link.attr("abs:href")).forEachOrdered((this_url) -> {
                boolean add = uniqueURL.add(this_url);

                if (add && this_url.contains(url)) {
                    System.out.println(this_url);
                    getLinks(this_url);
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}



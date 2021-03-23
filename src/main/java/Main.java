import java.util.HashSet;
import java.util.Set;


public class Main
{
    private static final String SITE = "https://lenta.ru/";
    private static final String file = "file";


    public static void main(String[] args) {
        ReadLinks readLinks = new ReadLinks();
        readLinks.getLinks(SITE);
    }
}


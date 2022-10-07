package task08150.model;

import task08150.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new ArrayList<>();
        int page = 0;

        try {
            while (true) {
                Document document = getDocument(searchString, page);
//                Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy vacancy-serp__vacancy_standard");

                if (elements.isEmpty()) {
                    break;
                }
                for (Element element : elements) {
//                    Elements title = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");
                    Elements title = element.getElementsByAttributeValue("data-qa", "serp-item__title");

                    Elements salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation");
                    Elements city = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address");
                    Elements company = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title.get(0).text());
                    vacancy.setSalary(salary.size() > 0 ? salary.get(0).text() : "");
                    vacancy.setCity(city.get(0).text());
                    vacancy.setCompanyName(company.get(0).text());
                    vacancy.setSiteName("https://hh.ru");
                    vacancy.setUrl(title.get(0).attr("href"));
                    result.add(vacancy);
                }
                page++;
            }

        } catch (IOException ignore) {
        }

        return result;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36")
                .referrer("https://hh.ru/search/vacancy?text=java+Penza")
                .get();
    }
}

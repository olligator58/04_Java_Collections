package task08150;

import task08150.model.HHStrategy;
import task08150.model.HabrCareerStrategy;
import task08150.model.Model;
import task08150.model.Provider;
import task08150.view.HtmlView;

public class Aggregator {

    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Model model = new Model(view, new Provider(new HHStrategy()), new Provider(new HabrCareerStrategy()));
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}

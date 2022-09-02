package task05150.female;

import task05150.AbstractFactory;
import task05150.Human;

public class FemaleFactory implements AbstractFactory {

    @Override
    public Human getPerson(int age) {
        Human person;
        if (age <= KidGirl.MAX_AGE) {
            person = new KidGirl();
        } else if (age <= TeenGirl.MAX_AGE) {
            person = new TeenGirl();
        } else {
            person = new Woman();
        }
        return person;
    }
}

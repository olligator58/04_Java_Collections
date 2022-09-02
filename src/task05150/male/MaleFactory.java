package task05150.male;

import task05150.AbstractFactory;
import task05150.Human;

public class MaleFactory implements AbstractFactory {

    @Override
    public Human getPerson(int age) {
        Human person;
        if (age <= KidBoy.MAX_AGE) {
            person = new KidBoy();
        } else if (age <= TeenBoy.MAX_AGE) {
            person = new TeenBoy();
        } else {
            person = new Man();
        }
        return person;
    }
}

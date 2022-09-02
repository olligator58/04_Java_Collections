package task05150;

import task05150.female.FemaleFactory;
import task05150.male.MaleFactory;

public class FactoryProducer {

    public static enum HumanFactoryType {
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType humanFactoryType) {
        AbstractFactory factory = null;
        switch (humanFactoryType) {
            case MALE:
                factory = new MaleFactory();
                break;
            case FEMALE:
                factory = new FemaleFactory();
                break;
        }
        return factory;
    }
}

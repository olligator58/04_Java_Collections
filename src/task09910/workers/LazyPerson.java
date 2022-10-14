package task09910.workers;

public class LazyPerson implements Eater, Sleeper {

    @Override
    public void eat() {
        System.out.println("LazyPerson is eating!");
    }

    @Override
    public void sleep() {
        System.out.println("LazyPerson is sleeping!");
    }
}

package task0583;

public class Generator<T> {
    private Class<T> clazz;

    public Generator(Class<T> clazz) {
        this.clazz = clazz;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}

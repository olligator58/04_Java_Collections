import java.util.List;

/*
extends vs super
*/

public abstract class Task05101 {
    public abstract <T> void one(List<T> destination, List<T> source);

    public abstract <T> void two(List<T> destination, List<? extends T> source);

    public abstract <T> void three(List<? super T> destination, List<T> source);

    public abstract <T> void four(List<? super T> destination, List<? extends T> source);
}

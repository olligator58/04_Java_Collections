package task0580;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable<K>> Map<K, V> convert(List<V> list) {
        Map<K, V> result = new HashMap<>();
        for (V convertable : list) {
            result.put(convertable.getKey(), convertable);
        }
        return result;
    }
}

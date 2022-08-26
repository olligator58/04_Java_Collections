package task04150;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int) Math.ceil(collection.size() / .75f));
        this.map = new HashMap<>(capacity);
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        if (!map.containsKey(e)) {
            map.put(e, PRESENT);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> result = (AmigoSet<E>) super.clone();
            result.map = (HashMap<E, Object>) map.clone();
            return result;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        List<E> keys = new ArrayList<>(map.keySet());
        out.writeObject(keys);
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        List<E> keys = (List<E>) in.readObject();
        Integer capacity = (Integer) in.readObject();
        Float loadFactor = (Float) in.readObject();
        this.map = new HashMap<>(capacity, loadFactor);
        for (E e : keys) {
            add(e);
        }
    }

    //debug
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        AmigoSet<String> set = new AmigoSet<>(list);
        System.out.println(set);
        System.out.println(set.size());

        try (FileOutputStream fos = new FileOutputStream("C:\\work\\JavaRush\\files\\AmigoSet.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(set);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileInputStream fis = new FileInputStream("C:\\work\\JavaRush\\files\\AmigoSet.obj");
             ObjectInputStream ois = new ObjectInputStream(fis);) {
            AmigoSet<String> newSet = (AmigoSet<String>) ois.readObject();
            System.out.println(newSet);
            System.out.println(newSet.size());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

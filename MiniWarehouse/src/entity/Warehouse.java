package entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Warehouse<T extends IEntity> {
    private Map<String, T> storage = new HashMap<>();

    public void addItem(T item) {
        storage.put(item.getId(), item);
    }

    public T getItem(String id) {
        return storage.get(id);
    }

    // Xoa hang loat dua tren dieu kien
    public void removeItems(Predicate<T> condition) {
        storage.values().removeIf(condition);
    }

    public Collection<T> getAll() {
        return storage.values();
    }
}

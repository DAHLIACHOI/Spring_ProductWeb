package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static  final Map<Long, Item> store = new HashMap<>(); // 동시에 여러 쓰레드가 접근할때는 해쉬맵 절대 쓰면 안됨!! 쓸거면 ConcurrentHashMap 사용
    private static long sequence = 0L; // 얘도 동시에 접근할때는 long말고 atomicLong 같은거 사용해야됨

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updatePram) {
        Item findItem = findById(itemId);
        findItem.setItemName(updatePram.getItemName());
        findItem.setPrice(updatePram.getPrice());
        findItem.setQuantity(updatePram.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}

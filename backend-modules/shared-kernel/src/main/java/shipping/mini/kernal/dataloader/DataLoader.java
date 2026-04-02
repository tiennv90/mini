package shipping.mini.kernal.dataloader;

import java.util.List;
import java.util.Map;

public interface DataLoader<K,V>{
	Map<K, List<V>> load(List<K> keyIds);
	
	default List<V> loadAsList(List<K> keyIds) {
		return load(keyIds).values().stream().flatMap(List::stream).toList();
	}
}

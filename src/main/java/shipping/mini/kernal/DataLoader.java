package shipping.mini.kernal;

import java.util.List;
import java.util.Map;

public interface DataLoader<K,V>{
	Map<K, List<V>> load(List<K> keyIds);
}

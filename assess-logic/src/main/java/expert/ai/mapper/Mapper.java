package expert.ai.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper Interface 
 * @author amineboufatah
 *
 * @param <S>
 * @param <T>
 */
public interface Mapper<S,T> {

	/**
	 * Maps from source to target
	 * @param source
	 * @return target 
	 */
	public T map(S source);
	
	/**
	 * Helper method for mapping a Collection of sources  
	 * @param targets
	 * @return Collection of targets
	 */
	default List<T> mapAll(List<S> sources){
		List<T> maps = new ArrayList<>();
		for (S source : sources) {
			maps.add(map(source));
		}
		return maps;
	}
	
}

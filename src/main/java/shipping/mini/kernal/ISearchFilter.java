package shipping.mini.kernal;

import org.springframework.data.jpa.domain.Specification;

public interface ISearchFilter<T, C> {
	Specification<T> apply(C criteria);
}

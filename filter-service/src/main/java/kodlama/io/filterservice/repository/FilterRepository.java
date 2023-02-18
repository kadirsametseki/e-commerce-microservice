package kodlama.io.filterservice.repository;

import kodlama.io.filterservice.entities.Filter;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import javax.annotation.Nonnull;
import java.util.List;

public interface FilterRepository extends ElasticsearchRepository<Filter, String> {
    void deleteAllByCategoryId(String categoryId);
    Filter findFilterByProductId(String productId);
    List<Filter> findFilterByCategoryId(String categoryId);
    List<Filter> findFilterByProductNameIgnoreCase(String productName);
    List<Filter> findFilterByCategoryNameIgnoreCase(String categoryName);

    // Override findAll method to return List<Filter> instead of Iterable<Filter>
    @Nonnull
    List<Filter> findAll();
}
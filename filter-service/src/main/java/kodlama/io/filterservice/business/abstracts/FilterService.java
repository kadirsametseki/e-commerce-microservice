package kodlama.io.filterservice.business.abstracts;

import kodlama.io.filterservice.business.dto.responses.GetAllFilterResponse;
import kodlama.io.filterservice.business.dto.responses.GetFilterResponse;
import kodlama.io.filterservice.entities.Filter;

import java.util.List;

public interface FilterService {

    GetFilterResponse getById(String id);
    List<GetAllFilterResponse> getAll();
    List<GetAllFilterResponse> getAllByProductName(String productName);
    List<GetAllFilterResponse> getAllByCategoryName(String categoryName);

    //? Consumer service will use this methods to save and delete filters
    Filter getByProductId(String productId);
    List<Filter> getByCategoryId(String categoryId);
    void create(Filter filter);
    void delete(String id);
    void deleteAllByCategoryId(String categoryId);
}

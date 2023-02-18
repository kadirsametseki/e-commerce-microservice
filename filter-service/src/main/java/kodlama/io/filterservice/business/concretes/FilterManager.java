package kodlama.io.filterservice.business.concretes;

import kodlama.io.common.utilities.mapping.ModelMapperService;
import kodlama.io.filterservice.business.abstracts.FilterService;
import kodlama.io.filterservice.business.dto.responses.GetAllFilterResponse;
import kodlama.io.filterservice.business.dto.responses.GetFilterResponse;
import kodlama.io.filterservice.entities.Filter;
import kodlama.io.filterservice.repository.FilterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilterManager implements FilterService {
    private final FilterRepository repository;
    private final ModelMapperService mapper;

    @Override
    public GetFilterResponse getById(String id) {
        Optional<Filter> filter = repository.findById(id);
        GetFilterResponse response = mapper.forResponse().map(filter, GetFilterResponse.class);

        return response;
    }

    @Override
    public List<GetAllFilterResponse> getAll() {
        return findAllAndMapToResponseList(repository.findAll());
    }

    @Override
    public List<GetAllFilterResponse> getAllByProductName(String productName) {
        return findAllAndMapToResponseList(repository.findFilterByProductNameIgnoreCase(productName));
    }

    @Override
    public List<GetAllFilterResponse> getAllByCategoryName(String categoryName) {
        return findAllAndMapToResponseList(repository.findFilterByCategoryNameIgnoreCase(categoryName));
    }

    @Override
    public Filter getByProductId(String productId) {
        return repository.findFilterByProductId(productId);
    }

    @Override
    public List<Filter> getByCategoryId(String categoryId) {
        return repository.findFilterByCategoryId(categoryId);
    }

    @Override
    public void create(Filter filter) {
        repository.save(filter);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllByCategoryId(String categoryId) {
        repository.deleteAllByCategoryId(categoryId);
    }

    private List<GetAllFilterResponse> findAllAndMapToResponseList(List<Filter> filterList) {
        List<Filter> filters = filterList;
        List<GetAllFilterResponse> response = filters
                .stream()
                .map(filter -> mapper.forResponse().map(filter, GetAllFilterResponse.class))
                .toList();

        return response;
    }
}

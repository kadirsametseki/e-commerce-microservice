package kodlama.io.inventoryservice.business.concretes;

import kodlama.io.common.utilities.mapping.ModelMapperService;
import kodlama.io.inventoryservice.business.abstracts.CategoryService;
import kodlama.io.inventoryservice.business.dto.requests.create.CreateCategoryRequest;
import kodlama.io.inventoryservice.business.dto.requests.update.UpdateCategoryRequest;
import kodlama.io.inventoryservice.business.dto.responses.create.CreateCategoryResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetAllCategoriesResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.inventoryservice.business.dto.responses.update.UpdateCategoryResponse;
import kodlama.io.inventoryservice.entities.Category;
import kodlama.io.inventoryservice.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository repository;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = repository.findAll();
        List<GetAllCategoriesResponse> response = categories
                .stream()
                .map(category -> mapper.forResponse().map(category, GetAllCategoriesResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetCategoryResponse getById(String id) {
        Optional<Category> category = repository.findById(id);
        GetCategoryResponse response = mapper.forResponse().map(category, GetCategoryResponse.class);

        return response;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        Category category = mapper.forRequest().map(request, Category.class);
        category.setId(UUID.randomUUID().toString());
        repository.save(category);
        CreateCategoryResponse response = mapper.forResponse().map(category, CreateCategoryResponse.class);

        return response;
    }

    @Override
    public UpdateCategoryResponse update(UpdateCategoryRequest request) {
        Category category = mapper.forRequest().map(request, Category.class);
        repository.save(category);
        UpdateCategoryResponse response = mapper.forResponse().map(category, UpdateCategoryResponse.class);

        return response;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}


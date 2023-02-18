package kodlama.io.inventoryservice.business.abstracts;

import kodlama.io.inventoryservice.business.dto.requests.create.CreateCategoryRequest;
import kodlama.io.inventoryservice.business.dto.requests.update.UpdateCategoryRequest;
import kodlama.io.inventoryservice.business.dto.responses.create.CreateCategoryResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetAllCategoriesResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.inventoryservice.business.dto.responses.update.UpdateCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();
    GetCategoryResponse getById(String id);
    CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest);
    UpdateCategoryResponse update(UpdateCategoryRequest updateCategoryRequest);
    void delete(String id);
}


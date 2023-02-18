package kodlama.io.inventoryservice.api;

import jakarta.validation.Valid;
import kodlama.io.inventoryservice.business.abstracts.CategoryService;
import kodlama.io.inventoryservice.business.dto.requests.create.CreateCategoryRequest;
import kodlama.io.inventoryservice.business.dto.requests.update.UpdateCategoryRequest;
import kodlama.io.inventoryservice.business.dto.responses.create.CreateCategoryResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetAllCategoriesResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetCategoryResponse;
import kodlama.io.inventoryservice.business.dto.responses.update.UpdateCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryService service;

    @GetMapping
    public List<GetAllCategoriesResponse> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponse add(@Valid @RequestBody CreateCategoryRequest request) {
        return service.add(request);
    }

    @PutMapping
    public UpdateCategoryResponse update(@Valid @RequestBody UpdateCategoryRequest request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable String id) {
        return service.getById(id);
    }
}

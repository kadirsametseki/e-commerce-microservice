package kodlama.io.inventoryservice.api;

import jakarta.validation.Valid;
import kodlama.io.inventoryservice.business.abstracts.ProductService;
import kodlama.io.inventoryservice.business.dto.requests.create.CreateProductRequest;
import kodlama.io.inventoryservice.business.dto.requests.update.UpdateProductRequest;
import kodlama.io.inventoryservice.business.dto.responses.create.CreateProductResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetAllProductsResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetProductResponse;
import kodlama.io.inventoryservice.business.dto.responses.update.UpdateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/products")

public class ProductsController {
    private final ProductService service;

    @GetMapping
    public List<GetAllProductsResponse> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@Valid @RequestBody CreateProductRequest request) {
        return service.add(request);
    }

    @PutMapping
    public UpdateProductResponse update(@Valid @RequestBody UpdateProductRequest request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable String id) {
        return service.getById(id);
    }
}

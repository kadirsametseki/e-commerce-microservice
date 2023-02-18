package kodlama.io.inventoryservice.business.abstracts;

import kodlama.io.inventoryservice.business.dto.requests.create.CreateProductRequest;
import kodlama.io.inventoryservice.business.dto.requests.update.UpdateProductRequest;
import kodlama.io.inventoryservice.business.dto.responses.create.CreateProductResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetAllProductsResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetProductResponse;
import kodlama.io.inventoryservice.business.dto.responses.update.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductsResponse> getAll();
    GetProductResponse getById(String id);
    CreateProductResponse add(CreateProductRequest request);
    UpdateProductResponse update(UpdateProductRequest request);
    void delete(String id);
}

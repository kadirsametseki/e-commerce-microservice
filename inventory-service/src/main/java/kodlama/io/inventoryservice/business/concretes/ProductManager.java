package kodlama.io.inventoryservice.business.concretes;

import kodlama.io.common.utilities.mapping.ModelMapperService;
import kodlama.io.inventoryservice.business.abstracts.ProductService;
import kodlama.io.inventoryservice.business.dto.requests.create.CreateProductRequest;
import kodlama.io.inventoryservice.business.dto.requests.update.UpdateProductRequest;
import kodlama.io.inventoryservice.business.dto.responses.create.CreateProductResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetAllProductsResponse;
import kodlama.io.inventoryservice.business.dto.responses.get.GetProductResponse;
import kodlama.io.inventoryservice.business.dto.responses.update.UpdateProductResponse;
import kodlama.io.inventoryservice.entities.Product;
import kodlama.io.inventoryservice.entities.Status;
import kodlama.io.inventoryservice.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository repository;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllProductsResponse> getAll() {

        List<Product> products = repository.findAll();
        List<GetAllProductsResponse> response = products
                .stream()
                .map(product -> mapper.forResponse().map(product, GetAllProductsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetProductResponse getById(String id) {
        Optional<Product> product = repository.findById(id);
        GetProductResponse response = mapper.forResponse().map(product, GetProductResponse.class);

        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        Product product = mapper.forRequest().map(request, Product.class);
        product.setId(UUID.randomUUID().toString());
        product.setStatus(Status.AVAILABLE);
        repository.save(product);
        CreateProductResponse response = mapper.forResponse().map(product, CreateProductResponse.class);

        return response;
    }

    @Override
    public UpdateProductResponse update(UpdateProductRequest request) {
        Product product = mapper.forRequest().map(request, Product.class);
        repository.save(product);
        UpdateProductResponse response = mapper.forResponse().map(product, UpdateProductResponse.class);

        return response;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}

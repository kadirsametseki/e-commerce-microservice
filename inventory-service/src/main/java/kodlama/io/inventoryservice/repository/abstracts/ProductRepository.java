package kodlama.io.inventoryservice.repository.abstracts;

import kodlama.io.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

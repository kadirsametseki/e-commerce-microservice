package kodlama.io.inventoryservice.repository.abstracts;

import kodlama.io.inventoryservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}

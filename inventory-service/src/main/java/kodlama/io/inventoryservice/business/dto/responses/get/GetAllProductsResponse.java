package kodlama.io.inventoryservice.business.dto.responses.get;

import kodlama.io.inventoryservice.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsResponse {
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private Status status;
    private String categoryName;
}

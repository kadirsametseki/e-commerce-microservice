package kodlama.io.filterservice.business.dto.responses;

import kodlama.io.filterservice.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFilterResponse {
    private String id;
    private String productId;
    private String categoryId;
    private String productName;
    private String categoryName;
    private String productDescription;
    private double productPrice;
    private int productStock;
    private Status productStatus;
}

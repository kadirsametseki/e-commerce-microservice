package kodlama.io.filterservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "filterdb")
public class Filter {
    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "productId")
    private String productId;

    @Field(name = "categoryId")
    private String categoryId;

    @Field(name = "productName")
    private String productName;

    @Field(name = "categoryName")
    private String categoryName;

    @Field(name = "productDescription")
    private String productDescription;

    @Field(name = "productPrice")
    private double productPrice;

    @Field(name = "productStock")
    private int productStock;

    @Field(name = "productStatus")
    private Status productStatus;
}

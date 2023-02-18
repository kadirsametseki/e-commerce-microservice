package kodlama.io.filterservice.api.controllers;

import kodlama.io.filterservice.business.abstracts.FilterService;
import kodlama.io.filterservice.business.dto.responses.GetAllFilterResponse;
import kodlama.io.filterservice.business.dto.responses.GetFilterResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/filters")
public class FiltersController {
    private final FilterService service;

    @GetMapping
    public List<GetAllFilterResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/products/{productName}")
    public List<GetAllFilterResponse> getAllByProductName(@PathVariable String productName) {
        return service.getAllByProductName(productName);
    }

    @GetMapping("/categories/{categoryName}")
    public List<GetAllFilterResponse> getAllByCategoryName(@PathVariable String categoryName) {
        return service.getAllByCategoryName(categoryName);
    }

    @GetMapping("/{id}")
    public GetFilterResponse getById(@PathVariable String id) {
        return service.getById(id);
    }
}

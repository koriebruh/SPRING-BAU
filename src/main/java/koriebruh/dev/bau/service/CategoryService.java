package koriebruh.dev.bau.service;

import koriebruh.dev.bau.dto.CategoryRequest;
import koriebruh.dev.bau.dto.CategoryResponse;
import koriebruh.dev.bau.entity.Admin;
import koriebruh.dev.bau.entity.Category;
import koriebruh.dev.bau.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponse createCategory(CategoryRequest request ) {

        if (categoryRepository.existsByName(request.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category name already exists");
        }

        // mengambil user yang sedang login di cookie
        Admin currentAdmin = (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setCreatedBy(currentAdmin);

        category = categoryRepository.save(category);

        return mapToResponse(category);
    }

    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    //MAPPING RESPONSE
    private CategoryResponse mapToResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());
        response.setCreatedBy(category.getCreatedBy().getUsername());
        response.setCreatedAt(category.getCreatedAt());
        response.setUpdatedAt(category.getUpdatedAt());
        return response;
    }


}

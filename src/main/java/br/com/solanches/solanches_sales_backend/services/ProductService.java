package br.com.solanches.solanches_sales_backend.services;

import br.com.solanches.solanches_sales_backend.entities.Product;
import br.com.solanches.solanches_sales_backend.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAllWithIngredients();
    }
}

package br.com.solanches.solanches_sales_backend.repositories;

import br.com.solanches.solanches_sales_backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p JOIN FETCH p.productIngredients pi JOIN FETCH pi.id.ingredient")
    List<Product> findAllWithIngredients(); // To enforce Eager Loading avoiding the N+1 problem

}

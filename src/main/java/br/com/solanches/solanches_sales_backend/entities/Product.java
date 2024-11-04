package br.com.solanches.solanches_sales_backend.entities;


import br.com.solanches.solanches_sales_backend.entities.enums.ProductIngredientRelation;
import br.com.solanches.solanches_sales_backend.entities.enums.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "tbproduto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "codproduto")
    private Integer id;
    @Column(name = "codigo")
    private Integer code;
    @Column(name = "descricao", nullable = false, unique = true)
    private String name;
    @Column(name = "tipo")
    private ProductType type = ProductType.SANDWICH;
    @Column(name = "preco", nullable = false)
    private BigDecimal price;
    @Column(name = "unidademedida", nullable = false)
    private String unit = "Unidade";
    @JsonIgnore
    @OneToMany(mappedBy = "id.product", fetch = FetchType.LAZY)
    private List<ProductIngredient> productIngredients = new ArrayList<>();

    @JsonProperty("defaultIngredients")
    public List<ProductIngredient> getDefaultIngredients() {
        return new ArrayList<>(productIngredients.stream()
                .filter(i -> i.getRelation().equals(ProductIngredientRelation.DEFAULT)).collect(Collectors.toList()));
    }

    @JsonProperty("optionalIngredients")
    public List<ProductIngredient> getOptionalIngredients() {
        return new ArrayList<>(productIngredients.stream()
                .filter(i -> i.getRelation().equals(ProductIngredientRelation.OPTIONAL)).collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
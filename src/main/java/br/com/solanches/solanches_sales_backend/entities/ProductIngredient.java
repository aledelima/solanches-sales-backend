package br.com.solanches.solanches_sales_backend.entities;

import br.com.solanches.solanches_sales_backend.entities.enums.ProductIngredientRelation;
import br.com.solanches.solanches_sales_backend.utils.ProductIngredientRelationAttributeConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tbcomposicaoproduto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "ingredient", "quantity" })
public class ProductIngredient implements Serializable {

    @EmbeddedId
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private ProductIngredientPK id;
    @Column(name = "quantidade")
    private Integer quantity;
    @JsonIgnore
    @Convert(converter = ProductIngredientRelationAttributeConverter.class)
    @Column(name = "relacao", columnDefinition = "enum('I', 'A')")
    private ProductIngredientRelation relation;

    public ProductIngredient(Product product, Ingredient ingredient, ProductIngredientRelation relation) {
        this.id = new ProductIngredientPK();
        this.id.setProduct(product);
        this.id.setIngredient(ingredient);
        this.setRelation(relation);
    }

    public void setProduct(Product product) {
        if (this.id == null) this.id = new ProductIngredientPK();
        this.id.setProduct(product);
    }

    @JsonBackReference
    public Product getProduct() {
        return this.id.getProduct();
    }

    public void setIngredient(Ingredient ingredient) {
        if (this.id == null) this.id = new ProductIngredientPK();
        this.id.setIngredient(ingredient);
    }
    @JsonUnwrapped
    public Ingredient getIngredient() {
        return this.id.getIngredient();
    }

}

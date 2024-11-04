package br.com.solanches.solanches_sales_backend.utils;

import br.com.solanches.solanches_sales_backend.entities.enums.ProductIngredientRelation;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProductIngredientRelationAttributeConverter implements AttributeConverter<ProductIngredientRelation, String> {


    @Override
    public String convertToDatabaseColumn(ProductIngredientRelation attribute) {
        return attribute.getCode();
    }

    @Override
    public ProductIngredientRelation convertToEntityAttribute(String dbData) {
        return ProductIngredientRelation.valueOfCode(dbData);
    }
}

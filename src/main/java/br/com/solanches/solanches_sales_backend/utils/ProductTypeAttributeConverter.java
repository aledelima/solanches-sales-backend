package br.com.solanches.solanches_sales_backend.utils;

import br.com.solanches.solanches_sales_backend.entities.enums.ProductType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProductTypeAttributeConverter implements AttributeConverter<ProductType, String> {


    @Override
    public String convertToDatabaseColumn(ProductType attribute) {
        return attribute.getCode();
    }

    @Override
    public ProductType convertToEntityAttribute(String dbData) {
        return ProductType.valueOfCode(dbData);
    }
}

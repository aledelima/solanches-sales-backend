package br.com.solanches.solanches_sales_backend.utils;

import br.com.solanches.solanches_sales_backend.entities.enums.PaymentType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PaymentTypeAttributeConverter implements AttributeConverter<PaymentType, String> {


    @Override
    public String convertToDatabaseColumn(PaymentType attribute) {
        return attribute.getCode();
    }

    @Override
    public PaymentType convertToEntityAttribute(String dbData) {
        return PaymentType.valueOfCode(dbData);
    }
}

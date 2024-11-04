package br.com.solanches.solanches_sales_backend.entities.enums;

public enum ProductType {

    SANDWICH("S"),
    JUICE("V"),
    BEVERAGE("B"),
    DESSERT("D"),
    ADDITIONAL("A");

    private final String code;

    private ProductType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static ProductType valueOfCode(String code) {
        for (ProductType value: ProductType.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Nonexistent ProductType code. Code: " + code);
    }

}
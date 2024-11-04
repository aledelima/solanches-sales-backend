package br.com.solanches.solanches_sales_backend.entities.enums;

public enum ProductIngredientRelation {

    DEFAULT("I"),
    OPTIONAL("A");

    private final String code;

    private ProductIngredientRelation(String code) {
        this.code = code;
    }

    public static ProductIngredientRelation valueOfCode(String code) {
        for (ProductIngredientRelation pit : values()) {
            if (pit.code.equals(code)) {
                return pit;
            }
        }
        throw new IllegalArgumentException("Nonexisting code for ProductIngredienteRelation. Code: " + code);
    }

    public String getCode() {
        return this.code;
    }
}

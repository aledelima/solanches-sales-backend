package br.com.solanches.solanches_sales_backend.entities.enums;

public enum PaymentType {

    CASH("D"),
    CARD("C"),
    PIX("P");

    private final String code;

    private PaymentType(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static PaymentType valueOfCode(String code) {
        for (PaymentType value: PaymentType.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Nonexistent PaymentType code. Code: " + code);
    }

}
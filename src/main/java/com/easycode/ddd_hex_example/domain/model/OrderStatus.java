package com.easycode.ddd_hex_example.domain.model;

public enum OrderStatus {


    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED,
    RETURNED;



    public String  getDescription() {
        switch (this) {
            case PENDING:
                return "Order is pending";
            case PROCESSING:
                return "Order is processing";
            case SHIPPED:
                return "Order is shipped";
            case DELIVERED:
                return "Order is delivered";
            case CANCELLED:
                return "Order is cancelled";
            case RETURNED:
                return "Order is returned";
            default:
                return "Order status not found";
        }
    }
}

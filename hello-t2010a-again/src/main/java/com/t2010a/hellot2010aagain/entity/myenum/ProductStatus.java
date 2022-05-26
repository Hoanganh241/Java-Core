package com.t2010a.hellot2010aagain.entity.myenum;

import com.t2010a.hellot2010aagain.entity.Product;

public enum ProductStatus {
    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINE(-2);
    private  int value;
    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ProductStatus of(int value){
        for (ProductStatus status:
                ProductStatus.values()) {
            if(status.getValue() == value){
                return status;
            }

        }
        return ProductStatus.UNDEFINE;
    }
}

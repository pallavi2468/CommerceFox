package com.example.projectecommerce.cartdto;

public class CartDto {
    private String cartIdDto;
    private String productIdDto;
    private String customerIdDto;
    private int quantityDto;
    private boolean isBuyDto = false;

    public String getCartIdDto() {
        return cartIdDto;
    }

    public void setCartIdDto(String cartIdDto) {
        this.cartIdDto = cartIdDto;
    }

    public String getProductIdDto() {
        return productIdDto;
    }

    public void setProductIdDto(String productIdDto) {
        this.productIdDto = productIdDto;
    }

    public String getCustomerIdDto() {
        return customerIdDto;
    }

    public void setCustomerIdDto(String customerIdDto) {
        this.customerIdDto = customerIdDto;
    }

    public int getQuantityDto() {
        return quantityDto;
    }

    public void setQuantityDto(int quantityDto) {
        this.quantityDto = quantityDto;
    }

    public boolean isBuyDto() {
        return isBuyDto;
    }

    public void setBuyDto(boolean buyDto) {
        isBuyDto = buyDto;
    }
}

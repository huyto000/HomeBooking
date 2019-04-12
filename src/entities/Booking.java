package entities;

import java.util.Date;

public class Booking {
    private int id;
    private Date createdAt;
    private Date updatedAt;
    private Date issuedAt;
    private double totalPrice;
    private String customerInformation;
    private String saleItemInformation;

    public Booking() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerInformation() {
        return customerInformation;
    }

    public void setCustomerInformation(String customerInformation) {
        this.customerInformation = customerInformation;
    }

    public String getSaleItemInformation() {
        return saleItemInformation;
    }

    public void setSaleItemInformation(String saleItemInformation) {
        this.saleItemInformation = saleItemInformation;
    }


}

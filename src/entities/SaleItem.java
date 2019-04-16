package entities;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleItem implements Serializable, Comparable<SaleItem> {

    private int id;
    private int length;
    private int width;
    private int acreage;
    private double unitPrice;
    private String rateType;
    private Date createdAt;
    private Date updatedAt;
    private Date issuedAt;
    private String address;
    private int numberOfRoom;
    private int numberOfPerson;
    private String itemName;
    Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public SaleItem(int id, int length, int width, int acreage, double unitPrice, String rateType, Date createdAt, Date updatedAt, Date issuedAt, String address, int numberOfRoom, int numberOfPerson, String itemName) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.acreage = acreage;
        this.unitPrice = unitPrice;
        this.rateType = rateType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.issuedAt = issuedAt;
        this.address = address;
        this.numberOfRoom = numberOfRoom;
        this.numberOfPerson = numberOfPerson;
        this.itemName = itemName;
    }


    public SaleItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getRateType() {
        if (this.rateType.equals("STREETVIEW")) return 1;
        else if (this.rateType.equals("CITYVIEW")) return 1.2;
        else if (this.rateType.equals("SEAVIEW")) return 1.5;
        else if (this.rateType.equals("RESORT")) return 1.8;
        else return 0;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getCreatedAt() {
        return formatter.format(createdAt);
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return formatter.format(updatedAt);
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getIssuedAt() {
        return formatter.format(issuedAt);
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int compareTo(SaleItem saleItem) {
        return (int) (this.unitPrice = saleItem.unitPrice);
    }
}

package models;

public class Slot {

    private String slotCode;
    private Product product;
    private int quantity;
    private int maxcap;

    public Slot(String slotCode, Product product, int quantity, int maxcap) {
        this.slotCode = slotCode;
        this.product = product;
        this.quantity = quantity;
        this.maxcap = maxcap;
    }

    public String getSlotCode() {
        return slotCode;
    }

    public void setSlotCode(String slotCode) {
        this.slotCode = slotCode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getMaxcap() {
        return maxcap;
    }

    public void setMaxcap(int maxcap) {
        this.maxcap = maxcap;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

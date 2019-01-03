import java.io.Serializable;

public class Service implements Serializable {

    private String itemId;
    private String itemDescription;
    private Integer numOfItems;
    private Double price;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(Integer numOfItems) {
        this.numOfItems = numOfItems;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Service(String itemId, String itemDescription, Integer numOfItems, Double price) {
        this.itemId = itemId;
        this.itemDescription = itemDescription;
        this.numOfItems = numOfItems;
        this.price = price;
    }

    public Service() {
        itemId = "";
        itemDescription = "";
        numOfItems = 0;
        price = 0.0;
    }
}

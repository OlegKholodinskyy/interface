package lesson27.hw;

import java.util.Objects;

public class Order {
    private static long id=0;
    private int price;
    private String currency;
    private String itemName;
    private String shopIdentificator;

    public Order(int price, String currency, String itemName, String shopIdentificator) {
        this.price = price;
        this.currency = currency;
        this.itemName = itemName;
        this.shopIdentificator = shopIdentificator;
        id++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return price == order.price &&
                Objects.equals(currency, order.currency) &&
                Objects.equals(itemName, order.itemName) &&
                Objects.equals(shopIdentificator, order.shopIdentificator);
    }

    @Override
    public int hashCode() {

        return Objects.hash(price, currency, itemName, shopIdentificator);
    }

    @Override
    public String toString() {
        return "Order{" +
                "price=" + price +
                ", currency='" + currency + '\'' +
                ", itemName='" + itemName + '\'' +
                ", shopIdentificator='" + shopIdentificator + '\'' +
                '}';
    }

    public static long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getShopIdentificator() {
        return shopIdentificator;
    }

    public void setShopIdentificator(String shopIdentificator) {
        this.shopIdentificator = shopIdentificator;
    }
}

package dev.sda.team2.pma.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_to_quotation")
public class ItemToQuotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "itemName", nullable = false)
    private String itemName;

    @Column(name = "quantity", nullable = false)
    private double quantity;

    @Column(name = "salesPrice", precision = 10, scale = 2)
    private BigDecimal salesPrice;

    @Column(name = "purchasePrice", precision = 10, scale = 2)
    private BigDecimal purchasePrice;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "quotationId")
    private Quotation quotation;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "itemId")
    private Item item;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "vatId")
    private VATValue vatValue;

    public ItemToQuotation() {
    }

    public ItemToQuotation(String itemName, double quantity, BigDecimal salesPrice, BigDecimal purchasePrice,
                           Quotation quotation, Item item, VATValue vatValue) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.salesPrice = salesPrice;
        this.purchasePrice = purchasePrice;
        this.quotation = quotation;
        this.item = item;
        this.vatValue = vatValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public VATValue getVatValue() {
        return vatValue;
    }

    public void setVatValue(VATValue vatValue) {
        this.vatValue = vatValue;
    }

    @Override
    public String toString() {
        return "ItemToQuotation{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", salesPrice=" + salesPrice +
                ", purchasePrice=" + purchasePrice +
                ", quotation=" + quotation +
                ", item=" + item +
                ", vatValue=" + vatValue +
                '}';
    }
}

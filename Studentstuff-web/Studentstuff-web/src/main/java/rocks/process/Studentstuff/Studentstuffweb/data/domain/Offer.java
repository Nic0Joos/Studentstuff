package rocks.process.Studentstuff.Studentstuffweb.data.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Offer {

    @Id
    @GeneratedValue
    private Long OfferId;
    @ManyToOne
    private Seller seller;
    private String ItemName;
    private Long price;
    private String description;
    private byte[] picture;
    /*@Temporal
    private Date date;*/


    public Long getId() {
        return OfferId;
    }

    public void setId(Long id) {
        this.OfferId = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setProvider(Seller seller) {
        this.seller = seller;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
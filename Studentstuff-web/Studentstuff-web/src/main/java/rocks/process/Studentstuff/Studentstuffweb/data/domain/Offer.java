package rocks.process.Studentstuff.Studentstuffweb.data.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Offer {

    @Id
    @GeneratedValue
    private Long OfferId;
    @ManyToOne
    private Customer seller;
    private String name;
    private String price;
    private String description;
    private byte[] files;


    public Long getId() {
        return OfferId;
    }

    public void setId(Long id) {
        this.OfferId = id;
    }

    public Customer getSeller() {
        return seller;
    }

    public void setProvider(Customer seller) {
        this.seller = seller;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getFiles() {
        return files;
    }

    public void setFiles(byte[] files) {
        this.files = files;
    }
}
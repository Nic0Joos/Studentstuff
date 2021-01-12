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
    private Customer provider;
    private String name;
    private String price;
    private String description;
    private byte[] files;
    private boolean open;


    public Long getOfferId() {
        return OfferId;
    }

    public void setOfferId(Long offerId) {
        OfferId = offerId;
    }

    public Customer getSeller() {
        return provider;
    }

    public void setProvider(Customer provider) {
        this.provider = provider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
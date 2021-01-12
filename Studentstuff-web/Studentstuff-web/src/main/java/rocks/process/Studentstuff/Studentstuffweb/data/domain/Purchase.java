package rocks.process.Studentstuff.Studentstuffweb.data.domain;


import javax.persistence.*;

@Entity
public class Purchase{

    @Id
    @GeneratedValue
    private Long PurchaseID;
    private String name;
    @ManyToOne
    private Customer buyer;
    @OneToOne
    private Long offerID;

    public Long getId() {
        return PurchaseID;
    }

    public void setId(Long id) {
        this.PurchaseID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    public Long getOfferID() {
        return offerID;
    }

    public void setOfferID(Long offerID) {
        this.offerID = offerID;
    }
}
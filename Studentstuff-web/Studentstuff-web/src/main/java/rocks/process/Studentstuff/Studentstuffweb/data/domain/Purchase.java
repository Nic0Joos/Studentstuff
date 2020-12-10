package rocks.process.Studentstuff.Studentstuffweb.data.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Purchase{

    @Id
    @GeneratedValue
    private Long PurchId;
    @ManyToOne
    private Customer buyer;
    @OneToOne
    private Offer offer;

    public Long getId() {
        return PurchId;
    }

    public void setId(Long id) {
        this.PurchId = id;
    }

    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
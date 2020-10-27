package.com.Studentstuff.data.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Offer{

    @Id
    @GeneratedValue
    private Long id;
    private String ItemName;
    private long price;
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return ItemName;
    }

    public void setName(String name) {
        this.name = ItemName;
    }

    public int getPrice() {return price;}

    public void setPrice(long price) {this.price = price;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
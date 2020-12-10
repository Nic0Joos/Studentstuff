package rocks.process.Studentstuff.Studentstuffweb.data.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Seller {

    @Id
    @GeneratedValue
    private Long SellerId;
    private String companyname;
    @Email(message = "Please provide a valid e-mail.")
    @NotEmpty(message = "Please provide an e-mail.")
    private String email;
    private String mobile;


    public Long getId() {
        return SellerId;
    }

    public void setId(Long id) {
        this.SellerId = id;
    }

    public String getName() {
        return companyname;
    }

    public void setName(String name) {
        this.companyname = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {this.mobile = mobile;}

}
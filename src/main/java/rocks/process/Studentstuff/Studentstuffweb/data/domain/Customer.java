package rocks.process.Studentstuff.Studentstuffweb.data.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long CustId;
    private String name;
    @Email(message = "Please provide a valid e-mail.")
    @NotEmpty(message = "Please provide an e-mail.")
    private String email;
    private String mobile;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // only create object property from JSON
    private String password;
    @Transient // will not be stored in DB
    private String remember;


    public Long getId() {
        return CustId;
    }

    public void setId(Long id) {
        this.CustId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        String transientPassword = this.password;
        this.password = null;
        return transientPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

}
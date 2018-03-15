package models;

import javax.persistence.*;
import java.util.Set;

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String Name ;
    private String phone_number ;
    private String address ;
    private Set<Cakes> cakes;


    public Client(){}

    public Client(String Name, String phone_number, String address) {
        this.Name = Name;
        this.phone_number = phone_number;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    public Set<Cakes> getCakes() {
        return cakes;
    }

    public void setCakes(Set<Cakes> cakes) {
        this.cakes = cakes;
    }

    @Override
    public String toString() {
        String result = String.format("Category[id=%d, Name='%a',phone_number='%s',  address='%a']%n", id,  Name,phone_number, address);
        if (cakes != null) {
            for(Cakes s : cakes) {
                result += String.format("Cakes[cakes_id=%d, cakes_name='%s', cakes_bagasy='%g',srok_g='%y']%n", cakes.getCakes(), cakes.getCakes_name(), cakes.getCakes_bagasy(), cakes.getsrok_g());
            }
        }

        return result;
    }


    public String getphone_number() {
        return phone_number;
    }

    public void setphone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}


package com.tsel.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static java.lang.String.format;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 2420098241339270710L;

    @Id
    private Integer id;

    @Column(name = "full_name", nullable = false, length = 40)
    private String fullName;

    @Column(name = "phone", length = 12)
    private String phone;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "registration_date")
    private Long registrationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Long registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(fullName, customer.fullName) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(registrationDate, customer.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, phone, address, registrationDate);
    }

    @Override
    public String toString() {
        return "[" + id + ", " + fullName + ", " + phone + ", " + address + ", " + registrationDate + "]";
    }
}

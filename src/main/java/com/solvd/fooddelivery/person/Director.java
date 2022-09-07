package com.solvd.fooddelivery.person;

import com.solvd.fooddelivery.parser.LocalDateAdapter;
import com.solvd.fooddelivery.vehicle.Car;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "director")
@XmlType(propOrder = {"firstName", "lastName", "dateOfBirth", "car", "id"})
public class Director {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Car car;
    private long id;

    @XmlElement
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @XmlAttribute(name = "first")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "last")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name = "date-of-birth")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @XmlElement
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Director{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", id=").append(id);
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}

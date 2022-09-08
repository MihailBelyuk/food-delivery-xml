package com.solvd.fooddelivery.restaurant;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "dish")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name", "price", "ingredients", "prepareTimeMinutes", "spicy"})
public class Dish {

    @XmlElement
    private String name;
    @XmlElement
    private BigDecimal price;
    @XmlElementWrapper(name = "ingredient-list")
    @XmlElement(name = "ingredient")
    private List<String> ingredients;
    @XmlElement(name = "prepare-minutes")
    private int prepareTimeMinutes;
    @XmlElement(name = "spicy")
    private boolean spicy;

    public int getPrepareTimeMinutes() {
        return prepareTimeMinutes;
    }

    public void setPrepareTimeMinutes(int prepareTimeMinutes) {
        this.prepareTimeMinutes = prepareTimeMinutes;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dish{");
        sb.append("name='").append(name).append('\'');
        sb.append(", ingredients=").append(ingredients);
        sb.append(", prepareTimeMinutes=").append(prepareTimeMinutes);
        sb.append(", spicy=").append(spicy);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}

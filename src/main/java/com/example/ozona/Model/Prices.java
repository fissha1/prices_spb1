package com.example.ozona.Model;

/* Entity Prices */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Prices")
public class Prices {

    private long id;
    private String Brand_id;
    private String Start_date;
    private String End_date;
    private String Product_id;
    private String Price_list;
    private String Priority;
    private String Price;
    private String Curr;

    public Prices() {

    }

    public Prices(String Brand_id, String Start_date, String End_date, String Product_id, String Price_list, String Priority, String Price, String Curr) {
        this.Brand_id = Brand_id;
        this.Start_date = Start_date;
        this.End_date = End_date;
        this.Product_id = Product_id;
        this.Price_list = Price_list;
        this.Priority = Priority;
        this.Price = Price;
        this.Curr = Curr;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "Brand_id", nullable = false)
    public String getBrand_id() {
        return Brand_id;
    }
    public void setBrand_id(String Brand_id) {
        this.Brand_id = Brand_id;
    }
    @Column(name = "Start_date", nullable = false)
    public String getStart_date() {
        return Start_date;
    }
    public void setStart_date(String Start_date) {
        this.Start_date = Start_date;
    }
    @Column(name = "End_date", nullable = false)
    public String getEnd_date() {
        return End_date;
    }
    public void setEnd_date(String End_date) {
        this.End_date = End_date;
    }
    @Column(name = "Product_id", nullable = false)
    public String getProduct_id() {
        return Product_id;
    }
    public void setProduct_id(String Product_id) {
        this.Product_id = Product_id;
    }
    @Column(name = "Price_list", nullable = false)
    public String getPrice_list() {
        return Price_list;
    }
    public void setPrice_list(String Price_list) {
        this.Price_list = Price_list;
    }
    @Column(name = "Priority", nullable = false)
    public String getPriority() {
        return Priority;
    }
    public void setPriority(String Priority) {
        this.Priority = Priority;
    }
    @Column(name = "Price", nullable = false)
    public String getPrice() {
        return Price;
    }
    public void setPrice(String Price) {
        this.Price = Price;
    }
    @Column(name = "Curr", nullable = false)
    public String getCurr() {
        return Curr;
    }
    public void setCurr(String Curr) {
        this.Curr = Curr;
    }
}

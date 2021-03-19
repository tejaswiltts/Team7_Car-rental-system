package com.ltts.carrental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Product {
    private long id;
    private String name;
    private String cname;
    private String ctype;
    private float price;
    private String rnum;
    private int year;
    private String color;
    

    
    public Product() {
		
	}

	
	  @Id
	 /* 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
    public long getId() {
        return id;
    }
    public void setId(long id) {
		this.id = id;
	}
   
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCtype() {
		return ctype;
	}


	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	

}
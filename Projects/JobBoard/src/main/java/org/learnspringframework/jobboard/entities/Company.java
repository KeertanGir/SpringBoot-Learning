package org.learnspringframework.jobboard.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(name = "company_site")
    private String companySite;



//    Some Info about Entity Constructor

    /***
     * Simple rule
     * No-args constructor: Hibernate/JPA ke liye
     * Parameterized constructor: Apne application code ke liye
     * All-args constructor: Har field ki value manually dene ke liye, lekin entities mein hamesha best choice nahi hota
     */


//    Hibernate use krna hy isko taky woh eik object bana sake and data ko set karne ke liye use kar sake geeters and setters ko
//   Always protected rakhna Chaheya Taky ko bhi unwanted data Galti hy enter na hojae.
//    Aur hum isko public bhi rakh saghte hain.
    protected Company(){}

//    rule of thumb the hame constructor main Id nhi pass krni chaheya woh database main Khud b khud generate hojae ghi
    public Company( String name, String description, String companySite) {

        this.name = name;
        this.description = description;
        this.companySite = companySite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanySite() {
        return companySite;
    }

    public void setCompanySite(String companySite) {
        this.companySite = companySite;
    }
}

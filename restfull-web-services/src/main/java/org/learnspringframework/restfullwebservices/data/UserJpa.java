package org.learnspringframework.restfullwebservices.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

//@JsonIgnoreProperties({"id","birthdate"}) // static Filtering
@Entity
@Table(name = "Users")
public class UserJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "Size Should be grater than 2")
    private String name;

    @Past(message = "Birth-date Should be Past")
    private LocalDate birthdate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Posts> usesPosts;

    public UserJpa(Long id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public UserJpa() {}

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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<Posts> getUsesPosts() {
        return usesPosts;
    }

    public void setUsesPosts(List<Posts> usesPosts) {
        this.usesPosts = usesPosts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}

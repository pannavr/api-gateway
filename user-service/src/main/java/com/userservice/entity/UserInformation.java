package com.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user_information", schema = "db_user_management")
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "active")
    private Integer active;

    @OneToMany(mappedBy = "userInformation", cascade = CascadeType.ALL)
    private Collection<UserAccount> userAccounts;

    public UserInformation( String fullName, String email, Date birthDate, String gender, Date createDate, Date modifiedDate, Integer active) {
        this.fullName = fullName;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.active = active;
    }
}

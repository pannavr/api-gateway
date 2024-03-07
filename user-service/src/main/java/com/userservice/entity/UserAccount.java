package com.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user_account", schema = "db_user_management")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "active")
    private Integer active;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserInformation userInformation;

    public UserAccount(String userName, String password, Date createDate, Date modifiedDate, Integer active, UserInformation userInformation) {
        this.userName = userName;
        this.password = password;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.active = active;
        this.userInformation = userInformation;
    }
}

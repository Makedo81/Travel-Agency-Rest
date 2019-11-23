package com.rest.travelagency.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@org.hibernate.annotations.NamedQuery(
        name = "User.findByLoginAndPassword",
        query = "From User where login = :LOGIN and password = :PASSWORD "
)
@org.hibernate.annotations.NamedQuery(
        name = "User.findByLogin",
        query = "From User where login = :LOGIN"
)
@org.hibernate.annotations.NamedQuery(
        name = "User.findByPassword",
        query = "From User where password = :PASSWORD"
)
@org.hibernate.annotations.NamedQuery(
        name = "User.checkUserStatus",
        query = "From User where password = :PASS "
)
@org.hibernate.annotations.NamedQuery(
        name = "User.findUserByEmail",
        query = "From User where email = :EMAIL "
)

@NamedNativeQuery(
        name = "User.delete",
        query = "Delete From USERS where USER_ID = :ID ",
        resultClass = User.class
)

@NamedNativeQuery(
        name = "User.deleteByEmail",
        query = "Delete From USERS where EMAIL = :EMAIL ",
        resultClass = User.class
)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private Long phoneNumber;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "IS_SIGN_IN")
    private boolean isSignIn;

    @OneToMany
            (
                    targetEntity = Booking.class,
                    mappedBy = "user",
                    cascade = CascadeType.REMOVE,
                    orphanRemoval = true,
                    fetch = FetchType.EAGER
            )
    private List<Booking> bookings = new ArrayList<>();

//    public User(String firstname, String lastname, String email, Long phoneNumber, String login, String password, boolean isSignIn) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.login = login;
//        this.password = password;
//        this.isSignIn = isSignIn;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!firstname.equals(user.firstname)) return false;
        if (!lastname.equals(user.lastname)) return false;
        if (!email.equals(user.email)) return false;
        if (!login.equals(user.login)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}

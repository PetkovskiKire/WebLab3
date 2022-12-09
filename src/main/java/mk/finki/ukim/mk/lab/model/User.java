package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "shop_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    @Convert( converter = UserFullnameConverter.class)
    private UserFullname fullname;
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ShoppingCart> carts;

    public User(String username, UserFullname userFullname, String password, LocalDate dateOfBirth, List<ShoppingCart> carts) {
        this.username = username;
        this.fullname = userFullname;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.carts = carts;
    }

    public User() {

    }

    public User(String username) {
    }
}

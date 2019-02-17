package lesson35.model;

import lesson35.repository.PropertyRepository;
import lesson35.service.Loaders;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;



    public User(long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public User(String userName, String password, String country, UserType userType) {
        this(Loaders.getMapObjectIds().get("idUser"), userName, password, country, userType);
        PropertyRepository.incrementIdsAndLoadToFile("idUser");
    }


    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.userName.equals(user.userName) &&
                this.country.equals(user.country) &&
                this.userType.equals(user.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, country, userType);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", country='" + country + '\'' +
                ", userType=" + userType +
                '}';
    }
}

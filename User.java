import java.util.ArrayList;

public class User<CreditCard> {
    private String username;
    private String password;
    private String name;
    private String email;
    private String homeAddress;
    private ArrayList creditCards = new ArrayList();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public ArrayList getCreditCards() {
        ArrayList creditCards = this.creditCards;
        return creditCards;
    }

    void addCreditCard(CreditCard creditCard) {
    }
}

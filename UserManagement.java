import java.util.HashMap;
import java.util.Map;

public class UserManagement {
    private Map<String, User> users = new HashMap<>();

    public void createUser(String username, String password, String name, String email, String address, String homeAddress) {
        User user = new User(username, password);
        user.setName(name);
        user.setEmail(email);
        user.setHomeAddress(homeAddress);
        users.put(username, user);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void updateUser(String username, String name, String address, String homeAddress) {
        User user = users.get(username);
        user.setName(name);
        user.setHomeAddress(homeAddress);
    }

    public void createCreditCard(String username, String cardNumber, String expirationDate, String cvv) {
        User user = users.get(username);
        CreditCard creditCard = new CreditCard(cardNumber, expirationDate, cvv);
        user.addCreditCard(creditCard);
    }
}
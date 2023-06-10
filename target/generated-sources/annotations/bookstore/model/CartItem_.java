package bookstore.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CartItem.class)
public abstract class CartItem_ {

	public static volatile SingularAttribute<CartItem, Integer> quantity;
	public static volatile SingularAttribute<CartItem, Double> totalPrice;
	public static volatile SingularAttribute<CartItem, Book> book;
	public static volatile SingularAttribute<CartItem, ShoppingCart> shoppingCart;
	public static volatile SingularAttribute<CartItem, Long> id;
	public static volatile SingularAttribute<CartItem, User> user;

	public static final String QUANTITY = "quantity";
	public static final String TOTAL_PRICE = "totalPrice";
	public static final String BOOK = "book";
	public static final String SHOPPING_CART = "shoppingCart";
	public static final String ID = "id";
	public static final String USER = "user";

}


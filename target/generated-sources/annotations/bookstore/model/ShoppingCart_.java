package bookstore.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ShoppingCart.class)
public abstract class ShoppingCart_ {

	public static volatile SingularAttribute<ShoppingCart, Long> id;
	public static volatile SetAttribute<ShoppingCart, CartItem> cartItems;

	public static final String ID = "id";
	public static final String CART_ITEMS = "cartItems";

}


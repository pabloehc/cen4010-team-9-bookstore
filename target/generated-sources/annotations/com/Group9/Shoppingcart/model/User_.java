package com.Group9.Shoppingcart.model;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile ListAttribute<User, Book> userBooks;
	public static volatile SingularAttribute<User, String> username;

	public static final String PASSWORD = "password";
	public static final String ID = "id";
	public static final String USER_BOOKS = "userBooks";
	public static final String USERNAME = "username";

}


package bookstore.model;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile ListAttribute<Book, Book> books;
	public static volatile SingularAttribute<Book, String> ISBN;
	public static volatile SingularAttribute<Book, Double> price;
	public static volatile SingularAttribute<Book, String> author;
	public static volatile SingularAttribute<Book, String> name;
	public static volatile SingularAttribute<Book, String> genre;
	public static volatile SingularAttribute<Book, String> description;
	public static volatile SingularAttribute<Book, String> publisher;
	public static volatile SingularAttribute<Book, Integer> yearPublished;
	public static volatile SingularAttribute<Book, Long> id;
	public static volatile SingularAttribute<Book, Integer> copiesSold;

	public static final String BOOKS = "books";
	public static final String I_SB_N = "ISBN";
	public static final String PRICE = "price";
	public static final String AUTHOR = "author";
	public static final String NAME = "name";
	public static final String GENRE = "genre";
	public static final String DESCRIPTION = "description";
	public static final String PUBLISHER = "publisher";
	public static final String YEAR_PUBLISHED = "yearPublished";
	public static final String ID = "id";
	public static final String COPIES_SOLD = "copiesSold";

}


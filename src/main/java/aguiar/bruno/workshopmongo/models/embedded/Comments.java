package aguiar.bruno.workshopmongo.models.embedded;

import java.time.Instant;

public class Comments {
	private String text;
	private Instant moment;

	private Author author;

public Comments() {}

public Comments(String text, Instant moment, Author author) {
	super();
	this.text = text;
	this.moment = moment;
	this.author = author;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public Instant getMoment() {
	return moment;
}

public void setMoment(Instant moment) {
	this.moment = moment;
}

public Author getAuthor() {
	return author;
}

public void setAuthor(Author author) {
	this.author = author;
}


}

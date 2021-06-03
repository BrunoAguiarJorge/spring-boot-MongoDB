package aguiar.bruno.workshopmongo.models.embedded;

import aguiar.bruno.workshopmongo.models.entities.User;

public class Author {
	private String id;
	private String name;
	
	
	public Author(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Author() {}
	
	public Author(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}

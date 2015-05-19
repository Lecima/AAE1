package observer;

public class Message {
	private Publisher publisher;
	private Category category;
	private String message;
	
	public Message(Publisher publisher, Category category, String message) {
		super();
		this.publisher = publisher;
		this.category = category;
		this.message = message;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return this.message;
	}
}

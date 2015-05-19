package observer;

public abstract class AbstractPubSub {
	private String name;
	private Message lastMessage;
	
	public Message getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(Message lastMessage) {
		this.lastMessage = lastMessage;
	}

	public AbstractPubSub(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

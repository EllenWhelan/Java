import java.util.ArrayList;

public class Topic {
	String name;
	ArrayList<Subscriber> subscriberList;
	
	
	Topic(String name){
		this.name=name;
		this.subscriberList = new ArrayList<Subscriber>();
		
	}
	
	//method to add a subscriber to a topic
	void addSubscriber(int subscriber) {
		int subscriberExistence = findSubscriber(subscriber);
		if(subscriberExistence !=0) subscriberList.add(getSub(subscriber));
	}
	
	//method to delete a subscriber from a topic
	void deleteSubscriber(int subscriber) {
		int subscriberExistence = findSubscriber(subscriber);
		if(subscriberExistence !=0) subscriberList.remove(subscriber);
	}
	
	//method to check if a subscriber is subscribed to this topic
	int findSubscriber(int subscriber) {
		int i=0;
		boolean found = false;
		while(i<subscriberList.size() && !found){
			if(subscriberList.get(i).portNumber == subscriber) found = true;
			else i++;
		}
		if(i>= subscriberList.size()) return subscriber;
		else return 0;
	}
	
	Subscriber getSub (int index) {
		if(subscriberList.get(index) !=null) return subscriberList.get(index);
		return null;
		
	}
	
}

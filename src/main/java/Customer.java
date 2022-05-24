import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private int numItems;
    private int simTime;
    private int timeEntered;
    private int timeExit;
    private int timeStart;
    private int startingItems;

    public Customer(int items, int entered) {

        numItems = items;
        timeEntered = entered;
        startingItems = items;
    }

}

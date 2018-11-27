import java.util.ArrayList;
import java.util.List;

public class MobileMain {
    public static void main(String[] args) {
        Network network = new Network();
        Phone phone1 = new Phone(12, "Nokia 1110");
        Phone phone2 = new Phone(14, "Nokia 1010");

        phone1.register(network);
        phone2.register(network);

        phone1.call(14);
        phone1.call(15);
    }




}

class Network{
    private List<Integer> registeredNumbers = new ArrayList<>();

    public void register(Phone phone){

        registeredNumbers.add(phone.getNumber());
    }

    public boolean isRegistered(int number){

        return registeredNumbers.contains(number) ? true : false;
    }
}

class Phone{
    private int number;
    private String model;
    private Network network;

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public void register(Network network){
        this.network = network;
        network.register(this);
    }

    public void call (int number){
        if (network.isRegistered(number)){
            System.out.println("Calling to: " + number);
        } else System.out.println("The number " + number + " is not registered");
    }
}
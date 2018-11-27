public class Cat {
    private String name;
    private int age;
    private int weight;

    public Cat(String name, int age, int weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public int getWeight(){
        return weight;
    }

    public void goSleep(){
        this.weight++;
        System.out.println("Zzz..");
    }

    public void goEat(){
        this.weight++;
    }

    public String  toString(){
        return ("Name: " + name + "\nAge: " + age + "\n Weight: " + weight);
    }
}

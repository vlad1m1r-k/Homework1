package immutableTest;

import java.util.Arrays;

//public final class ImmutableClass {     //Implement rule 3
public class ImmutableClass {
    int imField1;
    //private final int imField1;       //Implement rule 2
    int [] mutField;
    //private final int [] mutField;    //Implement rule 2

    public ImmutableClass(int imField1, int[] mutField) {
        this.imField1 = imField1;
        this.mutField = mutField;
        //this.mutField = mutField.clone();   //Implement rule 4 for constructor
    }

    public int getImField1() {
        return imField1;
    }

    public void setImField1(int imField1) { //Comment to meet rule 1
        this.imField1 = imField1;
    }

    public int[] getMutableField() {
        return mutField;
        //return mutField.clone();                    //Implement rule 4 for getter
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "imField1=" + imField1 +
                ", mutField=" + Arrays.toString(mutField) +
                '}';
    }
}

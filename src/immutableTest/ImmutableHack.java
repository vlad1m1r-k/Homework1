/*
https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
Immutable objects rules:
1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
2. Make all fields final and private.
3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final. A more sophisticated approach is to make the constructor private and construct instances in factory methods.
4. If the instance fields include references to mutable objects, don't allow those objects to be changed:
        Don't provide methods that modify the mutable objects.
        Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor; if necessary, create copies, and store references to the copies. Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.
*/


package immutableTest;

import java.util.Arrays;

public class ImmutableHack {
    private ImmutableClass imClass;

    public void setImClass(ImmutableClass imClass) {
        this.imClass = imClass;
    }

    public void rule1Test(){
        System.out.println("Rule 1 Test:");
        System.out.println(imClass);
        imClass.setImField1(23);
        System.out.println(imClass);
        System.out.println();
    }

    public void rule2Test(){
        System.out.println("Rule 2 Test:");
        System.out.println(imClass);
        imClass.imField1 = 2;
        System.out.println(imClass);
        System.out.println();
    }

    public void rule3Test(){
        System.out.println("Rule 3 Test:");

        class ImmutableChild extends ImmutableClass{
            private int imField1;
            public ImmutableChild(int imField1, int[] mutField) {
                super(imField1, mutField);
                this.imField1 = imField1;
            }

            @Override
            public int getImField1() {
                return imField1;
            }

            public void setImField1(int imField1) {
                this.imField1 = imField1;
            }

            @Override
            public String toString() {
                return "ImmutableClass{" +
                        "imField1=" + imField1 + ", mutField=" + Arrays.toString(super.getMutableField()) + '}';
            }
        }

        ImmutableChild chield = new ImmutableChild(2, new int[] {2,2});
        ImmutableClass immutable = (ImmutableClass)chield;
        System.out.println(immutable);
        chield.setImField1(3);
        System.out.println(immutable);
        System.out.println();
    }

    public void rule4Test(int [] mutableObject){
        System.out.println("Rule 4 Test:");
        System.out.println(imClass);
        mutableObject[0] = 2;     //constructor test
        mutableObject[1] = 2;

        int[] getterReference = imClass.getMutableField();
        getterReference[0] = 3;  //Getter test
        getterReference[1] = 3;
        System.out.println(imClass);
    }

    public static void main(String[] args) {
        int [] mutableObject = new int[] {1,1};
        ImmutableClass imClass = new ImmutableClass(1, mutableObject);
        ImmutableHack imHack = new ImmutableHack();
        imHack.setImClass(imClass);

        imHack.rule1Test();
        imHack.rule2Test();
        imHack.rule3Test();
        imHack.rule4Test(mutableObject);
    }
}

package immutableTestTest;

import immutableTest.ImmutableClass;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableClassTest {
    private ImmutableClass immutableClass;
    private int imField = 1;
    private int[] mutableField = new int[] {1,1};
    @Before
    public void init(){
        immutableClass = new ImmutableClass(imField, mutableField);
    }

    @Test
    public void rule1Test() {
        immutableClass.setImField1(2);
        assertEquals(imField, immutableClass.getImField1());
    }

    @Test
    public void rule2Test(){
        immutableClass.setImField1(2);
        assertEquals(imField, immutableClass.getImField1());
    }

    @Test
    public void rule3Test(){
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
        chield.setImField1(3);
        assertEquals(2, immutable.getImField1());
    }

    @Test
    public void rule4ConstructorTest(){
        mutableField[0] = 2;
        mutableField[1] = 2;
        assertArrayEquals(new int[] {1,1}, immutableClass.getMutableField());
    }

    @Test
    public void rule4GetterTest(){
        int [] tempArray = immutableClass.getMutableField();
        tempArray[0] = 2;
        tempArray[1] = 2;
        assertArrayEquals(new int[] {1,1}, immutableClass.getMutableField());
    }
}
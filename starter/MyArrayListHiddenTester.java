/**
 * 
 * Name: Jack Zhang
 * ID: A16137823
 * Email: hoz006@ucsd.edu
 * Source Used: Lecture slides, Zybook, oracle help center
 * 
 * A JUnit test class to test whether MyArrayList.java is implemented correctly
 * This includes tester for constructor, append, prepend, etc.
 */

 //IMPORTANT: Do not change the headers!

 
import static org.junit.Assert.*;
import org.junit.*;


public class MyArrayListHiddenTester {

    static final int DEFAULT_CAPACITY = 5;
    static final int MY_CAPACITY = 3;
    static final int MAX_CAPACITY = 10;
    static final int LARGE_CAPACITY = 9;

    static final int CONS_INVALID_ARG = -1;
    static final int EXPAND_SMALL_VAL = 1;

    Object[] arr = new Object[10];
    Integer[] arrInts = { 1, 2, 3 };
    E[] nullArg = null;
    E nullElement = null;
    E testElement = Integer(1);

    private MyArrayList listEmpty, listDefaultCap, listMaxCap, listCustomCapacity, 
                        listWithNull, listWithInt;


    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test */
    @Before
    public void setUp() throws Exception {
        listEmpty = new MyArrayList();
        listDefaultCap = new MyArrayList(DEFAULT_CAPACITY);
        listMaxCap = new MyArrayList(MAX_CAPACITY);
        listCustomCapacity = new MyArrayList(MY_CAPACITY);
        listWithNull = new MyArrayList(arr);
        listWithInt = new MyArrayList<Integer>(arrInts);
    }

    /**
     * Aims to test the capacity argument constructor when the input
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        boolean exceptionThrown = false;
        try {
            MyArrayList argTest = new MyArrayList(CONS_INVALID_ARG);
        } catch (IllegalArgumentException exception) {
            exceptionThrown = true;
        }
        assertTrue("Invalid Argument passed into constructor. Illegal argument exception detected", exceptionThrown);
    }

    /**
     * Aims to test the Array argument constructor when the input
     * is null
     */
    @Test
    public void testConstructorNullArg(){
        MyArrayList argTest2 = new MyArrayList(nullArg);
        assertEquals("Testing Null Argument Constructor", DEFAULT_CAPACITY, argTest2.size);
    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
        boolean exceptionThrown = false;
        try{
            listMaxCap.append(testElement);
        } catch(IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue("Testing append at capacity", exceptionThrown);
    }

    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        boolean exceptionThrown = false;
        /*
        try{
            listEmpty.prepend(nullArg);
        } catch() {
            exceptionThrown = true；
        }*/
        //TODO: What should happen if I prepend a null?
        assertTrue("Testing prepend for null element", exceptionThrown);
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBound(){
        boolean exceptionThrown = false;
        try{
            listMaxCap.insert(MAX_CAPACITY, testElement);
        } catch(IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue("Testing insert out of bound", exceptionThrown);
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        //TODO: What does multiple mean?
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound(){
        boolean exceptionThrown = false;
        try{
            listMaxCap.get(MAX_CAPACITY);
        } catch(IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue("Testing get out of bound", exceptionThrown);
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound(){
        boolean exceptionThrown = false;
        try{
            listMaxCap.set(MAX_CAPACITY, testElement);
        } catch(IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue("Testing set out of bound", exceptionThrown);
    }


    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound(){
        boolean exceptionThrown = false;
        try{
            listMaxCap.remove(MAX_CAPACITY);
        } catch(IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue("Testing remove out of bound", exceptionThrown);
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
        boolean exceptionThrown = false;
        try{
            listDefaultCap.expandCapacity(EXPAND_SMALL_VAL);
        } catch(IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Testing expand to a smaller value", exceptionThrown);
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than double(2x) the current capacity
     */
    @Test
    public void testExpandCapacityExplode(){
        listCustomCapacity.expandCapacity(LARGE_CAPACITY);
        assertEquals("Testing expand capacity explode", 
                    LARGE_CAPACITY, listCustomCapacity.getCapacity());
    }

}

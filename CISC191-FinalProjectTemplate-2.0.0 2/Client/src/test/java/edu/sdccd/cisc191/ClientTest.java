package edu.sdccd.cisc191;

import org.junit.jupiter.api.Test;
import edu.sdccd.cisc191.template.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {
    @Test
    void test2DSnackArray() {
        //test if dessert is able to maneuver between rows of 2d array - getFirst() method calls from row 0 and row 1
        Dessert dessert = new Dessert();
        String dessertLine = dessert.getFirst();
        assertEquals(dessertLine, "Have some Nutella on White Bread");
    }
    @Test
    void testGUI() {
        //Can the app launch?
    }
    @Test
    void testTimeConversion() {
        //tests functionality of conversion methods in class Time
        Time time = new Time();
        time.setSecondsTotal(1);
        assertEquals(time.getSecondsTotal(), 60);
    }
    @Test
    void testAbstractClass() {
        //test if sandwich recognizes method built off of abstract parent - getDrink() is built off abstract class Snack
        Sandwich sandwich = new Sandwich();
        String sandwichLine = sandwich.getFirst();
        assertEquals(sandwichLine, "Make a sandwich with: White Bread, Salami\nand Cream Cheese");
    }
    @Test
    void testInterfaceUrgent() {
        //test if homework reacts as if it implements interface Urgent's property
        Homework homework = new Homework("","", true, "");
        assertEquals("*\n", homework.isUrgent());
    }

    @Test
    void testNetwork() throws IOException, ClassNotFoundException {
        //test if client can connect to and read a response from server
        Socket clientSocket = new Socket("localhost", 8000);
        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
        String response = (String) in.readObject();
        clientSocket.close();
        assertEquals("Sleep is for the weak", response);
    }
    @Test
    void testDrinkTreeInsertAndGet() {
        //test if drink binary tree is capable of dynamically adding values

        DrinkTree drinkTree = new DrinkTree();
        drinkTree.insertDrink("Boba Tea");
        String drink = drinkTree.getDrink();
        assertEquals("Boba Tea", drink);

        //test if drink binary tree is capable of searching for a value from a tree based on a qualification and returning it
        drinkTree.insertDrink("Fruit Tea");
        drink = drinkTree.getDrink();
        assertEquals("Fruit Tea", drink);
    }

}

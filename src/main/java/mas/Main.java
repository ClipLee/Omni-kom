package mas;

import mas.Models.*;
import mas.View.WelcomeWindow;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static List<Member> userList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        readFromFiles();

        System.out.println("hello to the system, current users:");
        userList.forEach(System.out::println);

        SwingUtilities.invokeLater(new WelcomeWindow());

        // writeToFiles();
    }

    /**
     *
     * Reads all of the system data from files
     */
    private static void readFromFiles() {
        try (FileInputStream fis = new FileInputStream("MemberData.dat");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            userList = (List<Member>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous member data, creating new test member.");
            userList.add(new Member(0, "test", "user", "testuser@example.com", LocalDate.of(2001, 12, 3)));
            userList.add(new Member(1, "younger", "user", "testuser@example.com", LocalDate.of(2008, 1, 5)));
            userList.get(1).getFriends().add(userList.get(0));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream("ProductData.dat");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            productList = (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous product data, creating new test product.");
            productList.add(new Game(0,"Test game 1", "Test game description",
                    100.0,
                    AgeRating.PEGI7,
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>()));
            productList.add(new Game(1,"Test game 2", "See, the description have changed",
                    80.0,
                    AgeRating.PEGI16,
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>()));
            productList.add(new Game(2,"Test game 3", "Yet another game",
                    120.0,
                    AgeRating.PEGI18,
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>()));

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Saves whole system data to files
     */
    public static void writeToFiles() {
        System.out.println("Saving system data before the exit");
        try (FileOutputStream fos = new FileOutputStream("MemberData.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream fos = new FileOutputStream("ProductData.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
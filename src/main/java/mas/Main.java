package mas;

import mas.Models.Member;
import mas.View.MainWindow;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Member> userList = new ArrayList<>();

    public static void main(String[] args) {
        readFromFiles();

        System.out.println("hello to the system, current users:");
        userList.forEach(System.out::println);

        SwingUtilities.invokeLater(new MainWindow());

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
            userList.add(new Member(0, "test", "user", "testuser@example.com"));
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
    }
}
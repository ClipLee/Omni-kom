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
    public static List<Genre> genresList = new ArrayList<>();
    public static List<Rating> ratingsList = new ArrayList<>();
    public static List<Achievement> achievementList = new ArrayList<>();
    public static List<Image> imageList = new ArrayList<>();
    public static List<Chat> chatList = new ArrayList<>();

    public static void main(String[] args) {
        readFromFiles();

        System.out.println("Welcome to the system, current users:");
        userList.forEach(System.out::println);

        SwingUtilities.invokeLater(new WelcomeWindow());
    }

    /**
     * Reads all of the system data from files
     */
    private static void readFromFiles() {
        boolean b = false;
        try (FileInputStream fis = new FileInputStream("Data/MemberData.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            userList = (List<Member>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous member data, creating new test member.");
            userList.add(new Member(0, "test", "user", "testuser@example.com", LocalDate.of(2001, 12, 3)));
            userList.add(new Member(1, "younger", "user", "testuser@example.com", LocalDate.of(2008, 1, 5)));
            userList.add(new Member(2, "1999", "user", "testuser@example.com", LocalDate.of(1999, 2, 23)));
            userList.get(1).getFriends().add(userList.get(0));
            userList.get(1).getFriends().add(userList.get(2));
            userList.get(2).getFriends().add(userList.get(1));
            userList.get(2).getFriends().add(userList.get(0));
            userList.get(1).setWalletBalance(200.0);
            userList.get(2).setWalletBalance(110.0);
            b = true;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream("Data/ProductData.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            productList = (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous product data, creating new test product.");
            productList.add(new Game(0, "Test game 1", "This game has PEGI 7 and costs 100 credits",
                    100.0,
                    AgeRating.PEGI7,
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>()));
            productList.add(new Game(1, "Test game 2", "See, the description have changed. This one is PEGI 16 AND its price is 80",
                    80.0,
                    AgeRating.PEGI16,
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>()));
            productList.add(new Game(2, "Test game 3", "Yet another game with PEGI 18 and price of 120",
                    120.0,
                    AgeRating.PEGI18,
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>()));

            b = true;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream("Data/GenreData.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            genresList = (List<Genre>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous genre data, creating new test genres.");
            genresList.add(new Genre(0, "Shooter"));
            genresList.add(new Genre(1, "RPG"));
            genresList.add(new Genre(2, "Platformer"));
            genresList.add(new Genre(3, "Strategy"));
            Game game1 = (Game) productList.get(0);
            game1.getGenres().add(genresList.get(0));
            Game game2 = (Game) productList.get(1);
            game2.getGenres().add(genresList.get(2));
            Game game3 = (Game) productList.get(2);
            game3.getGenres().add(genresList.get(1));
            b = true;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream("Data/RatingData.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            ratingsList = (List<Rating>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous rating data, creating new test rating.");
            ratingsList.add(new Rating(0, Rating.ProductRating.Star_5, "Good game", "Very good game, I recommend it.", userList.get(0), productList.get(0)));
            b = true;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream("Data/AchievementData.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            achievementList = (List<Achievement>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous achievement data, creating new test achievement.");
            achievementList.add(new Achievement(0, "Test Achievement", "No description", false, false, productList.get(0)));
            Achieving.achieve(0, userList.get(0), achievementList.get(0));
            b = true;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream("Data/ImageData.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            imageList = (List<Image>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous image data, creating new test image.");
            imageList.add(new Image(300, 300, "jpeg", "../Images/image.jpg"));
            productList.get(0).getScreenShots().add(imageList.get(0));
            b = true;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fis = new FileInputStream("Data/ChatData.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            chatList = (List<Chat>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous chat data, creating new test chat.");
            chatList.add(new Chat(0, "Chat 1", userList.get(0), new ArrayList<>()));
            b = true;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (b) {
            writeToFiles();
            System.exit(1);
        }
    }

    /**
     * Saves whole system data to files
     */
    public static void writeToFiles() {
        System.out.println("Saving system data before the exit");
        try (FileOutputStream fos = new FileOutputStream("Data/MemberData.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream fos = new FileOutputStream("Data/ProductData.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream fos = new FileOutputStream("Data/GenreData.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream fos = new FileOutputStream("Data/RatingData.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream fos = new FileOutputStream("Data/AchievementData.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream fos = new FileOutputStream("Data/ImageData.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream fos = new FileOutputStream("Data/ChatData.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
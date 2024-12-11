import java.util.Scanner;

public class Main {

    static class MusicStore {
        private String[] albums; // Array to store album names
        private double[] prices; // Array to store album prices
        private int albumCount;  // Variable to track the number of albums

        // Constructor to initialize the store with a certain size
        public MusicStore(int size) {
            albums = new String[size];
            prices = new double[size];
            albumCount = 0; // Start with no albums in the store
        }

        // Method to add a new album to the store
        public void addAlbum(String albumName, double price) {
            if (albumCount < albums.length) {
                albums[albumCount] = albumName; // Add the album name
                prices[albumCount] = price;     // Add the album price
                albumCount++;                   // Increase the album count
                System.out.println("Album added!");
            } else {
                System.out.println("Store is full.");
            }
        }

        // Method to display all albums in the store
        public void displayAlbums() {
            if (albumCount == 0) {
                System.out.println("No albums available.");
            } else {
                System.out.println("Available Albums:");
                // Loop through all albums and show their names and prices
                for (int i = 0; i < albumCount; i++) {
                    System.out.println((i + 1) + ". " + albums[i] + " - $" + prices[i]);
                }
            }
        }

        // Method to simulate purchasing an album
        public void purchaseAlbum(int albumNumber) {
            if (albumNumber > 0 && albumNumber <= albumCount) {
                System.out.println("You purchased: " + albums[albumNumber - 1]);
                System.out.println("Price: $" + prices[albumNumber - 1]);
            } else {
                System.out.println("Invalid album number.");
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicStore store = new MusicStore(5); // Create a store with space for 5 albums

        while (true) {
            System.out.println("\nMusic Store Menu:");
            System.out.println("1. Add Album");
            System.out.println("2. Display All Albums");
            System.out.println("3. Purchase Album");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Get album name and price from user input
                    System.out.print("Enter album name: ");
                    String albumName = scanner.nextLine();
                    System.out.print("Enter album price: ");
                    double price = scanner.nextDouble();
                    store.addAlbum(albumName, price); // Add the album to the store
                    break;
                case 2:
                    store.displayAlbums(); // Show the list of all albums
                    break;
                case 3:
                    // Ask the user to choose an album to purchase
                    System.out.print("Enter album number to purchase: ");
                    int albumNumber = scanner.nextInt();
                    store.purchaseAlbum(albumNumber); // Purchase the chosen album
                    break;
                case 4:
                    System.out.println("Exiting.... Thank you for visiting the music store!");
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

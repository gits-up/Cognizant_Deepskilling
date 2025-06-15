import java.util.*;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return bookId + " - " + title + " by " + author;
    }
}

public class LibraryManagement {
    static Book[] books = new Book[5];

    public static void linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found (Linear Search): " + book);
                return;
            }
        }
        System.out.println("Book not found (Linear Search).");
    }

    public static void binarySearchByTitle(String title) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) {
                System.out.println("Book found (Binary Search): " + books[mid]);
                return;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Book not found (Binary Search).");
    }

    public static void main(String[] args) {
        books[0] = new Book(101, "Java Programming", "Herbert Schildt");
        books[1] = new Book(102, "Data Structures", "Seymour Lipschutz");
        books[2] = new Book(103, "Operating Systems", "Galvin");
        books[3] = new Book(104, "Algorithms", "Cormen");
        books[4] = new Book(105, "Database Systems", "Navathe");

        System.out.println("\nSearching for 'Data Structures' using linear search:");
        linearSearchByTitle("Data Structures");

        System.out.println("\nSearching for 'Operating Systems' using binary search:");
        binarySearchByTitle("Operating Systems");

        System.out.println("\nSearching for 'Cloud Computing' using both methods:");
        linearSearchByTitle("Cloud Computing");
        binarySearchByTitle("Cloud Computing");
    }
}
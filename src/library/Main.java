package library;

import java.util.*;

// الكلاس الرئيسي الذي يدير نظام إدارة المكتبة الرقمية
public class Main {
    static Scanner input = new Scanner(System.in); // أداة لقراءة إدخال المستخدم
    static List<Book> books = new ArrayList<>(); // قائمة لحفظ الكتب
    static List<Borrower> borrowers = new ArrayList<>(); // قائمة لحفظ المستعيرين

    public static void main(String[] args) {
        while (true) {
            // عرض القائمة الرئيسية للخيارات
            System.out.println("\n===== Digital Library Management System =====");
            System.out.println("1. Add new book");
            System.out.println("2. Add new borrower");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Search for a book");
            System.out.println("6. Show borrower's books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt(); // قراءة الخيار من المستخدم
            input.nextLine(); // تنظيف السطر

            // تنفيذ الأمر المناسب حسب اختيار المستخدم
            switch (choice) {
                case 1 -> addBook();
                case 2 -> addBorrower();
                case 3 -> borrowBook();
                case 4 -> returnBook();
                case 5 -> searchBook();
                case 6 -> showBorrowedBooks();
                case 7 -> {
                    System.out.println("Exiting...");
                    return; // إنهاء البرنامج
                }
                default -> System.out.println("Invalid option."); // خيار غير صالح
            }
        }
    }

    // إضافة كتاب جديد
    static void addBook() {
        System.out.print("Book title: ");
        String title = input.nextLine();
        System.out.print("Author: ");
        String author = input.nextLine();
        System.out.print("ISBN number: ");
        String isbn = input.nextLine();
        System.out.print("Book type (1 - Printed, 2 - EBook): ");
        int type = input.nextInt();
        input.nextLine();

        // إنشاء كائن الكتاب حسب النوع وإضافته للقائمة
        Book book = (type == 1) ? new PrintedBook(title, author, isbn) : new EBook(title, author, isbn);
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // إضافة مستعير جديد
    static void addBorrower() {
        System.out.print("Borrower's name: ");
        String name = input.nextLine();
        System.out.print("Student ID: ");
        String id = input.nextLine();

        borrowers.add(new Borrower(name, id));
        System.out.println("Borrower added successfully.");
    }

    // إعارة كتاب لمستعير
    static void borrowBook() {
        System.out.print("Book ISBN: ");
        String isbn = input.nextLine();
        Book book = findBookByISBN(isbn);

        if (book == null || !book.isAvailable()) {
            System.out.println("Book not found or not available.");
            return;
        }

        System.out.print("Borrower's student ID: ");
        String id = input.nextLine();
        Borrower borrower = findBorrowerById(id);

        if (borrower == null) {
            System.out.println("Borrower not found.");
            return;
        }

        borrower.borrowBook(book);
        System.out.println("Book borrowed successfully.");
    }

    // استرجاع كتاب من مستعير
    static void returnBook() {
        System.out.print("Book ISBN: ");
        String isbn = input.nextLine();
        Book book = findBookByISBN(isbn);

        if (book == null || book.isAvailable()) {
            System.out.println("Book not found or not borrowed.");
            return;
        }

        System.out.print("Borrower's student ID: ");
        String id = input.nextLine();
        Borrower borrower = findBorrowerById(id);

        if (borrower == null || !borrower.getBorrowedBooks().contains(book)) {
            System.out.println("Borrower not found or did not borrow this book.");
            return;
        }

        borrower.returnBook(book);
        System.out.println("Book returned successfully.");
    }

    // البحث عن كتاب باستخدام العنوان أو رقم ISBN
    static void searchBook() {
        System.out.print("Enter title or ISBN to search: ");
        String keyword = input.nextLine().toLowerCase();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword) || book.getISBN().equals(keyword)) {
                System.out.println(book.getTitle() + " - " + book.getAuthor() + " [" + (book.isAvailable() ? "Available" : "Borrowed") + "]");
            }
        }
    }

    // عرض الكتب المستعارة من مستعير معين
    static void showBorrowedBooks() {
        System.out.print("Borrower's student ID: ");
        String id = input.nextLine();
        Borrower borrower = findBorrowerById(id);

        if (borrower == null) {
            System.out.println("Borrower not found.");
            return;
        }

        System.out.println("Borrowed books:");
        for (Book book : borrower.getBorrowedBooks()) {
            System.out.println("- " + book.getTitle() + " (" + book.getType() + ")");
        }
    }

    // دالة للبحث عن كتاب باستخدام ISBN
    static Book findBookByISBN(String isbn) {
        for (Book book : books)
            if (book.getISBN().equals(isbn))
                return book;
        return null;
    }

    // دالة للبحث عن مستعير باستخدام الرقم الجامعي
    static Borrower findBorrowerById(String id) {
        for (Borrower b : borrowers)
            if (b.getId().equals(id))
                return b;
        return null;
    }
}

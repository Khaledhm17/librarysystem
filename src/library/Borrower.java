package library;

import java.util.ArrayList;
import java.util.List;

// هذا الكلاس يمثل المستعير (الشخص الذي يستعير الكتب من المكتبة)
public class Borrower {
    // بيانات المستعير: الاسم والرقم الجامعي
    private String name, id;

    // قائمة بالكتب التي قام المستعير باستعارتها
    private List<Book> borrowedBooks = new ArrayList<>();

    // المُنشئ: يستقبل اسم المستعير ورقمه الجامعي ويخزنها
    public Borrower(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // دالة لاسترجاع اسم المستعير
    public String getName() { return name; }

    // دالة لاسترجاع رقم المستعير الجامعي
    public String getId() { return id; }

    // دالة لإعارة كتاب: تضيف الكتاب إلى القائمة وتحدث حالته إلى "غير متاح"
    public void borrowBook(Book book) {
        borrowedBooks.add(book); // إضافة الكتاب إلى قائمة الكتب المستعارة
        book.borrow(); // تغيير حالة الكتاب إلى "غير متاح"
    }

    // دالة لإرجاع كتاب: تزيله من القائمة وتعيد حالته إلى "متاح"
    public void returnBook(Book book) {
        borrowedBooks.remove(book); // إزالة الكتاب من القائمة
        book.returnBook(); // تغيير حالة الكتاب إلى "متاح"
    }

    // دالة لاسترجاع قائمة الكتب المستعارة من قبل هذا المستعير
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}

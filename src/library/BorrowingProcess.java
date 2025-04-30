package library;

import java.time.LocalDate; // استيراد كلاس التاريخ من مكتبة Java

// هذا الكلاس يمثل عملية إعارة كتاب من المكتبة
public class BorrowingProcess {
    // المتغيرات الخاصة بالعملية: الكتاب، المستعير، تاريخ الإعارة، وتاريخ الإرجاع
    private Book book;
    private Borrower borrower;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    // المُنشئ: يستقبل كائن كتاب وكائن مستعير ويُسجّل تاريخ الإعارة الحالي
    public BorrowingProcess(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = LocalDate.now(); // تعيين تاريخ الإعارة ليكون تاريخ اليوم
    }

    // دالة إرجاع الكتاب: تُحدث تاريخ الإرجاع وتُرجع الكتاب للمستعير
    public void returnBook() {
        this.returnDate = LocalDate.now(); // تعيين تاريخ الإرجاع ليكون تاريخ اليوم
        borrower.returnBook(book); // استدعاء دالة إرجاع الكتاب في كلاس المستعير
    }

    // دالة للحصول على الكتاب الذي تم إعارته
    public Book getBook() { return book; }

    // دالة للحصول على المستعير
    public Borrower getBorrower() { return borrower; }

    // دالة للحصول على تاريخ الإعارة
    public LocalDate getBorrowDate() { return borrowDate; }

    // دالة للحصول على تاريخ الإرجاع
    public LocalDate getReturnDate() { return returnDate; }
}

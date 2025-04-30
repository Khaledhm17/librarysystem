package library;

// تعريف صنف يمثل كتابًا ورقيًا ويطبق واجهة Book
public class PrintedBook implements Book {
    // خصائص الكتاب: العنوان، المؤلف، رقم ISBN، والتوفر
    private String title, author, isbn;
    private boolean available = true; // الحالة الابتدائية للكتاب هي متاح

    // المُنشئ لتعيين القيم الأساسية عند إنشاء كائن جديد من PrintedBook
    public PrintedBook(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // دوال للحصول على بيانات الكتاب
    public String getTitle() { return title; } // إرجاع العنوان
    public String getAuthor() { return author; } // إرجاع اسم المؤلف
    public String getISBN() { return isbn; } // إرجاع رقم ISBN

    // التحقق مما إذا كان الكتاب متاحًا
    public boolean isAvailable() { return available; }

    // تعيين حالة الكتاب كغير متاح عند إعارته
    public void borrow() { available = false; }

    // تعيين حالة الكتاب كمتاح عند استرجاعه
    public void returnBook() { available = true; }

    // تحديد نوع الكتاب كـ "ورقي"
    public String getType() { return "ورقي"; }
}

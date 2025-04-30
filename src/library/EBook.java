package library;

// تعريف صنف يمثل كتابًا إلكترونيًا ويطبق الواجهة Book
public class EBook implements Book {
    // خصائص الكتاب: العنوان، المؤلف، رقم ISBN، وحالة التوفر
    private String title, author, isbn;
    private boolean available = true; // يتم اعتبار الكتاب متاحًا بشكل افتراضي

    // المُنشئ: يقوم بتعيين العنوان والمؤلف وISBN عند إنشاء كائن جديد
    public EBook(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // دالة إرجاع عنوان الكتاب
    public String getTitle() { return title; }

    // دالة إرجاع اسم المؤلف
    public String getAuthor() { return author; }

    // دالة إرجاع رقم ISBN
    public String getISBN() { return isbn; }

    // دالة التحقق من ما إذا كان الكتاب متاحًا للإعارة
    public boolean isAvailable() { return available; }

    // عند استعارة الكتاب، يتم تعيينه كغير متاح
    public void borrow() { available = false; }

    // عند إرجاع الكتاب، يتم تعيينه كمتاح مرة أخرى
    public void returnBook() { available = true; }

    // دالة تُرجع نوع الكتاب (إلكتروني في هذه الحالة)
    public String getType() { return "إلكتروني"; }
}

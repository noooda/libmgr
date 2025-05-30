import io.github.noooda.libmgr.domain.Librarian;
import io.github.noooda.libmgr.domain.Book;

import java.util.List;

public class Main {
    // Define librarian here

    public static void main(String[] args) {
        Librarian librarian = new Librarian();
        librarian.registerBook("1984", "George Orwell");
        librarian.registerBook("To Kill a Mockingbird", "Harper Lee");
        librarian.registerBook("The Great Gatsby", "F. Scott Fitzgerald");
        librarian.registerBook("The Catcher in the Rye", "J.D. Salinger");
        librarian.registerBook("ノルウェイの森", "村上春樹");
        librarian.registerBook("コンビニ人間", "村田沙耶香");
        librarian.registerBook("吾輩は猫である", "夏目漱石");
        librarian.registerBook("ゴールデンスランバー", "伊坂幸太郎");
        librarian.registerBook("重力ピエロ", "伊坂幸太郎");
        librarian.registerBook("マリアビートル", "伊坂幸太郎");
        librarian.registerBook("オーデュボンの祈り", "伊坂幸太郎");
        
        List<Book> bookList = librarian.showBookList();
        for (Book book : bookList) {
            System.out.println(book.getTitle() + " " + book.getAuthor());
        }

        System.out.println("");
        System.out.println("検索結果:");
        System.out.println("");

        List<Book> results = librarian.findBooksByTitle("e");
        for (Book book : results) {
            System.out.println(book.getTitle() + " " + book.getAuthor());
        }
    } 
}
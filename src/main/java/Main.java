import java.util.List;
import java.util.Scanner;

import io.github.noooda.libmgr.domain.Librarian;
import io.github.noooda.libmgr.domain.Book;

public class Main {
    // Define librarian here as private
    private static Librarian librarian = new Librarian();

    public static void init() {
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
    }

    public static void main(String[] args) {
        init();

        System.out.println("\nコマンドを入力してください:\n");
        System.out.println("1. 書籍一覧を表示 [list]");
        System.out.println("2. 書籍を追加 [add]");
        System.out.println("3. 書籍を検索 [search-title | search-author]");
        System.out.println("4. 終了 [exit]\n");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) break;
            
            if (input.isEmpty()) continue;

            switch(input) {
                case "list":
                    list();
                    break;
                case "add":
                    System.out.print("\n著者名を入力してください: ");
                    String author = scanner.nextLine().trim();
                    if (author.isEmpty()) {
                        System.out.println("著者名は必須です。\n");
                        break;
                    }
                    System.out.print("\n書籍名を入力してください: ");
                    String title = scanner.nextLine().trim();
                    if (title.isEmpty()) {
                        System.out.println("書籍名は必須です。\n");
                        break;
                    }
                    add(author, title);
                    break;
                case "search-title":
                    System.out.print("\n書籍名のキーワードを入力してください: ");
                    String keyword = scanner.nextLine().trim();
                    if (keyword.isEmpty()) {
                        System.out.println("キーワードは必須です。\n");
                        break;
                    }
                    searchTitle(keyword);
                    break;
                case "search-author":
                    System.out.print("\n著者名のキーワードを入力してください: ");
                    String authorKeyword = scanner.nextLine().trim();
                    if (authorKeyword.isEmpty()) {
                        System.out.println("キーワードは必須です。\n");
                        break;
                    }
                    searchAuthor(authorKeyword);
                    break;
            }
        }

        scanner.close();

        System.out.println("");
        System.out.println("検索結果:");
        System.out.println("");

        List<Book> results = librarian.findBooksByTitle("e");
        for (Book book : results) {
            System.out.println(book.getTitle() + " " + book.getAuthor());
        }
    } 

    public static void list() {
        List<Book> bookList = librarian.showBookList();
        System.out.println("\nTitle Author");
        System.out.println("------------------------------");
        for (Book book : bookList) {
            System.out.println(book.getTitle() + " " + book.getAuthor());
        }
        System.out.println("------------------------------\n");
    }

    public static void add(String author, String title) {
        librarian.registerBook(title, author);
        System.out.println("\nTitle Author");
        System.out.println("------------------------------");
        System.out.println(title + " " + author);
        System.out.println("------------------------------\n");
    }

    public static void searchTitle(String keyword) {
        List<Book> results = librarian.findBooksByTitle(keyword);
        if (results.isEmpty()) {
            System.out.println("\n該当する書籍はありません。\n");
        } else {
            System.out.println("\nTitle Author");
            System.out.println("------------------------------");
            for (Book book : results) {
                System.out.println(book.getTitle() + " " + book.getAuthor());
            }
            System.out.println("------------------------------\n");
        }
    }

    public static void searchAuthor(String keyword) {
        List<Book> results = librarian.findBooksByAuthor(keyword);
        if (results.isEmpty()) {
            System.out.println("\n該当する書籍はありません。\n");
        } else {
            System.out.println("\nTitle Author");
            System.out.println("------------------------------");
            for (Book book : results) {
                System.out.println(book.getTitle() + " " + book.getAuthor());
            }
            System.out.println("------------------------------\n");
        }
    }
}

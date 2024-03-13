package miniTestW2;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ProgrammingBook[] programmingBooks = new ProgrammingBook[3];
    public static FictionBook[] fictionBooks = new FictionBook[3];

    public static void main(String[] args) {

        int choice = 0;

//        programmingBooks[0] = new ProgrammingBook(1, "Clean Code", 25.5, "Robert C. Martin", "Java", "Spring");
//        programmingBooks[1] = new ProgrammingBook(2, "Head First Java", 30.0, "Kathy Sierra", "Java", "None");
//        programmingBooks[2] = new ProgrammingBook(3, "Learning Python", 35.2, "Mark Lutz", "Python", "Django");
//        programmingBooks[3] = new ProgrammingBook(4, "JavaScript: The Good Parts", 20.0, "Douglas Crockford", "JavaScript", "Node.js");
//        programmingBooks[4] = new ProgrammingBook(5, "C# in Depth", 28.8, "Jon Skeet", "C#", ".NET");
//
//
//        fictionBooks[0] = new FictionBook(6, "Harry Potter and the Philosopher's Stone", 15.0, "J.K. Rowling", "Fantasy");
//        fictionBooks[1] = new FictionBook(7, "The Great Gatsby", 12.5, "F. Scott Fitzgerald", "Literary Fiction");
//        fictionBooks[2] = new FictionBook(8, "1984", 18.9, "George Orwell", "Dystopian");
//        fictionBooks[3] = new FictionBook(9, "To Kill a Mockingbird", 10.75, "Harper Lee", "Classics");
//        fictionBooks[4] = new FictionBook(10, "Brave New World", 9.99, "Aldous Huxley", "Sci-Fi");


        while (choice != 7) {
            System.out.println("Menu.");
            System.out.println("1.Nhập sách.");
            System.out.println("2.Xem sách");
            System.out.println("3.Tính tổng tiền");
            System.out.println("4.Đếm số sách ProgrammingBook có language là 'Java'.");
            System.out.println("5.Đếm số sách Fiction có category là 'Viễn tưởng 1'.");
            System.out.println("6.Đếm số sách Fiction có giá <100.");
            System.out.println("7.Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    addBooks();
                    System.out.println();
                    break;
                }
                case 2: {
                    showBooks();
                    System.out.println();
                    break;
                }
                case 3: {
                    totalPrice();
                    System.out.println();
                    break;
                }
                case 4: {
                    javaProgrammingBooksCount();
                    System.out.println();
                    break;
                }
                case 5: {
                    sciFiFictionBooksCount();
                    System.out.println();
                    break;
                }
                case 6: {
                    priceFictionBooksCount();
                    System.out.println();
                    break;
                }
                case 7: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Số bạn vừa chọn không đúng!!!");
                }
            }
        }
    }

    public static void addBooks() {
        for (int i = 0; i < programmingBooks.length; i++) {
            System.out.println("Hãy nhập thông tin sách Programming.");
            System.out.print("Nhập mã sách: ");
            int bookCode = scanner.nextInt();
            scanner.nextLine();
            //int bookCode = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập tên sách: ");
            String name = scanner.nextLine();

            System.out.print("Nhập giá sách: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập tác giả: ");
            String author = scanner.nextLine();

            System.out.print("Nhập ngôn ngữ: ");
            String language = scanner.nextLine();

            System.out.print("Nhập framework (nếu có): ");
            String framework = scanner.nextLine();

            System.out.println();

            programmingBooks[i] = new ProgrammingBook(bookCode, name, price, author, language, framework);
        }

        for (int i = 0; i < fictionBooks.length; i++) {
            System.out.println("Nhập thông tin sách FictionBook.");
            System.out.print("Nhập mã sách: ");
            int bookCode = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nhập tên sách: ");
            String name = scanner.nextLine();

            System.out.print("Nhập giá sách: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập tác giả: ");
            String author = scanner.nextLine();

            System.out.print("Nhập thể loại: ");
            String category = scanner.nextLine();

            System.out.println();

            fictionBooks[i] = new FictionBook(bookCode, name, price, author, category);
        }
    }

    public static void showBooks() {
        System.out.println("List ProgrammingBook.");
        System.out.printf("| %-10s | %-40s | %-5s | %-20s | %-10s | %-10s |%n", "BookCode", "Name", "Price", "Author", "Language", "Framework");

        for (int i = 0; i < programmingBooks.length; i++) {
            System.out.printf("| %-10s | %-40s | %-5s | %-20s | %-10s | %-10s |%n", programmingBooks[i].getBookCode(), programmingBooks[i].getName(), programmingBooks[i].getPrice(), programmingBooks[i].getAuthor(), programmingBooks[i].getLanguage(), programmingBooks[i].getFramework());
        }

        System.out.println("List FictionBook.");
        System.out.printf("| %-10s | %-40s | %-5s | %-20s | %-10s |%n", "BookCode", "Name", "Price", "Author", "Categoty");

        for (int i = 0; i < fictionBooks.length; i++) {
            System.out.printf("| %-10s | %-40s | %-5s | %-20s | %-10s |%n", fictionBooks[i].getBookCode(), fictionBooks[i].getName(), fictionBooks[i].getPrice(), fictionBooks[i].getAuthor(), fictionBooks[i].getCategory());
        }
    }

    public static void totalPrice() {
        double totalPrice = 0;
        for (Book book : programmingBooks) {
            totalPrice += book.getPrice();
        }
        for (Book book : fictionBooks) {
            totalPrice += book.getPrice();
        }
        String formatTotalPrice = String.format("%.2f", totalPrice);
        System.out.println("Tổng tiền của tất cả cuốn sách: " + formatTotalPrice);
    }

    public static void javaProgrammingBooksCount() {
        int javaProgrammingBooksCount = 0;
        for (ProgrammingBook book : programmingBooks) {
            if (book.getLanguage().equals("Java")) {
                javaProgrammingBooksCount++;
            }
        }
        System.out.println("Số sách ProgrammingBook có language là 'Java': " + javaProgrammingBooksCount);
    }

    public static void sciFiFictionBooksCount() {
        int sciFiFictionBooksCount = 0;
        for (FictionBook book : fictionBooks) {
            if (book.getCategory().equals("Sci-Fi")) {
                sciFiFictionBooksCount++;
            }
        }
        System.out.println("Số sách Fiction có Category là 'Sci-Fi': " + sciFiFictionBooksCount);
    }

    public static void priceFictionBooksCount() {
        int priceFictionBooksCount = 0;
        for (FictionBook book : fictionBooks) {
            if (book.getPrice() < 100) {
                priceFictionBooksCount++;
            }
        }
        System.out.println("Số sách Fiction có giá dưới 100: " + priceFictionBooksCount);
    }
}

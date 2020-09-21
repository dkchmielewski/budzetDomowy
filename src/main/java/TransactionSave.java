import java.util.Scanner;

public class TransactionSave {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rodzaj transakcji");
        String type = scanner.nextLine();
        System.out.println("Podaj opis transakcji");
        String description = scanner.nextLine();
        System.out.println("Kwota");
        double amount = scanner.nextDouble();
        System.out.println("Czas dokonanej transakci");
        String date = scanner.nextLine();

        Transaction transaction = new Transaction(type, description, amount, date);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.add(transaction);

    }
}

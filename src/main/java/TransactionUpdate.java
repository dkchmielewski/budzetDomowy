import java.util.Scanner;

public class TransactionUpdate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj id transakcji ktora chcesz zaktualizowac");
        long transactionToBeUpdated = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj rodzaj transakcji");
        String type = scanner.nextLine();

        System.out.println("Podaj opis transakcji");
        String description = scanner.nextLine();

        System.out.println("Podaj kwote");
        double amount = scanner.nextDouble();

        System.out.println("Podaj date transakcji");
        String date = scanner.nextLine();

        Transaction transaction = new Transaction(type, description, amount, date);

        TransactionDao transactionDao = new TransactionDao();
        transactionDao.update(transaction);
        System.out.println("Transakcja zaktualizowana!");
    }

}

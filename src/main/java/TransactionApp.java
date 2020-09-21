import java.util.Scanner;

public class TransactionApp {

    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Co chcesz zrobic?");
            System.out.println("1. Dodaj transakcje");
            System.out.println("2. Zmodyfikuj transakcje");
            System.out.println("3. Usunac transakcje");
            System.out.println("4. Wyswietl przychody");
            System.out.println("5. Wyswietl wydatki");
            System.out.println("0. Koniec");
            String userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    TransactionSave.main(new String[0]);
                    break;
                case "2":
                    TransactionUpdate.main(new String[0]);
                    break;
                case "3":
                    TransactionDelete.main(new String[0]);
                    break;
                case "4":
                    DisplayAssets.main(new String[0]);
                    break;
                case "5":
                    DisplayLiabilities.main(new String[0]);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Niedostepna opcja!");
            }
        }
    }
}

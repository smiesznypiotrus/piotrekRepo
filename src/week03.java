import javax.swing.*;

import static java.lang.Integer.parseInt;

public class week03 {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson("Jan", "Kowalski", "721371488");
        phoneBook.addPerson("Wiktoria", "Nawrocka", "123456789");
        phoneBook.addPerson("Piotr", "Pyciak", "999999999");

        int choice;
        choice = parseInt(JOptionPane.showInputDialog(
                "1. Imie -> Nazwisko -> Numer telefonu" +
                        "\n2. Nazwisko -> Imie -> Numer telefonu" +
                        "\n3. Numer telefonu -> Nazwisko -> Imie" +
                        "\n4. CompareTo"
        ));
        phoneBook.sortMethod(choice);
        phoneBook.printRepository();

    }

}






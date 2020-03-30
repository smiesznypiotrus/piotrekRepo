import javax.swing.*;
        import java.util.Arrays;
        import java.util.Date;

public class week02 {
    public static void main(String[] args) {

        //Argumenty wywolania programu
        String txt1; //deklaracja zmiennej tekstowej
        txt1 = JOptionPane.showInputDialog("Wprowadz pierwsza liczbe");

        String txt2;
        txt2 = JOptionPane.showInputDialog("Wprowadz druga liczbe");

        String txt3;
        txt3 = JOptionPane.showInputDialog("Wprowadz znak dzialania (+,-,/ lub *)");

        // Konwersja tekstu na liczbe
        double 	liczba1 = Double.parseDouble(txt1);
        double	liczba2 = Double.parseDouble(txt2);
        double 	wynik;
        char	znak=txt3.charAt(0);

        if(znak=='+') {
            wynik=liczba1+liczba2;
            System.out.println(liczba1 + "+" + liczba2 + "="+ wynik);}

        else if(znak=='-') {
            wynik=liczba1-liczba2;
            System.out.println(liczba1 + "-" + liczba2 + "="+ wynik);}

        else if(znak=='*') {
            wynik=liczba1*liczba2;
            System.out.println(liczba1 + "*" + liczba2 + "="+ wynik);}

        else if(znak=='/') {
            wynik=liczba1/liczba2;
            System.out.println(liczba1 + "/" + liczba2 + "="+ wynik);}

        else System.out.println("Szansa na sprawdzenie działania kalkulatora stracona");

        //Tablice: indeksowanie, wypełnianie, przeszukiwanie
        String rozmiartxt = JOptionPane.showInputDialog("Podaj rozmiar tablicy");
        int rozmiar = Integer.parseInt(rozmiartxt);
        int tab[] = new int[rozmiar];
        // Wypelnianie tablicy liczbami losowymi z dynamicznie ustalanego zakresu
        int zakres = Integer.parseInt(args[0]);

        System.out.println("Wylosowana tablica:");
        for (int i = 0; i < rozmiar; i++) {
            tab[i] = (int) (Math.random() * zakres);
            System.out.print(tab[i] + " ");
        }
        System.out.println();
        int tab_bubble[] = new int[tab.length];
        for (int i = 0; i < rozmiar; i++) {
            tab_bubble[i] = tab[i];
        }
        System.out.println();
        int tab_bubble_moje[] = new int[tab.length];
        for (int i = 0; i < rozmiar; i++) {
            tab_bubble_moje[i] = tab[i];
        }

        //sprawdzenie czasu dla funkcji bubbleSort
        Date przed_bubble = new Date();
        bubbleSort(tab);
        Date po_bubble = new Date();
        System.out.println("Czas operacji bubbleSort " + (po_bubble.getTime() - przed_bubble.getTime()) + "ms");

        //sprawdzenie czasu dla funkcji bubbleSort_moje
        Date przed_bubble_moje = new Date();
        bubbleSort_moje(tab_bubble_moje);
        Date po_bubble_moje = new Date();
        System.out.println("Czas operacji bubbleSort_moje "+(po_bubble_moje.getTime() - przed_bubble_moje.getTime()) +"ms");


        //sprawdzenie czasu dla funkcji sort z biblioteki Arrays
        Date przed_sort = new Date();
        Arrays.sort(tab_bubble);
        Date po_sort = new Date();
        System.out.println("Czas operacji Arrays.sort "+(po_sort.getTime() - przed_sort.getTime()) +"ms");

    }

    private static void bubbleSort_moje(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2 - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            for (int k = n - 1; k > n / 2; k--) {
                if (arr[k] > arr[k - 1]) {
                    int h = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = h;
                }
            }
        }
    }

    private static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}

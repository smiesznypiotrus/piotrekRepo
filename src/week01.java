import javax.swing.*;

public class week01 {
    public static void main(String[] args) {
        String txt= JOptionPane.showInputDialog("Podaj liczbe wierszy do wyswietlenia");
        int n = Integer.parseInt(txt);

        long Pascal[][] = new long[n][n];
        for(int j = 0 ; j<n ; j++){
            Pascal[j][0] = 1;
            Pascal[j][j] = 1;

            for (int i = 0 ; i<j-1 ; i++){
                Pascal[j][i+1]=Pascal[j-1][i]+Pascal[j-1][i+1];
            }
        }
        for(int i = 0 ; i<n ; i++) {
            for (int k = i; k<n ; k++){
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(Pascal[i][j] + "   ");
            }
            System.out.println();
        }
    }
}

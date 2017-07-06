import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class QuickSort {
     
    private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;

        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    public static void main(String a[]){
        while (true) {
            BufferedReader tastatura = new BufferedReader(new InputStreamReader(System.in));
            String sir_intrare = "";
            System.out.println("Introduceti un sir de numere: ");
            try { sir_intrare = tastatura.readLine(); }
            catch(IOException e) { sir_intrare = ""; }
            if (sir_intrare != "") {
                String[] strArray = sir_intrare.split(",");
                int[] input = new int[strArray.length];
                for(int i = 0; i < strArray.length; i++) {
                    input[i] = Integer.parseInt(strArray[i]);
                }

                if (input.length > 0) {
                    QuickSort sorter = new QuickSort();
                    //int[] input = {24,2,45,20,56,75,2,56,99,53,12};
                    sorter.sort(input);
                    for(int i:input){
                        System.out.print(i);
                        System.out.print(" ");
                    }
                    System.out.println(" ");
                } else System.out.println("Sir de intrare invalid!");
            } else System.out.println("Sir de intrare invalid!");
        }
    }
}
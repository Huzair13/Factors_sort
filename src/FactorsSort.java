import java.util.Arrays;
import java.util.Scanner;
public class FactorsSort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the size of the Array !!! ");
        int size=scanner.nextInt();

        System.out.println("Enter the Array Elements !!!");
        Integer[] array=new Integer[size];
        for(int i=0;i<size;i++){
            array[i]=scanner.nextInt();
        }

        //Calling factArray to count the number of factors
        int factArray[][]=factors(array,size);

        //Calling factor Sort to sort with respect to factors
        int sorted[][]=factorSort(factArray,size);

        System.out.println(Arrays.toString(sorted[0]));

    }

    private static int[][] factorSort(int[][] factArray, int size) {
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(factArray[1][i]>factArray[1][j]){
                    int temp1=factArray[1][i];
                    factArray[1][i]=factArray[1][j];
                    factArray[1][j]=temp1;

                    int temp0=factArray[0][i];
                    factArray[0][i]=factArray[0][j];
                    factArray[0][j]=temp0;
                }else if(factArray[1][i]==factArray[1][j]){
                    if(factArray[0][i]>factArray[0][j]){
                        int temp0=factArray[0][i];
                        factArray[0][i]=factArray[0][j];
                        factArray[0][j]=temp0;

                        int temp1=factArray[1][i];
                        factArray[1][i]=factArray[1][j];
                        factArray[1][j]=temp1;
                    }
                }
            }
        }
        return factArray;
    }

    private static int[][] factors(Integer[] array, int size) {
        int[][] countArray=new int[2][size];
        for(int iterator=0;iterator<size;iterator++){
            int count=0;
            for(int i=1;i*i<=array[iterator];i++){
                if(array[iterator]%i==0){
                    if(array[iterator]/i==i){
                        count++;
                    }
                    else{
                        count+=2;
                    }
                }
            }
            countArray[0][iterator]=array[iterator];
            countArray[1][iterator]=count;
        }
        return countArray;
    }
}
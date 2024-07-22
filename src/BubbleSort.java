public class BubbleSort {
    private static final String output1 = "OUTPUT1.TXT";
    private static final StringBuilder stringBuilder = new StringBuilder();

    //Sắp xếp theo thuật toán nổi bọt
    public static double[] bubbleSortDouble(double[]a){
        int n = a.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(a[j]>a[j+1]){
                    Common.swap(a, j, j+1);
                }
            }
            //In các cách sắp xếp ra cửa sổ console
            Common.printArray(a);
        }
        return a;
    }
}

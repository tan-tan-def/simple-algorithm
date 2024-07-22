public class InsertionSort {
    public static double[] insertionSortDouble(double[]a){
        int n = a.length;
        for(int i=1; i<n; i++){
            double temp = a[i];
            int j=i-1;
            while(j>=0 && a[j]>=temp){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temp;
            Common.printArray(a);
        }
        return a;
    }
}

public class SelectionSort {
    public static double[] selectionSortDouble(double[]a){
        int n = a.length;
        for(int i=0; i<n-1; i++){
            double min = a[i];
            for(int j =i+1; j<n; j++){
                if(min>a[j]){
                    min=a[j];
                    Common.swap(a, i, j);
                }
            }
            // In kết quả ra màn hình console
            Common.printArray(a);
        }

        return a;
    }
}

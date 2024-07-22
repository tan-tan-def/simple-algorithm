import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(double[] a, double b){
        Arrays.sort(a);
        int left = 0;
        int right = a.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            //Điều kiện dừng vòng lặp
            if(b==a[mid]){
                return mid;
            }
            if(b>a[mid]){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;
    }
}

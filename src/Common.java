import java.util.Arrays;

public class Common {
    //Đảo vị trí các phần tử
    public static void swap(double a[], int index1, int index2){
        double temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    //In ra hàng loạt các các số
    public static void printArray(double[]arr){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
    //Chỉnh sửa cách in ra một mảng
    public static String modifyArray(double[] a){
        // Chuyển mảng thành chuỗi
        String result = Arrays.toString(a);
        // Thay thế dấu phẩy bằng khoảng trắng
        result = result.replace(",", " ");
        // Loại bỏ dấu ngoặc vuông ở hai đầu
        result = result.substring(1, result.length() - 1);
        return result;
    }
}

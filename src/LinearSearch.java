import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    //Tìm kiếm phần tử bằng value
    public static boolean searchLinearOne(double[] a, double value){
        for(int i=0; i<a.length;i++){
            if(value ==a[i]){
                return true;
            }
        }
        return false;
    }
    //Tìm kiếm phần tử lớn hơn value
    public static void searchLinearTwo(double[] a, double value){
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i< a.length; i++){
            if(a[i]>value){
                indices.add(i);
                stringBuilder.append(i).append("  ");
            }
        }
        TextFile.writeFile("OUTPUT4.TXT",stringBuilder.toString());
        //Hiển thị các vị trí có phần tử lớn hơn value
        System.out.print("Larger position: ");
        for(Integer index: indices){
            System.out.print(index+" ");
        }
        System.out.println();
    }
}


import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String filePath = "INPUT.TXT";
    public static void main(String[] args) {
        String numberFunction;
        do{
            System.out.println("+--------------Menu--------------+");
            System.out.println("|     1. Manual input            |");
            System.out.println("|     2. File input              |");
            System.out.println("|     3. Bubble sort             |");
            System.out.println("|     4. Selection sort          |");
            System.out.println("|     5. Insertion sort          |");
            System.out.println("|     6. Search > value          |");
            System.out.println("|     7. Search = value          |");
            System.out.println("|     0. Exit                    |");
            System.out.println("+--------------------------------+");
            //Nhập các giá trị từ 0 đến 7 để thực hiện chức năng
            System.out.println("        ******************");
            System.out.print("Please enter a number from 0 to 7: ");
                numberFunction = sc.nextLine();
                switch (numberFunction){
                    case "0":
                        System.out.println("Thanks!!!");
                        break;
                    case "1":
                        manualInput();
                        break;
                    case "2":
                        String path;
                        do{
                            System.out.print("Please enter the file path: ");
                            path = sc.nextLine();
                            if(path.trim().equalsIgnoreCase(filePath)){
                                double[] numbers = fileInput();
                                for(int i=0; i<numbers.length; i++){
                                    System.out.print(numbers[i]+"  ");
                                }
                                System.out.println();
                            }else{
                                System.out.println("The path not true, please enter again.");
                            }
                        }while(!path.trim().equalsIgnoreCase(filePath));
                        break;
                    case "3":
                        StringBuilder stringBuilderBubbleSort = new StringBuilder();
                        System.out.println("Implement Bubble Sort algorithm to sort an array.");
                        //Mảng sau khi sắp xếp
                        double[] sortBubble = BubbleSort.bubbleSortDouble(fileInput());
                        //Chỉnh sửa mảng
                        String resultBubbleSort = Common.modifyArray(sortBubble);
                        stringBuilderBubbleSort.append(resultBubbleSort);
                        //Viết vào OUTPUT1.TXT
                        TextFile.writeFile("OUTPUT1.TXT",resultBubbleSort.toString());
                        break;
                    case "4":
                        StringBuilder stringBuilderSelectionSort = new StringBuilder();
                        System.out.println("Implement Selection Sort algorithm to sort an array.");
                        //Mảng sau khi sắp xếp
                        double[] sortSelection = SelectionSort.selectionSortDouble(fileInput());
                        //Chỉnh sửa mảng
                        String resultSelectionSort = Common.modifyArray(sortSelection);
                        stringBuilderSelectionSort.append(resultSelectionSort);
                        //Viết vào OUTPUT2.TXT
                        TextFile.writeFile("OUTPUT2.TXT",stringBuilderSelectionSort.toString());
                        break;
                    case "5":
                        StringBuilder stringBuilderInsertionSort = new StringBuilder();
                        System.out.println("Implement Insertion Sort algorithm to sort an array.");
                        //Mảng sau khi sắp xếp
                        double[] sortInsertion = InsertionSort.insertionSortDouble(fileInput());
                        //Chỉnh sửa mảng
                        String resultInsertionSort = Common.modifyArray(sortInsertion);
                        stringBuilderInsertionSort.append(resultInsertionSort);
                        //Viết vào OUTPUT3.TXT
                        TextFile.writeFile("OUTPUT3.TXT",stringBuilderInsertionSort.toString());
                        break;
                    case "6":
                        boolean isEqual = false;
                        double valueLinear;
                        System.out.print("Please enter searched input value: ");
                        try{
                            //Nhập gía trị cần tìm
                            valueLinear = Double.parseDouble(sc.nextLine());
                        }catch (Exception e){
                            System.out.println("The value does not exist!");
                            break;
                        }
                        //Gán mảng
                        double[] arrayOfLinear = fileInput();
                        //Tìm kiếm giá trị value giống nhau
                        if(LinearSearch.searchLinearOne(arrayOfLinear,valueLinear)){
                            isEqual=true;
                        }
                        //Hiển thị nếu không có giá trị value trong mảng
                        if(!isEqual){
                            System.out.println("The value does not exist!");
                        }else{
                            LinearSearch.searchLinearTwo(arrayOfLinear, valueLinear);
                        }
                        break;
                    case "7":
                        double[] arrayBinary = fileInput();
                        double valueBinary;
                        System.out.print("Please enter searched input value: ");
                        try{
                            valueBinary = Double.parseDouble(sc.nextLine());
                        }catch (Exception e){
                            System.out.println("The value does not exist!");
                            break;
                        }
                        int resultBinary = BinarySearch.binarySearch(arrayBinary,valueBinary);
                        if(resultBinary==-1){
                            System.out.println("The value does not exist!");
                        }else {
                            System.out.println("The right position: "+resultBinary);
                        }
                        break;
                    default:
                        System.out.println();
                        System.out.println("!!!Warning: Please enter a number from 0 to 7");
                        break;
                }
        }while(!numberFunction.equals("0"));
    }
    //Nhập dữ liệu bằng tay và lưu vào INPUT.TXT
    public static void manualInput(){
        String number;
        String n;
        StringBuilder dataBuilder = new StringBuilder();
        boolean isValid=false;
        do{
            System.out.print("Type the value of n: ");
            n = sc.nextLine();

            //Nhập lại giá trị n nếu không phải số
            if(!n.matches("[0-9]+")){
                System.out.println("!!!Warning: Enter only  integer numbers, please try again");
                continue;
            }
            isValid = true;

            for(int i=0; i<Integer.parseInt(n);i++){
                //Nhập lại giá trị number nếu không phải số
                do{
                    System.out.print("Type the element "+ (i+1)+": ");
                    number = sc.nextLine();
                    if(!number.matches("-?\\d+(\\.\\d+)?")){
                        System.out.println("!!!Warning: Enter only numbers, please try again");
                    }
                }while(!number.matches("-?\\d+(\\.\\d+)?"));

                // Xây dựng chuỗi dữ liệu với các giá trị number
                dataBuilder.append(number).append("     ");
            }

            //Ghi toàn bộ các dữ liệu vào file
            TextFile.writeFile(filePath,dataBuilder.toString());

        }while (!isValid);
        System.out.println("Successfully wrote data to file.");
    }
    //Mảng lưu trữ các giá trị trong INPUT.TXT
    public static double[] fileInput(){
        List<Double> numberOfList = TextFile.readFile(filePath);
        double [] numbers = new double[numberOfList.size()];
        for(int i=0; i<numbers.length;i++){
            numbers[i] = numberOfList.get(i);
        }
        return numbers;
    }
}

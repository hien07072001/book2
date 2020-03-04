import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {


        Book book1 = new ProgrammingBook("001", "mi thuat", 120, "abc", "java", "");
        Book book2 = new ProgrammingBook("002", "am nhac", 110, "bcd", "tieng nhat", "");
        Book book3 = new ProgrammingBook("003", "li", 100, "cde", "tieng anh", "");
        Book book4 = new ProgrammingBook("004", "sinh ", 200, "fg", "java", "");
        Book book5 = new ProgrammingBook("005", "hoa", 103, "qw", "tieng y", "");

        Book book6 = new FictionBook("01", "van", 200, "Hdcg", "van hoc");
        Book book7 = new FictionBook("02", "toan", 143, "as", "toan hoc");
        Book book8 = new FictionBook("03", "gdcd", 83, "bf", "1");
        Book book9 = new FictionBook("04", "su", 56, "nsf", "su hoc");
        Book book10 = new FictionBook("05", "dia li", 53, "sd", "an");

        ArrayList<Book> arr = new ArrayList<>();
        arr.add(0,book1);
        arr.add(1,book2);
        arr.add(2,book3);
        arr.add(3,book4);
        arr.add(4,book5);
        arr.add(5,book6);
        arr.add(6,book7);
        arr.add(7,book8);
        arr.add(8,book9);
        arr.add(9,book10);


        System.out.println("Mang sau khi sap xep chon:" +selectionSort(arr));
        System.out.println("Mang sau khi sap xep chen" +insertionSort(arr));
        System.out.println("Mang sau khi sap xep noi bot" +bubbleSort(arr));
        System.out.println("Mang sau khi sap xep de quy " +binarySearch(arr,"van",arr.size()-1,0));
        int sum=0;
        for (int i=0;i<arr.size();i++){
            sum += arr.get(i).price;
        }
        System.out.println("tong so cuon sach:"+sum);
        int count=0;
        for (int i=0;i<arr.size();i++){
            if (arr.get(i) instanceof ProgrammingBook){
                if (((ProgrammingBook) arr.get(i)).language.equals("java")){
                    count++;


                }
            }
        }
        System.out.println("so luong cuon sach co ten java:"+count);
        Scanner sc=new Scanner(System.in);


        System.out.println("nhap ten cuon cuon sach ban muon tim:");
        String input=sc.nextLine();
        for (Book book:arr){
            if (book.getName().equals(input))
            System.out.println("Cuon sach ten:" +book.getName() + "Co gia la:"+book.getPrice());
        }

    }

   public static ArrayList insertionSort(ArrayList<Book>list) {

       for (int i = 1; i < list.size(); i++) {
           Book element = list.get(i);
           int j;
           for (j = i - 1; j >= 0 && list.get(j).getPrice() > element.getPrice(); j--) {
               list.set(j + 1, list.get(j));
           }
           list.set(j + 1, element);
       }
return list;

   }
   public static ArrayList selectionSort(ArrayList<Book>list){
        for (int i=0;i<list.size()-1;i++){
            Book currentMin=list.get(i);
            int indexOfMin=i;
            for (int j=i+1;j<list.size();j++){
                if (list.get(j).getPrice() <currentMin.getPrice()){
                    currentMin=list.get(j);
                    indexOfMin=j;

                }
            }
            if (indexOfMin !=i){
                list.set(indexOfMin,list.get(i));
                list.set(i,currentMin);

            }

        }
        return list;
   }
   public static ArrayList bubbleSort(ArrayList<Book>list){
        boolean needNestPass=true;
        for (int i=1;i<list.size() && needNestPass;i++){
            needNestPass=false;
            for (int j=0;j<(list.size()-i);j++){
                if (list.get(j).getPrice()>list.get(j+1).getPrice()){
                    Book temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                    needNestPass=true;
                }
            }
        }
        return list;

   }

    public static double binarySearch(ArrayList<Book> list, String name, int high, int low) {
        for (int i = 1; i < list.size(); i++) {
            Book element = list.get(i);
            int j;
            for (j = i - 1; j >= 0 && list.get(j).getPrice() > element.getPrice(); j--) {
                list.set(j + 1, list.get(j));
            }
            list.set(j + 1, element);
        }


        if (high >= low) {
            int mid = (low + high) / 2;
            int result = name.compareTo(list.get(mid).getName());
            if (result == 0) {
                return list.get(mid).getPrice();
            }
            if (result > 0) {
                return binarySearch(list, name, low, mid - 1);
            } else return binarySearch(list, name, mid + 1, low);
        }
        return -1;
    }

}



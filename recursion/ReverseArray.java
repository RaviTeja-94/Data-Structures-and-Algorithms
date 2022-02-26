package recursion;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        reverse(a,0,a.length-1);
        for (int num:
             a) {
            System.out.println(num);
        }
    }

    public static void reverse(int[] a,int i, int j) {
        if(i>j) {
            return;
        }
        swap(a, i,j);
        reverse(a, i+1, j-1);
    }

    public static void swap(int[] a, int i ,int j) {
        int temp  = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}

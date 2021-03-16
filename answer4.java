import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        System.out.println("hello");
        int[] arr = new int[]{1, 3, 4, 5, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int [] arr){
        sortInternal(arr, 0, arr.length - 1);
    }

    public static void sortInternal(int[] arr, int low, int height) {
        int i = low;
        int j = height;
        if (low > height) {
            return;
        }
        int index = arr[i];//flag
        while (i < j){
            while (i < j && arr[j] >= index) {
                j--;
            }
            if (i < j){
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < index) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
        arr[i] = index;
        sortInternal(arr, low, i - 1);
        sortInternal(arr, i + 1, height);
    }
}
class Scratch {
    public static void main(String[] args) {
        // 斐波那契递归:
        System.out.println(recursion(20));
        // 保存中间值
        System.out.println(recursionAugmentByArray(20));
        // 小于某数的最大n:
        System.out.println(numberIndexBefore(10000));
    }

    public static int recursion(int n){
        if (n == 0){
            return 0;
        }else if (n == 1 || n == 2){
            return 1;
        }else {
            return recursion(n - 1) + recursion(n - 2);
        }
    }

    public static int recursionAugmentByArray(int n){
        int [] arr = new int[n];
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return 1;
        }
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 0; i < n; i++){
            if (i > 1) {
                arr[i] = arr[i - 1] + arr[i -2];
            }
        }
        return arr[n - 1];
    }

    public static int numberIndexBefore(int n){
        int last = 0;
        int cur = 1;
        int next = last + cur;
        int cnt = 1;
        while (next < n){
            last = cur;
            cur = next;
            next = last + cur;
            cnt++;
        }
        return cnt;
    }
}
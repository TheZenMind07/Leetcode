public class CountInversions {
    static int res;
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        res = 0;
        sort(arr, 0, n-1);
        return res;
    }


    public static void sort(long[] arr, int s, int e) {
        if(s == e) return;
        int m = s + (e-s)/2;
        sort(arr, s, m);
        sort(arr, m+1, s);
        merge(arr, s, m ,e);
    }

    public static void merge(long[] arr, int s, int m, int e) {
        int s1 = m-s+1;
        int s2 = e-m;

        long[] arr1 = new long[s1];
        long[] arr2  = new long[s2];

        for(int i = s; i <=m ; i++) {
            arr1[i-s] = arr[i];
        }

        for(int i = m+1; i <=e ; i++) {
            arr2[i-m-1] = arr[i];
        }

        int k = s;
        int i = 0, j = 0;
        while(i < s1 &&  j < s2) {
            if( arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr[j++];
                res += s1 - i;
            }
        }

        while(i < s1) {
            arr[k++] = arr1[i++];
        } 

        while(j < s2) {
            arr[k++] = arr2[j++];
        }
    }
}
public class FractionalKnapsack {
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        Arrays.sort(arr, (a, b) -> b.value*a.weight - a.value*b.weight);
        int itr = 0;
        double res = 0; 
        while(w > 0 && itr < n) {
            if(w >= arr[itr].weight) {
                res += (double) arr[itr].value;
                w -= arr[itr].weight; itr++;
            } else{
                res += (double) (arr[itr].value*w)/arr[itr].weight;
                w = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] weight = {10, 40, 20, 30};
        int[] value = {60, 40, 100, 120};
        int capacity = 50;
        System.out.println("Maximum value we can obtain = " + fractionalKnapsack(weight, value, capacity));
    }
}
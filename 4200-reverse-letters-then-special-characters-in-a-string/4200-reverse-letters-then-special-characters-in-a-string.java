class Solution {
    public String reverseByType(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int i = 0, j = n - 1;
        while (i < j) {
            if (!(arr[i] >= 'a' && arr[i] <= 'z')) {
                i++;
            } else if (!(arr[j] >= 'a' && arr[j] <= 'z')) {
                j--;
            } else {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        i = 0;
        j = n - 1;
        while (i < j) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                i++;
            } else if (arr[j] >= 'a' && arr[j] <= 'z') {
                j--;
            } else {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return new String(arr);
    }
}

import java.util.Scanner;

public class Astronomer{

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    static int searchRotated(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[left] <= arr[mid]) {

                if (target >= arr[left] && target < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;

            } else {

                if (target > arr[mid] && target <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    static int firstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return ans;
    }

    static int lastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return ans;
    }

    static int minimum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid;
        }

        return arr[left];
    }

    public static void main(String[] args) {

        int[] sorted = {5, 10, 15, 20, 25, 30, 35, 40};

        int[] rotated = {20, 25, 30, 35, 40, 5, 10, 15};

        int[] repeated = {5, 10, 10, 10, 15, 20, 25};

        System.out.println("Binary Search Index : " + binarySearch(sorted, 25));

        System.out.println("Rotated Search Index : " + searchRotated(rotated, 10));

        System.out.println("First Occurrence : " + firstOccurrence(repeated, 10));

        System.out.println("Last Occurrence : " + lastOccurrence(repeated, 10));

        System.out.println("Minimum Element : " + minimum(rotated));
    }
}
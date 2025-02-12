https://algo.monster/problems/binary_search_boundary

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int findBoundary(List<Boolean> arr) {
        // WRITE YOUR BRILLIANT CODE HERE
        int trueIndex = -1;
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right -left)/2;
            if (arr.get(mid)) {
                trueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return trueIndex;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Boolean> arr = splitWords(scanner.nextLine()).stream().map(v -> v.equals("true")).collect(Collectors.toList());
        scanner.close();
        int res = findBoundary(arr);
        System.out.println(res);
    }
}

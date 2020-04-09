package com.erikriosetiawan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    /**
     * Complete the pageCount
     */
    static int pageCount(int n, int p) {
        Map<Integer, List<Integer>> pageCounts = new HashMap<>();

        int pageNumber = 0;

        for (int i = 0; i < n / 2 + 1; i++) {
            List<Integer> pages = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                pages.add(pageNumber);
                pageNumber++;
            }

            pageCounts.put(i, pages);
        }

        List<Integer> pages = new ArrayList<>();

        if (p % 2 == 0) {
            pages.add(p);
            pages.add(p + 1);
        } else {
            pages.add(p - 1);
            pages.add(p);
        }

        List<Integer> pageEnd = new ArrayList<>();

        if (n % 2 == 0) {
            pageEnd.add(n);
            pageEnd.add(n + 1);
        } else {
            pageEnd.add(n - 1);
            pageEnd.add(n);
        }

        int page = 0;
        int lastPage = 0;
        Set<Integer> allPages = pageCounts.keySet();

        for (int i : allPages) {
            if (pageCounts.get(i).equals(pages)) {
                page = i;
            }

            if (pageCounts.get(i).equals(pageEnd)) {
                lastPage = i;
            }
        }

        int pageCountStart = page;
        int pageCountEnd = lastPage - page;

        if (pageCountStart < pageCountEnd) {
            return pageCountStart;
        }

        return pageCountEnd;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
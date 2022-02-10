package com.D_0210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1967 {
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= num; i++)
            graph.add(new ArrayList<Integer>());

        for (int i = 0; i < num - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(end).add(start);
        }
    }
}

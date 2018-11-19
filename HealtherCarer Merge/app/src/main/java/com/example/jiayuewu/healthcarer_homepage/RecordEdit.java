package com.example.jiayuewu.healthcarer_homepage;

import java.util.ArrayList;
import java.util.List;

public class RecordEdit {

    public class TestList {
        public void main(String[] args) {
            List<List<Integer>> problem = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                List<Integer> record = new ArrayList<Integer>();
                for (int j = 0; j <= 5; j++) {
                    record.add(j);
                }
                problem.add(record);
            }
        }
    }

}

package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class App {

    public static List<String> findStudentsWithIncompleteVolunteerEvents(List<String> students, Map<String, List<String>> attendeesMapping) {
        List<String> vols = new ArrayList<>();
        List<String> incomple_students = new ArrayList<>();
        
        attendeesMapping.forEach((fundraiser, students_present) -> students_present.forEach((student) -> vols.add(student)));
        
        for (String student : students) {
            int num_occs = 0;
            for (String stu : vols) {
                if (stu == student) {
                    num_occs++;
                }
            }
            if (num_occs < 2) {
                incomple_students.add(student);
            }
        }
        
        return incomple_students;
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }

}

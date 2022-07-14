package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "MyTeam";
        } else if (query.contains("what is")) { // TODO extend the programm here
            String[] arr = query.split(" ");
            return String.valueOf(
                    Integer.parseInt(arr[arr.length - 3].replaceAll("[^\\d.]", "").strip())
                            + Integer.parseInt(arr[arr.length - 1].replaceAll("[^\\d.]", "").strip())
            );
        } else if (query.contains("which of the following")) {
            String[] arr = query.split("largest:");
            return Arrays.stream(arr[1].split(","))
                    .map(i -> Integer.parseInt(i.replaceAll("[^\\d.]", "").strip()))
                    .max(Integer::compareTo).toString();
        } else {
            return "";
        }
    }
}

package de.tum.in.ase.eist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;

@Service
public class QueryProcessor {

    private final Logger logger = LoggerFactory.getLogger(QueryProcessor.class);


    public String process(String query) {
        query = query.toLowerCase();
        String res;
        if (query.contains("shakespeare")) {
            res = "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            res = "MyTeam";
        } else if (query.contains("plus")) { // TODO extend the programm here
            String[] arr = query.split(" ");
            res = String.valueOf(
                    Integer.parseInt(arr[arr.length - 3].replaceAll("[^\\d.]", "").strip())
                            + Integer.parseInt(arr[arr.length - 1].replaceAll("[^\\d.]", "").strip())
            );
        } else if (query.contains("multiplied")) { // TODO extend the programm here
            String[] arr = query.split(" ");
            res = String.valueOf(
                    Integer.parseInt(arr[arr.length - 4].replaceAll("[^\\d.]", "").strip())
                            * Integer.parseInt(arr[arr.length - 1].replaceAll("[^\\d.]", "").strip())
            );
        } else if (query.contains("which of the following")) {
            String[] arr = query.split("largest:");
            res = Arrays.stream(arr[1].split(","))
                    .map(i -> Integer.parseInt(i.replaceAll("[^\\d.]", "").strip()))
                    .max(Integer::compareTo).get().toString();
        } else if (query.contains("square")) {
            String[] arr = query.split("cube:");
//            res = Arrays.stream(arr[1].split(","))
//                    .map(i -> Integer.parseInt(i.replaceAll("[^\\d.]", "").strip()))
//                    .filter(i -> ).get().toString();
            res = "1";
        } else {
            res = "";
        }
        logger.info("Query" + query + " Ergebnis " + res);
        return res;
    }
}

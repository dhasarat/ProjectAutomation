package com.schrack.sfsAutomation.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaUtil {

    public static boolean areEqual(Map<String, String> first, Map<String, String> second) {
        boolean flag = true;
        if (first.size() != second.size()) {
            flag = false;
        }

        if (!first.entrySet().stream().allMatch(e -> e.getValue().equals(second.get(e.getKey())))) {
            flag = false;
            first.entrySet().stream().forEach(e -> {
                if (!e.getValue().equals(second.get(e.getKey()))) {
                    Log.info("Value in first map: " + e.getValue() + " | " + "value is second map: "
                            + second.get(e.getKey()));
                }

            });
        } else {
            first.entrySet().stream().forEach(e -> {
                if (e.getValue().equals(second.get(e.getKey()))) {
                    Log.info("actual: " + e.getValue() + " = " + "expected: " + second.get(e.getKey()));
                }

            });
        }
        return flag;
    }


}

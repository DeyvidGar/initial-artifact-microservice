package com.deyvis.initialartifactms.utils;

import com.deyvis.initialartifactms.constants.MagicValuesConstants;
import java.util.Arrays;

/**
 * Class that utilities for the microservice.
 *
 * @author David G.
 * @version 1.0
 */
public class AppUtils {

    /**
     * This method concat the objects in a string with StringBuilder.
     *
     * @param objects values to concat.
     * @return the string value of StringBuilder.
     */
    public static String stringBuilder(Object... objects) {
        if (objects.length == MagicValuesConstants.ZERO_INT) {
            return MagicValuesConstants.EMPYT_STRING;
        }

        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(objects)
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

}

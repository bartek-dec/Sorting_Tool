package com.example.util;

import java.util.List;
import java.util.Objects;

public class Validator {

    public String checkDataParameters(List<String> parameters) {
        int index;
        String validType = null;
        String type;
        if (parameters.contains(Params.DATA_TYPE)) {
            index = parameters.indexOf(Params.DATA_TYPE);
            try {
                index++;
                type = parameters.get(index);
                while (!Objects.equals(type, Params.SORTING_TYPE) &&
                        !Objects.equals(type, Params.INPUT_FILE) &&
                        !Objects.equals(type, Params.OUTPUT_FILE)) {

                    if (Objects.equals(type, Params.LONG) ||
                            Objects.equals(type, Params.WORD) ||
                            Objects.equals(type, Params.LINE)) {
                        validType = type;
                    } else {
                        System.out.println("\"" + type + "\" isn't a valid parameter. It's skipped.");
                    }
                    index++;
                    type = parameters.get(index);
                }
            } catch (IndexOutOfBoundsException e) {
                if (!Objects.equals(validType, Params.LONG) &&
                        !Objects.equals(validType, Params.WORD) &&
                        !Objects.equals(validType, Params.LINE)) {
                    System.out.println("No data type defined!");
                    return null;
                }
            }

            if (!Objects.equals(validType, Params.LONG) &&
                    !Objects.equals(validType, Params.WORD) &&
                    !Objects.equals(validType, Params.LINE)) {
                System.out.println("No data type defined!");
                return null;
            }
        } else {
            validType = Params.WORD;
        }
        return validType;
    }

    public String checkSortingParameters(List<String> parameters) {
        int index;
        String validSort = null;
        String sort;
        if (parameters.contains(Params.SORTING_TYPE)) {
            index = parameters.indexOf(Params.SORTING_TYPE);
            try {
                index++;
                sort = parameters.get(index);
                while (!Objects.equals(sort, Params.DATA_TYPE) &&
                        !Objects.equals(sort, Params.INPUT_FILE) &&
                        !Objects.equals(sort, Params.OUTPUT_FILE)) {

                    if (Objects.equals(sort, Params.NATURAL) ||
                            Objects.equals(sort, Params.BY_COUNT)) {
                        validSort = sort;
                    } else {
                        System.out.println("\"" + sort + "\" isn't a valid parameter. It's skipped.");
                    }
                    index++;
                    sort = parameters.get(index);
                }
            } catch (IndexOutOfBoundsException e) {
                if (!Objects.equals(validSort, Params.NATURAL) &&
                        !Objects.equals(validSort, Params.BY_COUNT)) {
                    System.out.println("No sorting type defined!");
                    return null;
                }
            }

            if (!Objects.equals(validSort, Params.NATURAL) &&
                    !Objects.equals(validSort, Params.BY_COUNT)) {
                System.out.println("No sorting type defined!");
                return null;
            }
        } else {
            validSort = Params.NATURAL;
        }
        return validSort;
    }

    public String checkInputOutputParameters(List<String> parameters, String toCheck, String remaining, String name) {
        int index;
        String validInputName = "";
        String inputName;
        if (parameters.contains(toCheck)) {
            index = parameters.indexOf(toCheck);
            try {
                index++;
                inputName = parameters.get(index);
                while (!Objects.equals(inputName, Params.DATA_TYPE) &&
                        !Objects.equals(inputName, Params.SORTING_TYPE) &&
                        !Objects.equals(inputName, remaining)) {

                    if (inputName.matches(Params.MATCHER)) {
                        validInputName = inputName;
                    } else {
                        System.out.println("\"" + inputName + "\" isn't a valid parameter. It's skipped.");
                    }
                    index++;
                    inputName = parameters.get(index);
                }
            } catch (IndexOutOfBoundsException e) {
                if (!validInputName.matches(Params.MATCHER)) {
                    System.out.println("No " + name + " file defined!");
                    return validInputName;
                }
            }

            if (!validInputName.matches(Params.MATCHER)) {
                System.out.println("No " + name + " file defined!");
                return validInputName;
            }
        } else {
            return null;
        }
        return validInputName;
    }
}

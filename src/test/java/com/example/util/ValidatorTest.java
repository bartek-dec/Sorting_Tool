package com.example.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private Validator validator;
    private List<String> parameters1;
    private List<String> parameters2;
    private List<String> parameters3;
    private List<String> parameters4;
    private List<String> parameters5;

    @BeforeEach
    void setUp() {
        validator = new Validator();
        parameters1 = Arrays.asList("-sortingType", "byCount", "-dataType", "long");
        parameters2 = Arrays.asList("-sortingType");
        parameters3 = Arrays.asList("-dataType", "line", "-sortingType", "natural", "-abc", "-def");
        parameters4 = Arrays.asList("-sortingType", "byCount", "-inputFile", "data.dat", "-outputFile", "out.txt");
        parameters5 = Arrays.asList("-sortingType", "byCount", "-inputFile", "data.dat123", "-outputFile");
    }

    @Test
    void checkDataParameters_Expected_long() {
        assertEquals("long", validator.checkDataParameters(parameters1));
    }

    @Test
    void checkDataParameters_Expected_word() {
        assertEquals("word", validator.checkDataParameters(parameters2));
    }

    @Test
    void checkDataParameters_Expected_line() {
        assertEquals("line", validator.checkDataParameters(parameters3));
    }

    @Test
    void checkSortingParameters_Expected_byCount() {
        assertEquals("byCount", validator.checkSortingParameters(parameters1));
    }

    @Test
    void checkSortingParameters_Expected_null() {
        assertNull(validator.checkSortingParameters(parameters2));
    }

    @Test
    void checkSortingParameters_Expected_natural() {
        assertEquals("natural", validator.checkSortingParameters(parameters3));
    }

    @Test
    void checkInputOutputParameters_Expected_null_ForBoth() {
        assertNull(validator.checkInputOutputParameters(parameters1, Params.INPUT_FILE, Params.OUTPUT_FILE, "input"));
        assertNull(validator.checkInputOutputParameters(parameters1, Params.OUTPUT_FILE, Params.INPUT_FILE, "output"));
    }

    @Test
    void checkInputOutputParameters_Expected_data_dat_ForInput() {
        assertEquals("data.dat", validator.checkInputOutputParameters(parameters4,
                Params.INPUT_FILE, Params.OUTPUT_FILE, "input"));
    }

    @Test
    void checkInputOutputParameters_Expected_emptyString_ForInput() {
        assertEquals("", validator.checkInputOutputParameters(parameters5,
                Params.INPUT_FILE, Params.OUTPUT_FILE, "input"));
    }

    @Test
    void checkInputOutputParameters_Expected_out_txt_ForOutput() {
        assertEquals("out.txt", validator.checkInputOutputParameters(parameters4,
                Params.OUTPUT_FILE, Params.INPUT_FILE, "output"));
    }

    @Test
    void checkInputOutputParameters_Expected_emptyString_ForOutput() {
        assertEquals("", validator.checkInputOutputParameters(parameters5,
                Params.OUTPUT_FILE, Params.INPUT_FILE, "output"));
    }
}
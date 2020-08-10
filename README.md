# Sorting-Tool

### This is a console project to sort textual and numeric data.
### Program works with the following command-line arguments:
#### -dataType (long, word, line) which corresponds to the numbers, words and lines respectively. If command is not present, then default mode is "word". If command is present but not followed by the mode than program terminates.
#### -sortingType (natural, byCount) which corresponds to ascending order by value or to ascending order by the number of occurrences. If command is not present, then default mode is "natural". If command is present but not followed by the mode than program terminates.
#### -inputFile (filename) corresponds to the file with data. If this command is not present, then by default, program reads data from the console. If command is present but not followed by the file name than program terminates. If command is present, followed by the file name than program reads inputs from the file and displays to the console errors (if any).
#### -outputFile (filename) corresponds to the file with saved results. If this command is not present, then by default, program displays results to the console. If command is present but not followed by the file name than program terminates.

### Example 1
#### -sortingType byCount -inputFile input.txt

#### Program reads data from the file input.txt. It interprets data as words (since no -dataType), sorts data by number of occurrences and displays data to the console.

### Example 2
#### -dataType long -sortingType natural -abc -def

#### Program reads data from the console. It interprets data as numbers and displays data to the console. Before the data, program also displays the following errors to the console:
#### -abc" isn't a valid parameter. It's skipped.
#### -def" isn't a valid parameter. It's skipped.
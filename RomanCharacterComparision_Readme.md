Question 1 - Royal Rumble (Java only)

An ordinal number is a word representing rank or sequential order. The naming convention for royal names is to follow a given name with an ordinal number using a Roman numeral to indicate the birth order of two people of the same name.

The Roman numerals from 1 to 50 are defined as follows: The numbers 1 through 10 are written I, II, III, IV, V, VI, VII, VIII, IX, and X. The Roman numerals corresponding to the numbers 20, 30, 40, and 50 are XX, XXX, XL, and L. For any other two-digit number < 50, its Roman numeral representation is constructed by concatenating the numeral(s) for its multiples of ten with the numeral(s) for its values < 10. For example, 47 is 40 + 7 = "XL" + "VII" = "XLVII".

In this challenge, you will be given a list of royal name strings consisting of a given name followed by an ordinal number. You must sort the list first alphabetically by name, then by ordinal increasing within any given name.

For example, if you are given the royal names [George VI, William II, Elizabeth I, William I] the result of the sort is [Elizabeth I, George VI, William I, William II].

Function Description Create a function called getSortedList. The function must return the array sorted first by given name, then by ordinal.

getSortedList has the following parameter:

names[names[0],...names[n-1]]: an array of royal name strings "given ordinal"

Constraints:

1 = n = 50
Each names[i] is a single string composed of 2 space-separated values: firstName and ordinal.
ordinal is a valid Roman numeral representing a number between 1 and 50, inclusive.
1 = |firstName| = 20
Each firstName starts with an uppercase letter ascii[A-Z] and its remaining characters are lowercase letters ascii[a-z].
The elements in names are pairwise distinct.

Sample Input:

Louis IX
Louis VIII
David II

Sample Output:

David II
Louis VIII
Louis IX


How to build and run the program:

# Before you run

1. Get the latest version of JDK.


#Build Commands

javac -d . RomanCharacterComparision.java

This should result in compilation of program

# Execution Commands

From the java source directory run the below command.

java com.taiger.romannamescompare.RomanNamesComparision


# Input:

Input is fed in the java class

Louis IX
Louis VIII
David II

# Output:

David II
Louis VIII
Louis IX


#Approach to the Problem

1)Create a treeset by overwriting the comparator to check the roman numeral and accordingly store the values in the treeset



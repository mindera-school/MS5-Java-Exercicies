# Streams

This is a simple Java program that uses streams to manipulate a string of song lyrics for "Mercedes Benz" by Janis Joplin.

# Purpose

The purpose of this program is to demonstrate the use of Java streams to manipulate strings.

# How to Use

To use this program, simply copy the code into a Java IDE or text editor and run the main() method. The program will output the modified lyrics to the console.

# Program Logic

This program takes a string of song lyrics and splits it into an array of words using the split() method. It then uses a stream to filter out any words that are equal to the string "trash" using the filter() method. Next, the map() method is used to convert each remaining word to uppercase and add a space character after it. Finally, the forEach() method is used to print each resulting word to the console using the System.out::print method reference.

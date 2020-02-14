# Problem Statement

Question 3 - Zombie Clustering (Java only)

There are zombies in Seattle. Liv and Ravi are trying to track them down to find out who is creating new zombies in an effort to prevent an apocalypse. Other than the patient-zero zombies (who became so by mixing MaxRager and tainted Utopium), new people only become zombies after being scratched by an existing zombie. Zombiism is transitive. This means that if zombie 0 knows zombie 1 and zombie 1 knows zombie 2, then zombie 0 is connected to zombie 2 by way of knowing zombie 1. A zombie cluster is a group of zombies who are directly or indirectly linked through the other zombies they know, such as the one who scratched them or supplies who them with brains.

The diagram showing connectedness will be made up of a number of binary strings, characters 0 or 1. Each of the characters in the string represents whether the zombie associated with a row element is connected to the zombie at that character's index. For instance, a zombie 0 with a connectedness string '110' is connected to zombies 0 (itself) and zombie 1, but not to zombie 2. The complete matrix of zombie connectedness is:

110
110
001

Zombies 0 and 1 are connected in a group. Zombie 2 is alone in a separate group.

Your task is to determine the number of connected groups of zombies, or clusters, in a given matrix.

Constraints:

1 = n = 300
0 = i < n
|zombies| = n
Each zombies[i] contains a binary string of n zeroes and ones. It is a square matrix.

Sample Input:

1100
1110
0110
0001

Sample Output:

2

Sample Input:

1001
0100
0010
1001

Sample Output:

3

How to build and run the program:

# Before you run

1. Get the latest version of JDK.


#Build Commands

javac -d . ZombieCluster.java

This should result in compilation of program

# Execution Commands

From the java source directory run the below command.

java com.taiger.zombies.ZombieCluster


# Input:

Input is fed in the java class

1001
0100
0010
1001

# Output:
3

#Approach to the Problem

1)Firstly establish how each zombie is connected to other zombies and store it a HashMap with key as index and the ArrayList to store the connectedness
Ex: 0,[0,1] indicates zombie 0 is connected to zombie 0(itself) and zombie 1

2)Iterate through the connectedness HashMap and create zombie clusters by comparing if a zombie is present in the zombie cluster or not
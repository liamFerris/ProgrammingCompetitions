# North-West European Regional Contest

## E - Exam Redistribution

Linda is giving an exam. When the exam is over, Linda
will redistribute the exams among the students for a peer
review, so they may grade each other’s answers and assign
preliminary scores.
The students are split up in several rooms of varying sizes.
Linda has devised the following scheme for redistributing
the exams:

1. Linda visits the first room, picks up all exams written
there, and places them in a pile.
2. In each subsequent room Linda takes exams from the
top of her pile and randomly distributes them to the
students in the room. She then picks up all exams
written in that room and adds them to the bottom of
her pile.
3. After having visited each room exactly once, Linda
returns to the first room, and distributes the remaining
exams from her pile there.
Naturally, it is imperative that no student receives their own exam to review, and that Linda
does not run out of exams in her pile while doing the redistribution (i.e., that when entering a
room after the first one, Linda’s pile contains at least as many exams as there are students in
the room). Whether or not this is the case depends on the order in which the rooms are visited.
We say that an ordering of the rooms is safe if Linda will not run out of exams in her pile when
visiting rooms in that order, and that there is no chance that any student receives their own exam
to review.
Can you find a safe order in which to visit the rooms (or determine that no safe order exists)?

### Input
The input consists of:<br>
• one line containing an integer n (2 ≤ n ≤ 30), the number of rooms.<br>
• one line containing n integers s1, . . . , sn (1 ≤ si ≤ 100 for each i), where si
is the number
of students in room i.<br>
### Output
If it is impossible to redistribute the exams safely, output “impossible”. Otherwise, output a
safe order in which to visit the rooms. If there are multiple safe orders, you may give any of them.<br>

| Sample Input 1  | Sample Output 1 |
| --------------- | --------------- |
| 4               | 2 3 4 1         | 
| 2 3 3 1         |                 |

| Sample Input 2  | Sample Output 2 |
| --------------- | --------------- |
| 2               | impossible      | 
| 10 20           |                 |

## H - Hamiltonian HyperCube

Hypercube graphs are fascinatingly regular, hence you have devoted a lot of time studying the
mathematics related to them. The vertices of a hypercube graph of dimension n are all binary
strings of length n, and two vertices are connected if they differ in a single position. There are
many interesting relationships between hypercube graphs and error-correcting code.
One such relationship concerns the n-bit Gray Code, which is an ordering of the binary strings
of length n, defined recursively as follows. The sequence of words in the n-bit code first consists
of the words of the (n − 1)-bit code, each prepended by a 0, followed by the same words in
reverse order, each prepended by a 1. The 1-bit Gray Code just consists of a 0 and a 1. For
example the 3-bit Gray Code is the following sequence:


000, 001, 011, 010, 110, 111, 101, 100


Now, the n-bit Gray Code forms a Hamiltonian path in the n-dimensional hypercube, i.e., a path
that visits every vertex exactly once (see Figure H.1).

You wonder how many vertices there are between the vertices 0^n (n zeros) and 1^n (n ones) on that path. Obviously it will be somewhere between 2^n−1 −1 and 2^n −2, since in general 0^n is the first vertex, and 1^n
is somewhere in the second half of the path. After finding an elegant answer to this question you ask yourself whether you can generalise the answer by writing a program that can determine the number of vertices between two arbitrary vertices of the hypercube, in the path corresponding to the Gray Code.

### Input
The input consists of a single line, containing:<br>
• one integer n (1 ≤ n ≤ 60), the dimension of the hypercube<br>
• two binary strings a and b, both of length n, where a appears before b in the n-bit Gray
Code.<br>
### Output
Output the number of code words between a and b in the n-bit Gray Code.<br>

| Sample Input 1  | Sample Output 1 |
| --------------- | --------------- |
| 3 001 111       | 3               |

| Sample Input 2  | Sample Output 2 |
| --------------- | --------------- |
| 3 110 100       | 2               |

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

## I - Iron and Coal

There are many excellent strategy board games, and
your favourite among them is called “Steel Age”. It
offers many different paths to victory but you prefer
the blood-and-fire-strategy: build as many soldiers as
possible and club your opposition into submission. To
be able to build soldiers you need two resources: iron
ore and coal.

The board consists of different cells numbered from 1
to n which can contain resources. The rules for moving
from one cell to another are rather complicated: if you
can move from cell A to cell B, it does not always mean
that you can also move from B to A. For example, if
two cells are connected by a river, then you may be able
to move downstream, but not upstream, so long as you
didn’t invent a steam engine; however, it still could be
possible to reach the upstream cell by using roads and taking a detour over other cells.
At the beginning of the game you own only one such cell, where all your settlers are located.
At every move you are allowed to move an arbitrary number of settlers from a cell to one of
its accessible neighbours. By moving your settlers into a cell for the first time, you “claim” it.
Every claimed cell will bind one settler, which has to stay in this cell until the end of the game.
However, there is no need to leave a settler in your initial cell because it is where your palace is
located and thus the cell stays claimed for all time.

Your goal is to claim at least one cell containing the resource “iron ore” and at least one cell
with resource “coal” in order to be able to build soldiers. What is the minimal number of settlers
you need to reach this goal?

### Input
The input consists of:
• One line with three integers n (2 ≤ n ≤ 105
), the number of cells on the playing field, m
(1 ≤ m < n), the number of cells containing iron ore, and k (1 ≤ k < n), the number of
cells containing coal.<br>
• One line with m distinct integers o1, . . . , om (1 ≤ oi ≤ n for all 1 ≤ i ≤ m), where
o1, . . . , om are the IDs of cells with iron ore.<br>
• One line with k distinct integers c1, . . . , ck (1 ≤ ci ≤ n for all 1 ≤ i ≤ k), where
c1, . . . , ck are the IDs of cells with coal.<br>
• n lines describing the topology of the board. The j-th line of this block specifies the
accessible neighbours of the j-th cell and consists of the following integers:<br>
– One integer 0 ≤ a ≤ 10, the number of cells accessible from cell j.<br>
– a distinct integers b1, . . . , ba (1 ≤ bi ≤ n, bi 6= j for all 1 ≤ i ≤ a), the IDs of the
cells accessible from cell j.<br>
It is guaranteed, that no cell contains both resources, iron ore and coal. At the beginning of the
game you own only the cell with ID 1.<br>
### Output
Output the minimum number of settlers needed to claim at least one cell with coal and at least
one cell with iron ore. Output “impossible” if it is impossible to own both, coal and iron
ore.<br>

| Sample Input 1  | Sample Output 1 |
| --------------- | --------------- |
| 3 1 1           | 2               |
| 2               |                 |
| 3               |                 |
| 1 2             |                 |
| 2 3 1           |                 |
| 1 1             |                 |

| Sample Input 2  | Sample Output 2 |
| --------------- | --------------- |
| 3 1 1           | impossible      |
| 2               |                 |
| 3               |                 |
| 1 2             |                 |
| 1 1             |                 |
| 2 1 2           |                 |

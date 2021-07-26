1. You are given a partially written BinaryTree class.
2. You are required to complete the body of transBackFromLeftClonedTree function. The function is expected to convert a left-cloned tree back to it's original form. In a left-clone tree a new node for every node equal in value to it is inserted between itself and it's left child. 
3. Input and Output is managed for you.


# Sample Input

37

50 50 25 25 12 12 n n n n 37 37 30 30 n n n n n n 75 75 62 62 n n 70 70 n n n n 87 87 n n n

# Sample Output

25 <- 50 -> 75

12 <- 25 -> 37

. <- 12 -> .

30 <- 37 -> .

. <- 30 -> .

62 <- 75 -> 87

. <- 62 -> 70

. <- 70 -> .

. <- 87 -> .
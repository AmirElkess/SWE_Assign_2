### Task 4

**The code snippet:** <br>
![img_2.png](img_2.png)

**Question 1: Given the following tests of the structure (x,y): {(0,0); (10,17)}**

**Q:** Can full branch coverage be achieved? Provide an argumentation for your answer. <br>
**A:** The function has two if-else pairs. The first if statement (first branch: x < y) is covered by the second test case (10,17), and the else branch is covered by the first test case of (0, 0).
The second if-else pair is complementing the first if-else pair. The if statement is covered by the (0, 0) test case, and the else branch is covered by the (10, 17) test case.
<br>

**Q:** Can full statement coverage be achieved? Provide an argumentation for your answer. <br>
**A:** all the 4 branches are covered, so full statement coverage is also achieved.

**Question 2:**

Like shown in question 1, the minimum number of test cases to achieve full branch and test coverage is 2, since one test case cannot test an if-else pair completely.
```java
public class RelationCheckerTest {
    @Test
    void testCase1() {
        assertEquals(0, RelationChecker.checkRelation(0, 0));
    }

    @Test
    void testCase2() {
        assertEquals(22, RelationChecker.checkRelation(10, 17));
    }
}
```
Both test cases pass and achieve full branch and statement coverage:
![img_3.png](img_3.png)
# Lab work #1. Systems of linear algebraic equations. Gaussian method.

In the laboratory work, you are invited to implement one of the methods that would allow you to find a column of unknowns for a system of linear algebraic equations. 
The size of the system is assumed to be limited to 20, which means that your program after implementation will need to be checked on a matrix of 20 x 20 + 20 elements 
(the number of unknowns in matrix A and column B). Based on this condition, matrices of this size should be able to somehow get into your numerical method. For example, 
manual data entry can be difficult for 420 system elements with 20 unknowns. Traditionally, it is proposed to make the following methods for entering data into the program:

• User input;

• Data input from a file;

• Generation of random matrices.

User input allows you to test the program relatively simply and does not require additional 
effort on the part of the developer, however, for the same reason, it can be replaced solely by input from a file. On the other hand, if such an input already exists, 
why not make it user-friendly? For example, if the user enters incorrect data (letters instead of numbers, two commas or a dot instead of a comma in real numbers, 
a space between a number and a minus sign - everything that cannot be recognized as a number; incorrect amount of data; matrix, determinant which will indicate 
the absence of solutions; a negative value of the matrix size, etc.) user input should be interrupted with a request for re-entry as early as possible, and 
not continue to request data to report an error at the very end. It should be especially noted that all such user input error scenarios must be handled, 
and not only for input through the terminal, but also for, for example, data input from a file. Data input from a file seems to be a good way to check 
the correctness of the numerical method, especially when These are large matrices. When entering data from the terminal, it is quite possible to make 
a mistake, and when generating a random matrix, the result is difficult to check. When working with data files, it is necessary to think over the format 
of the data with which the work will be carried out: what data is contained in the file itself, and what data is entered separately by the user. For example, 
for iterative methods, the data file will contain the size of the matrix and the matrix itself, and the approximation accuracy will be set by the user. 
It is also necessary to think over the issue of localization: what sign for real numbers will you use: a dot or a comma. For self-checking of the numerical method, 
several files with solutions were uploaded in the Moodle system and in the VK group. When defending a laboratory work, the teacher may ask you to demonstrate 
the work of your program on some other file in order to check whether your implemented numerical method calculates the result accurately enough. 
Random matrix generation can be implemented in two main ways:

• Simple matrix generation A, which satisfies the conditions of applicability of the method, and column B; 

• Generation of a column of unknowns and generation of matrix A, which satisfies the conditions of applicability of the method, then calculation of the right 
side of the equations and "forgetting" the column of unknowns. In this case, you can compare the calculated and "hidden" values of the unknowns. 

Please note that in both cases it makes sense to generate only matrices that have a solution to the numerical method you are implementing. 
The larger the size of the matrix, the less likely it will be to generate a matrix that will fit the conditions of applicability of the method! 
This is especially true for iterative methods. Please note that the conditions for the convergence of iterative processes for the methods of simple iteration 
and for the Gauss-Seidel method are different. 

In the report on the laboratory work, in the section with examples, you will need to insert, among other things, 
an example with a matrix of some size larger than is usually considered, for example, systems with 5-6 unknowns. The derivation of matrices 
of systems with 20 unknowns can be demonstrated on the defense of the work, however, they usually fit poorly in the report. 

When analyzing the implemented numerical method, 
you need to run it on different data sets, and also try to understand whether the program works correctly on this data set, if not works, should it work, and if not, why not.

It is also proposed to analyze the speed of the numerical method. This can be done by comparing 16 the analytical value of the algorithmic complexity of the method 
(according to the previously compiled flowchart) and by real measurements of the speed of the numerical method using various tools of the programming language you have chosen. 
For example, in Python, you can use the datetime.datetime.now() command before and after calling a numerical method, and then subtract the resulting values. 
Similarly, in Java, you can use System.currentTimeMillis(). You can also use various tools to analyze the memory consumed.

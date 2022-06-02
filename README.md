# Computational mathematics

## Short description
My implimenation of computational mathematics (a.k.a. numerical methods) course at ITMO University, 2nd year of stydying.
The course includes five labs. Each of them is a program that implements some numerical method that solves the problem 
under user-selected conditions. To write these programs, I chose the Java language. Assignments indicated by the teacher are presented.

## Lab work #1. Systems of linear algebraic equations. Gaussian method.
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

## Lab work #2. Systems of nonlinear equations. Bisection and chord methods. Simple iteration method.

In Lab 2, you will need to implement three numerical methods. Two of them will solve non-linear equations and one more will solve a system of non-linear equations.

Due to the fact that you are offered to implement 2 methods for solving nonlinear equations, it makes sense to compare the result obtained between each other. F
or example, by solving the equation using the bisection method, we got 5.1, and by the chord method we got 4.9, then the difference between the two methods will be 0.2. 
Accordingly, the calculation of two methods for one equation should be carried out simultaneously, without specifying from the user which numerical 
method he would like to calculate the equation.

The student is invited to choose non-linear equations and systems of non-linear equations on their own. However, it is necessary to take into account 
the range of permissible values. For examples, you can choose both non-linear algebraic and non-algebraic non-linear equations.

## Lab work #3. Numerical integration. Simpson method.

When calculating the integral, it is necessary to take into account the ODZ functions and the necessary and sufficient conditions
for the existence of a certain integral. If there is a removable discontinuity of the first kind on the integration interval, 
then it should be eliminated in one of the ways (with the user specifying exactly how you are going to eliminate it) and the integral should 
be calculated. For example, the calculation of the left part of the integral from the discontinuity and the right part separately can be performed. 
An alternative method for eliminating the gap is to take an algorithmic average of the value from two adjacent points of the function 𝑓(𝑥−𝜀),𝑓(𝑥+𝜀), 
where 𝜀 is a predetermined small constant, which may depend on the current step of partitioning the integral. In both cases, you must consider the 
strategy of the algorithm for eliminating the gap when it hits the very boundary of the interval.

An important issue that needs to be considered in this laboratory work is the error of the quadrature integration formulas, respectively, 
denoted as 𝑟𝑖 on each partition of the integral and 𝑅 on the global interval [𝑎;𝑏] on which the function is integrated. Based on the fact that the integral, 
by definition, is the limit of the sum of infinitesimal partitions, without specifying exactly how this partition will be performed, then in the 
limit absolutely all methods of numerical integration will give the correct result if they are applied correctly. Therefore, to compare methods with each other, 
one should analyze the maximum value of the partitioning step, or the number of partitions (especially for methods with a dynamic rather than a constant step). 
This can be done directly by comparing the obtained value of the integral with its analytical value, calculated, for example, using the Newton-Leibniz formula or 
tabular values of the integral. However, for global conclusions, it is also necessary to analyze the errors of the quadrature formulas 𝑅 themselves, 
which also give an answer to which functions should be integrated using certain numerical integration methods. Your reasoning, observations and results 
of the analysis should form the basis of the conclusion in this laboratory work.

## Lab work #4. Interpolation and approximation. Least square method.

Please note that starting from this laboratory work, you need to build graphs of functions. On the graph, you need to display the initial points and points obtained using the developed numerical method, according to the option.

In all cases, you need to generate a set of input points on which you will test your program. The set of points must be a number of (x;y) pairs obtained from some existing function. To generate such a data set, it is recommended to use a prepared function whose behavior you already know. It is preferable to have multiple inputs from multiple functions. Also
it is desirable to add noise (deviations of y values from the mathematical one). It also makes sense to display on the graph the function on the basis of which the data set was obtained. there should be a point that has the largest squared deviation after the first run.

In other words, the algorithm is as follows:
1. An arbitrary (previously obtained) set of values of pairs (𝑥;𝑦) is specified.
2. The approximating function is set.
3. The program calculates the coefficients of the approximating function.
4. A search is made for the point with the largest deviation from the value obtained using the approximating polynomial.
5. The found point is excluded and the coefficients of the approximating polynomial are recalculated (see item 3).
6. A graph is built that contains two functions (1 - before elimination, 2 - after elimination and recalculation) and a set of initially specified points (pairs of values ​​(𝑥,𝑦)).
7. In addition, the obtained values of the approximating coefficients are displayed separately on the screen.

Several of the most popular approximating functions should be chosen as an approximating function: linear, quadratic, logarithmic, trigonometric, etc.

To calculate the SLAE, it is recommended to use the methods for solving the SLAE from laboratory work 1.

When analyzing methods in laboratory work, attention should be paid to scenarios for their application, based on the features of the methods.

## Laboratory work 5. Numerical differentiation and the Cauchy problem. Milne method.

In laboratory work 5, you will be asked to implement one of the methods for solving the Cauchy problem - solving a differential 
equation for given initial conditions.

One step methods:
* Euler method
* Improved Euler method (not to be confused with the improved Euler method)
* Runge-Kutta method of the 4th order

Multi-step methods:
* Milne method
* Adams method (not to be confused with the Adams-Bashfort method)

In the lab, you are asked to prepare a number of differential equations that the user can solve by entering their 
own initial conditions. In addition, it is assumed that the user can choose how far the differential equation 
should be solved from the initial condition. When analyzing and demonstrating laboratory work, it is recommended 
to explore not only various differential 20 equation, but also different initial conditions for one differential equation - 
the graph of the solution will probably change in this case. The graph must show the initial condition and the resulting 
solution of the differential equation. It is also useful to display the analytical solution of the differential equation 
in order to be able to compare and analyze the accumulation or non-accumulation of the error. The approximation in both cases 
(for the analytical and for the obtained solution) must be performed according to the method from laboratory work 4 
(if in laboratory work 4 your option was an approximation, then double the number of graphs– before and after deleting points, 
as in laboratory work 4 - it is not necessary to draw, the method should be applied only once). conditions, as well as 
application scenarios based on the features of the methods.



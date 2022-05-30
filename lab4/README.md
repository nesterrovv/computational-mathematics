# Lab work #4. Interpolation and approximation. Least square method.

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

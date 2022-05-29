# Lab work #3. Numerical integration. Simpson method.

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

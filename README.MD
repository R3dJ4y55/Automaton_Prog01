# Automaton
---
Rise of the machines
---
Vanier Programming 1 Lab    | 10/24/2025


Q27: The same pattern does emerge every time.

Q28: It remplaces all cells in state with 0.

Q29: Yes. The patterns are deterministic.

Q31: Because if we use values from state[] to change the values of state[], we will , modify the source (state)  and it will return a different result

Q32: I believe the solution is better. It uses less memory.

Q35: To simplify the problem, let's start by considering multiplication between two of the variables.
Due to the % 2, adding a variable to itself will result in 0. This means we have 3 possible combinations that can possibly affect the equation (not add or multiply by 0):  
  
    * left + right
    * left + center
    * right + center

Now, to consider multiplication between two variables.
Multiplying a variable by itself, due to the binary nature of the values, will return itself.  
Multiplying a variable by 1 will not change it.  
Multiplying by 0 will set the value to zero.  

Seeing as left starts with the value 0, multiplying by left will return 0.  
Therefore, we need only consider center * right.

Due to the limited possiblilities,
 if we combine multiplication and addition,
 we should still have a finite number of possibilities.

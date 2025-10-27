import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 7.1
 */
public class Automaton
{
    // The number of cells.
    private final int numberOfCells = 50;
    // The sum of binary degits stored as an integer
    private int wolframCode;
    // The state of the cells.
    private int[] state;
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int wolframCode)
    {
        this.wolframCode = wolframCode;
        state = new int[numberOfCells + 1];
        // Seed the automaton
        fillState(wolframToBinary(wolframCode));
    }
    
    /**
     * Converts the Wolfram code provided into a String of binary digits
     * @param wolframCode The Wolfram code to convert.
     */
    private String wolframToBinary(int wolframCode){
        // String that the initial state will be stored in
        String initialState = "";
        // Initialize array to store binary values for converting the wolframCode
        int[] bits = new int[8];
        for (int i = 0; i < 8; i++){
            bits[i] = 0;
        }
        
        // Divide wolframCode by powers of 2 and store them in an array
        // Then remove the value from wolframCode in order to move to next bit
        
        // 8th Bit
        bits[7] = (wolframCode % (2^7) == 0) ? 1 : 0;
        if (bits[7] == 1){wolframCode -= 2^7;}
        // 7th Bit
        bits[6] = (wolframCode % (2^6) == 0) ? 1 : 0;
        if (bits[6] == 1){wolframCode -= 2^6;}
        // 6th Bit
        bits[5] = (wolframCode % (2^5) == 0) ? 1 : 0;
        if (bits[5] == 1){wolframCode -= 2^5;}
        // 5th Bit
        bits[4] = (wolframCode % (2^4) == 0) ? 1 : 0;
        if (bits[4] == 1){wolframCode -= 2^4;}
        // 4th Bit
        bits[3] = (wolframCode % (2^3) == 0) ? 1 : 0;
        if (bits[3] == 1){wolframCode -= 2^3;}
        // 3rd Bit
        bits[2] = (wolframCode % 4 == 0) ? 1 : 0;
        if (bits[2] == 1){wolframCode -= 2^2;}
        // 2nd Bit
        bits[1] = (wolframCode % (2^1) == 0) ? 1 : 0;
        if (bits[1] == 1){wolframCode -= 2^1;}
        // 1st Bit
        bits[0] = (wolframCode % (2^0) == 0) ? 1 : 0;
        if (bits[0] == 1){wolframCode -= 2^0;}
        
        // Set the value of initialState to the concatenation of all the bits
        for(int b : bits){
            initialState = "" + b + " ";
        }
        
        // return the String initialState
        return initialState;
    }
    
    /**
     * Fills the state array
     * @param initialState Refers to the initialState string returned by the wolframToBinary method
     */
    private void fillState(String initialState){
        String[] str = initialState.split(" ");
        int i = 0;
        for (String s : str){
            int bit = Integer.parseInt(s);
            state[i] = bit;
            i++;
        }
    }
    
    /**
     * Print the current state of the automaton.
     */
    public void print()
    {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }   
    
    /**
     * Update the automaton to its next state.
     */
    public void update()
    {
        int[] nextState = new int[state.length];
        int left = 0;
        int center = state[0];
        for(int i = 0; i < numberOfCells; i++) {
            int right = state[i + 1];
            nextState[i] = calculateNextState(left, center, right);
            left = center;
            center = right;
        }
        state = nextState;
    }
    
    private int calculateNextState(int l, int c, int r){
        return (l * c + l + r) % 2;
    }
    
    /**
     * Reset the automaton.
     */
    public void reset()
    {
        Arrays.fill(state, 0);
        // Seed the automaton with a single 'on' cell.
        state[numberOfCells / 3] = 1;
        state[2*(numberOfCells / 3)] = 1;
    }
}

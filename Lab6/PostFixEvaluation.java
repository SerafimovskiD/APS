import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

interface Stack<E> {

    // The elements of the Stack are any kind of objects

    // Access methods:

    public boolean isEmpty ();
    // Returns true only if the stack is empty.

    public E peek ();
    // Returns the element on the top od the stack.

    // Transformation methods:

    public void clear ();
    // Clears the stack.

    public void push (E x);
    // Adds x on the top of the stack.

    public E pop ();
    // Removes and returns the element on the top.
}

class ArrayStack<E> implements Stack<E> {
    private E[] elems;
    private int depth;

    @SuppressWarnings("unchecked")
    public ArrayStack (int maxDepth) {
        // Creating new empty stack
        elems = (E[]) new Object[maxDepth];
        depth = 0;
    }


    public boolean isEmpty () {
        // Returns true only if the stack is empty.
        return (depth == 0);
    }


    public E peek () {
        // Returns the element on the top od the stack.
        if (depth == 0)
            throw new NoSuchElementException();
        return elems[depth-1];
    }


    public void clear () {
        // Clears the stack.
        for (int i = 0; i < depth; i++)  elems[i] = null;
        depth = 0;
    }

    public void push (E x) {
        // Adds x on the top of the stack.
        elems[depth++] = x;
    }


    public E pop () {
        // Removes and returns the element on the top.
        if (depth == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth];
        elems[depth] = null;
        return topmost;
    }
}

public class PostFixEvaluation {


    static int evaluatePostfix(char [] izraz, int n)
    {

        boolean find=false;
        int number=0;
        int counter=0;
        ArrayStack<Integer> stek = new ArrayStack<>(10);
        while(n!=0)
        {
            if(Character.isDigit(izraz[counter]))
            {
                number = number *10 + izraz[counter] -'0';
                find=true;
            }
            else if(izraz[counter]=='/')
            {
                int x = stek.pop();
                int y = stek.pop();
                if(y==0)
                    stek.push(0);
                else if(x<y)

                    stek.push(y/x);
                else
                    stek.push(x/y);
            }
            else if(izraz[counter]=='*')
            {
                stek.push(stek.pop()*stek.pop());
            }
            else if(izraz[counter]=='-')
            {
                stek.push(Math.abs(stek.pop()-stek.pop()));
            }
            else if(izraz[counter]=='+')
            {
                stek.push(stek.pop()+stek.pop());
            }
            else
            {
                if(find==true)
                    stek.push(number);
                number=0;
                find=false;
            }
            counter++;
            n--;
        }
        return stek.pop();
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = evaluatePostfix(exp, exp.length);
        System.out.println(rez);

        br.close();

    }

}
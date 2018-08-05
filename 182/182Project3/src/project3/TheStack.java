package project3;

/**
 * @author RobertFlorence Project 3 - Stack Game - trying to help kirk find his
 * mas macho by using a stack to jump from 'moon to moon. CS 182 - Ferguson
 * April 2013
 */
public class TheStack {

    private int top;
    private Moon[] stack;

    public TheStack() {
        top = -1;
        stack = new Moon[25];

    }

    public void push(Moon M) {
        stack[++top] = M;
    }

    public Moon pop() {
        if (isEmpty()) {
            return null;
        }

        return stack[top--];
    }

    public Moon peek() {
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == stack.length - 1);

    }
}
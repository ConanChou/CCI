/**
 * Describe how you could use a single array to implement three stacks.
 */

public class Q3_1 {

    public static void main(String [] args) {

    }
}

class TriStack {
    int[] storage;
    int[] tops = {-1,-1,-1};
    int stackSize;

    public TriStack(int singleSize) {
        stackSize = singleSize;
        storage = new int[3*singleSize];
    }

    void push(int stackNum, int i) throws Exception {
        if (tops[stackNum] >= stackSize) {
            throw new Exception("stack is full");
        }
        storage[getIndex(stackNum)] = i;
        tops[stackNum] += 1;
    }

    int pop(int stackNum) throws Exception {
        if (tops[stackNum] < 0) {
            throw new Exception("stack is empty");
        }
        int returnNum = storage[getIndex(stackNum)];
        tops[stackNum] -= 1;
        return returnNum;
    }

    int peek(int stackNum) throws Exception {
        if (tops[stackNum] < 0) {
            throw new Exception("stack is empty");
        }
        return storage[getIndex(stackNum)];
    }

    int getIndex(int stackNum) {
        return stackNum*stackSize+tops[stackNum];
    }
}

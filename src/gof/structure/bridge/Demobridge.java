package gof.structure.bridge;

import java.util.Random;

public class Demobridge {
    public static void main(String[] args) {
        Stack[] stacks = {
                new Stack("array"),
                new Stack("list"),
                new StackHanoi()
        };

        for(int i = 1; i < 15; i++) {
            for(int j = 0; j < 2; j++) {
                stacks[j].push(i);
            }
        }

        Random rm = new Random();
        for(int i = 1; i < 15; i++) {
            stacks[2].push(rm.nextInt(100));
        }

        for(int i = 0; i < stacks.length; i++) {
            while (!stacks[i].isEmpty()) {
                System.out.print(stacks[i].pop() + " ");
            }
            System.out.println();
        }


        System.out.println("total rejected is " + ((StackHanoi)stacks[2]).reportRejected());

    }
}

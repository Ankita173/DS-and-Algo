package org.example.microsoft;

public class RabbitJump {
    public static void main(String[] args) {
        float jumps[] = {1.0f, 1.2f};
        int minJumps = findMinJump(0F, 3.3f, jumps, 0, Integer.MAX_VALUE);
        if (Integer.MAX_VALUE == minJumps)
            System.out.println("Rabbit cant reach");
        else
            System.out.println("Rabbit reached carrot in "+minJumps);

    }

    static int findMinJump(float rabbit, float carrot, float[] jump, int jumps, int minJump) {
        if (rabbit == carrot) {
            return jumps < minJump ? jumps : minJump;
        } else if (rabbit < carrot) {
            for (int i = 0; i < jump.length; i++) {
                minJump = findMinJump(rabbit+jump[i], carrot, jump, jumps+1, minJump);
            }
        }
        return minJump;
    }







    static int findMinJump(float carrot, float jump) {
        int jumps = 0;
        float rabbit = 0;
        for(; rabbit < carrot; jumps++) {
            if (rabbit + jump <= carrot)
                rabbit += jump;
            else
                rabbit++;
        }
        return rabbit != carrot ? -1 : jumps;
    }

}
// rabbit sees carrot at x meter, rabbit can jump y meter or 1 meter jump
// find minimum jump to reach carrot
// rabbit is 0 position carrot is at 5
//rabbit can jump [1, 3]
//3 -> 1 -> 1
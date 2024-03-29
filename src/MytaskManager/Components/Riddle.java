
package MytaskManager.Components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Riddle {
    private static List<Riddle> riddles;
    private static int currentIndex = -1;

    private String question;
    private String answer;

    public Riddle(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public static Riddle getRiddle() {
        if (riddles == null || currentIndex >= riddles.size() - 1) {
            initializeRiddles();
            currentIndex = 0;
        }
//        currentIndex++;
        return riddles.get(currentIndex);
    }

    private static void initializeRiddles() {
       riddles = new ArrayList<>();
        // Add your riddles here
   
        riddles.add(new Riddle("What has keys but can't open locks?", "piano"));
        riddles.add(new Riddle("What has to be broken before you can use it?", "egg"));
        riddles.add(new Riddle("What gets wetter the more it dries?", "towel"));
        riddles.add(new Riddle("David's father has three sons: Snap, Crackle, and _____", "David"));
        riddles.add(new Riddle("What is more useful when it is broken?","egg"));
        riddles.add(new Riddle("I am easy to lift, but hard to throw. What am I?", "feather"));
        riddles.add(new Riddle("Which fish costs the most?","goldfish"));
        riddles.add(new Riddle("What goes up, but never comes down?", "age"));
        riddles.add(new Riddle("What has a neck but no head?","bottle"));
        riddles.add(new Riddle("How do you spell COW in thirteen letters?","SEE O DOUBLE YOU."));
        riddles.add(new Riddle("I add 5 to 9 and get 2. The answer is correct, so what am I?","clock"));
        riddles.add(new Riddle("What is 3/7 chicken, 2/3 cat, and 2/4 goat?","chicago"));
        riddles.add(new Riddle("If you multiply this number by any other number, the answer will always be the same. What number is this?","zero"));
        riddles.add(new Riddle("I am an odd number. Take away a letter and I become even. What number am I?","seven"));
        riddles.add(new Riddle("Who has married many women but was never married?","priest"));
        riddles.add(new Riddle("Paul's height is six feet, he's an assistant at a butcher's shop, and wears size 9 shoes. What does he weigh?","meat"));
        riddles.add(new Riddle("What kind of tree can you carry in your hand?","palm"));
        riddles.add(new Riddle("You’ll find me in Mercury, Earth, Mars, Jupiter, Saturn, and Uranus. But never Neptune, or Venus. What am I?", "R"));
        riddles.add(new Riddle("I love to dance, and twist. I shake my tail as I sail away. When I fly wingless into the sky. What am I?","kite"));
        riddles.add(new Riddle("I make a loud sound when I’m changing. When I do change, I get bigger but weigh less. What am I?","popcorn"));
        riddles.add(new Riddle(" I’m orange, I wear a green hat and I sound like a parrot. What am I?","carrot"));
        riddles.add(new Riddle("Take off my skin - I won't cry, but you will! What am I?","onion"));
        riddles.add(new Riddle("What thrives when you feed it but dies when you water it?","fire"));
        riddles.add(new Riddle("Dalawang batong maitim, malayo ang dinarating.","mata"));
        riddles.add(new Riddle("Isang prinsesa, punong-puno ng mata.","pinya"));
        riddles.add(new Riddle("Ano tawag mo sa kapatid ng tatay mo pero hindi mo tito?","tita"));
        riddles.add(new Riddle("Anong nail ang hindi gusting tamaan ng karpentero?","fingernail"));
        riddles.add(new Riddle("Ang nawalan ay natawa, ang nakakuha ay nasuka.","utot"));
        riddles.add(new Riddle("Anong key ang nakakabukas ng saging?","monkey"));
        riddles.add(new Riddle("What has one eye but can’t see?","needle"));
        riddles.add(new Riddle("If you drop me, I crack. If you smile at me, I smile back. What am I?","mirror"));
//        riddles.add(new Riddle("",""));
        Collections.shuffle(riddles);
    }
}

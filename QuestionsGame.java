// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.
import java.io.PrintStream;
import java.util.*;
public class QuestionsGame {
    // Your code here

    public QuestionsGame(String object) {
        // initilize a new QuetionsGame object with a single leaf node representing the object object. 
        QuestionNode monkey = new QuestionNode(object);

    }
    public QuestionsGame(Scanner input){
        while(input.hasNext()){

        }
    }

    

    private static class QuestionNode {
        // Your code here
        public String data; // data stored at main node
        public QuestionNode left; // left node
        public QuestionNode right; // right node

        public QuestionNode (String data) 
        {
            //initializes
            this(data, null, null);
        }


    // Constructs a branch node with the given data and links

        public QuestionNode(String data, QuestionNode left, QuestionNode right) {
            //initialzing
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void saveQuestions(PrintStream output){
            if(output == null){
                throw new IllegalArgumentException();
            }
            output = new PrintStream(new File("spec-questions.txt"));
        }

        public void play(){

        }

    }
}

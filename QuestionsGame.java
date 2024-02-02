// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.
import java.util.*;
public class QuestionsGame {
    // Your code here
    QuestionNode monkey;
    public QuestionsGame(String object) {
        // initilize a new QuetionsGame object with a single leaf node representing the object object. 
         monkey = new QuestionNode(object);

    }
    public QuestionsGame(Scanner input){
        if(input.hasNext()){
            input.nextLine();
            
            monkey.left =new QuestionNode(input.nextLine());
            
            




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
}

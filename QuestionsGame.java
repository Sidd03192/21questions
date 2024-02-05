// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class QuestionsGame { 
    // Your code here
        QuestionNode Panda;
    public QuestionsGame(String object) {
        // initilize a new QuetionsGame object with a single leaf node representing the object object. 
         Panda = new QuestionNode(object);

    }
    public QuestionsGame(Scanner input) throws FileNotFoundException{
        input = new Scanner(new File("spec-questions.txt"));
        input.nextLine();
        Panda = new QuestionNode(input.next());
        monkey( input, Panda);

    }

    private   void monkey (Scanner input, QuestionNode node) throws FileNotFoundException{
        

        
        if ( input.nextLine().equals("Q:")){

         node.left = new QuestionNode(input.nextLine());
         System.out.println(node.left.data);
         monkey (input, node.left);
        }

        if( input.nextLine().equals("A:"))
        {
            node.right = new QuestionNode(input.nextLine());
            System.out.println(node.left.data);
            monkey(input, node.right);
        }

        
    

        monkey(input, node);



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

        }

        public void play(){
            
        }

    }
}

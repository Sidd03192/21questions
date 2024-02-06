// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.
import java.io.*;
import java.util.*;

public class QuestionsGame { 
    // Your code here
        private QuestionNode Panda;
        private String [] questions;
    public QuestionsGame(String object) {
        // initilize a new QuetionsGame object with a single leaf node representing the object object. 
         Panda = new QuestionNode(object);

    }
    public QuestionsGame(Scanner input) throws FileNotFoundException{
        input = new Scanner(new File("spec-questions.txt"));
        input.nextLine(); // skip the q
        Panda = new QuestionNode(input.next());
        monkey( input, Panda);
        questions = new String [100];
    }

    private void monkey (Scanner input, QuestionNode node) throws FileNotFoundException{
              if (!input.hasNextLine())
       {
        return ;
       }
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
=
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

    public void saveQuestions(PrintStream output){
        if(output == null){
            throw new IllegalArgumentException();
        }
        saveQuestions(output, Panda);
    }
    private void saveQuestions(PrintStream output, QuestionNode root){
        output.append(root.data + " ");

		if(root.left != null) {
			saveQuestions(output, root.left);
		}
		//go right
		if(root.right != null) {
			saveQuestions(output, root.right);
		}
    }

    public void play(){

        Scanner keyboard = new Scanner (System.in); // creates new scanner called keyboard
         QuestionNode temp = Panda;
        play(temp);

        // while ( temp!=null)
        // {
        //     System.out.println(temp.data + "(y/n)");
        //     // while they dont wanna exit ( if they type in yes  or y )    
        //     if (keyboard.nextLine().trim().toLowerCase().startsWith("y"))
        //     {
        //         temp = temp.left;
        //         if (temp .left==null)
        //         {
        //             System.out.println(" I guess that your object is " + temp.data+ "!");
        //             System.out.println("Am I right?");
        //             if (keyboard.nextLine().trim().toLowerCase().startsWith("y"))
        //             {
        //                 System.out.println("Awesome! I win!");
        //             }
        //             else 
        //             {
        //                 System.out.println("Boo! I Lose. Please help me get better!");
        //                 System.out.println("What is your object?");
        //                  String a = keyboard.nextLine();
        //                 System.out.println("Please give me a yes/no question that distinguishes between "+ a +" and"+ temp.data+".");
        //                  String q = keyboard.next();
        //                 System.out.println("Is the answer \"yes\" for car? (y/n)?");                     
        //                  String ans  = keyboard.next();
        //             }  

        //         }
                
        //     }
        //     else{
        //         temp=temp.right;
        //     }
            



        }
        private void play(QuestionNode chineseMonkey){
            

            
        }












    }
}

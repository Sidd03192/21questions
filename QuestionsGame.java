// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.
import java.io.*;
import java.util.*;
import java.util.Scanner;


public class QuestionsGame {
    // Your code here
        public QuestionNode overallRoot;
       
    public QuestionsGame(String object) {
        // initilize a new QuetionsGame object with a single leaf node representing the object object.
         overallRoot = new QuestionNode(object);


    }
    public QuestionsGame(Scanner input) throws FileNotFoundException{
        input = new Scanner(new File("spec-questions.txt"));
        
        overallRoot = makeTree( input);
    }
    private QuestionNode makeTree (Scanner input) throws FileNotFoundException{
       
        String a = input.nextLine(); // question or not
        String b = input.nextLine(); // actual data
        QuestionNode node = new QuestionNode(b);
 
        if ( a.startsWith("Q")) // if the next line is a question, then we need to recurse once again.
        {
            node.left =makeTree(input); // whenever this finishes, we hit the next life for the right node. 
            node.right=makeTree(input);
        }
        
            return node;
    }
    public static class QuestionNode {
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
        saveQuestions(output, overallRoot);
    }
    private void saveQuestions(PrintStream output, QuestionNode root){
        if(root.left == null){
            output.append("A: \n");
            output.append(root.data + " \n");
        }
        else if(root.left != null){
            output.append("Q: \n");
            output.append(root.data + " \n");
        }


        if(root.left != null) {
            saveQuestions(output, root.left);
        }
        //go right
        if(root.right != null) {
            saveQuestions(output, root.right);
        }
    }

    public static void printTree(QuestionNode node) {
        if (node != null) {
            System.out.println(node.data); // Print the data of the current node
            printTree(node.left); // Recursively print the left subtree
            printTree(node.right); // Recursively print the right subtree
        }
    }
    public void play(){


        Scanner keyboard = new Scanner (System.in); // creates new scanner called keyboard
         QuestionNode temp = overallRoot;
        while ( temp!=null)
        {
            System.out.println(temp.data); // Print the current question.

            if ( keyboard.nextLine().trim().toLowerCase().startsWith("y") ) // if the answer is yes. 
            {
                // we have to look at temp.left
                QuestionNode current = temp.left; // this is the node that are looking at
                if ( current.left==null) // if the node we are lookign at doesnt have children, then we do end case
                    {
                        System.out.println("I guess that your object is " + current.data+ "!");
                        System.out.println("Am I right?");
                        if (keyboard.nextLine().trim().toLowerCase().startsWith("y"))
                        {
                        System.out.println("Awesome! I win!");
                        break;
                        }
                        else{
                            System.out.println("Boo! I Lose. Please help me get better!");
                            System.out.println("What is your object?");
                            String newObject = keyboard.nextLine();
                            System.out.println("Please give me a yes/no question that distinguishes between "+ newObject +" and "+ current.data+".");
                            String newQuestion = keyboard.nextLine();
                            System.out.println("Is the answer \"yes\" for "+newObject +"? (y/n)?");                    
                            String ans  = keyboard.nextLine(); // tells us if we need to put it on the left or right




                            QuestionNode oldAnswer = temp.left;
                            // makes a new node for question and new answer
                            temp.left = new QuestionNode(newQuestion);


                            if (ans.trim().toLowerCase().startsWith("y"))
                            {
                                temp.left.left  =new QuestionNode(newObject);
                                temp.left.right =oldAnswer;


                            }
                            else{
                                temp.left.right = new QuestionNode(newObject);
                                temp.left.left = oldAnswer;
                            }
                            break;
                        }


                    }
                temp=temp.left;


            }
           else{ //if the answer is wrong, then we go right
            
                QuestionNode current = temp.right;
                if (current.left==null) // end case
                {
                    System.out.println("I guess that your object is " + current.data+ "!");
                    System.out.println("Am I right?");
                    if (keyboard.nextLine().trim().toLowerCase().startsWith("y"))
                    {
                    System.out.println("Awesome! I win!");
                    break;
                    }
                    else{
                        System.out.println("Boo! I Lose. Please help me get better!");
                        System.out.println("What is your object?");
                        String newObject = keyboard.nextLine();
                        System.out.println("Please give me a yes/no question that distinguishes between "+ newObject +" and "+ current.data+".");
                        String newQuestion = keyboard.nextLine();
                        System.out.println("Is the answer \"yes\" for "+newObject +"? (y/n)?");                    
                        String ans  = keyboard.nextLine(); // tells us if we need to put it on the left or right

                        QuestionNode oldAnswer = temp.left;
                        // makes a new node for question and new answer
                        temp.right = new QuestionNode(newQuestion);


                        if (ans.trim().toLowerCase().startsWith("y"))
                        {
                            temp.right.left  =new QuestionNode(newObject);
                            temp.left.right =oldAnswer;


                        }
                        else{
                            temp.left.right = new QuestionNode(newObject);
                            temp.left.left = oldAnswer;
                        }
                    }


                }
                temp=temp.right;
            }



           }




        }
    public static void main (String [] args) throws FileNotFoundException
    {
        Scanner file = new Scanner(new File("spec-questions.txt"));
        QuestionsGame theTree = new QuestionsGame(file);
        printTree(theTree.overallRoot);
    }




}




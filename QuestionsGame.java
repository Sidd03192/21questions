// Zohaib Sheikh and Siddarth Potta
//Period 7
//This file implements the 20 questions game in it's entirety
import java.io.*;
import java.util.*;
import java.util.Scanner;


public class QuestionsGame {
    // Your code here
        public QuestionNode overallRoot;

    //constructors

    public QuestionsGame(String object) {
        // initilize a new QuetionsGame object with a single leaf node representing the object object.
         overallRoot = new QuestionNode(object);


    }
    public QuestionsGame(Scanner input) throws FileNotFoundException{
        //make scanner with input
        input = new Scanner(new File("spec-questions.txt"));
        //make tree with input
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
            throw new IllegalArgumentException();//if there is nothing you have to send an exception
        }
        saveQuestions(output, overallRoot);//call recursive method
    }
    private void saveQuestions(PrintStream output, QuestionNode root){//recursive method
        //sees if you have to add an answer
        if(root.left == null){
            output.append("A: \n");
            //adds the data
            output.append(root.data + " \n");
        }
        //sees if you have to add a question
        else if(root.left != null){
            output.append("Q: \n");
            //adds the data
            output.append(root.data + " \n");
        }


        if(root.left != null) {
            saveQuestions(output, root.left);//if there is still more, recurse
        }
        //go right
        if(root.right != null) {
            saveQuestions(output, root.right);//if there is still more, recurse
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
                        //game questions
                        System.out.println("I guess that your object is " + current.data+ "!");
                        System.out.println("Am I right?");
                        //checks if answer is yes
                        if (keyboard.nextLine().trim().toLowerCase().startsWith("y"))
                        {
                            //win!!!!!!
                        System.out.println("Awesome! I win!");
                        break;
                        }
                        else{
                            //lose!!!!!! :(((((
                            System.out.println("Boo! I Lose. Please help me get better!");
                            //asks for object to add
                            System.out.println("What is your object?");
                            String newObject = keyboard.nextLine();
                            //asks for a question to add
                            System.out.println("Please give me a yes/no question that distinguishes between "+ newObject +" and "+ current.data+".");
                            String newQuestion = keyboard.nextLine();
                            //asks for the answer
                            System.out.println("Is the answer \"yes\" for "+newObject +"? (y/n)?");                    
                            String ans  = keyboard.nextLine(); // tells us if we need to put it on the left or right



                            //sets the old answer
                            QuestionNode oldAnswer = temp.left;
                            // makes a new node for question and new answer
                            temp.left = new QuestionNode(newQuestion);

                            //if responded yes
                            if (ans.trim().toLowerCase().startsWith("y"))
                            {
                                //sets the new
                                temp.left.left  =new QuestionNode(newObject);
                                temp.left.right =oldAnswer;


                            }
                            else{//if responded no or anything else
                                //sets the new 
                                temp.left.right = new QuestionNode(newObject);
                                temp.left.left = oldAnswer;
                            }
                            break;
                        }


                    }
                //keeps going down
                temp=temp.left;


            }
           else{ //if the answer is wrong, then we go right
                //goes right
                QuestionNode current = temp.right;
                if (current.left==null) // end case
                {
                    //guesses object-> game speech
                    System.out.println("I guess that your object is " + current.data+ "!");
                    System.out.println("Am I right?");
                    //checks if respnds yes
                    if (keyboard.nextLine().trim().toLowerCase().startsWith("y"))
                    {
                        //win!!!!!
                    System.out.println("Awesome! I win!");
                    break;
                    }
                    else{
                        //lose!!!!
                        System.out.println("Boo! I Lose. Please help me get better!");
                        //asks for the object
                        System.out.println("What is your object?");
                        String newObject = keyboard.nextLine();
                        //asks for new question
                        System.out.println("Please give me a yes/no question that distinguishes between "+ newObject +" and "+ current.data+".");
                        String newQuestion = keyboard.nextLine();
                        //finds answer and stores
                        System.out.println("Is the answer \"yes\" for "+newObject +"? (y/n)?");                    
                        String ans  = keyboard.nextLine(); // tells us if we need to put it on the left or right

                        QuestionNode oldAnswer = temp.left;
                        // makes a new node for question and new answer
                        temp.right = new QuestionNode(newQuestion);

                        //if response is yes
                        if (ans.trim().toLowerCase().startsWith("y"))
                        {   
                            //sets new
                            temp.right.left  =new QuestionNode(newObject);
                            temp.left.right =oldAnswer;


                        }
                        else{//if response is no or anything else
                            //sets new
                            temp.left.right = new QuestionNode(newObject);
                            temp.left.left = oldAnswer;
                        }
                    }


                }
                //moves right
                temp=temp.right;
            }



           }




        }
    public static void main (String [] args) throws FileNotFoundException
    {
        //run
        Scanner file = new Scanner(new File("spec-questions.txt"));
        //the tree created with the file from scanner.
        QuestionsGame theTree = new QuestionsGame(file);
        //prints it
        printTree(theTree.overallRoot);
    }




}




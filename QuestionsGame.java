// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

public class QuestionsGame {
    // Your code here

    public QuestionsGame(String object) {
        // initilize a new QuetionsGame object with a single leaf node representing the object object. 


    }



    private static class QuestionNode {
        // Your code here
        public String question; // data stored at main node
        public QuestionNode left; // left node
        public QuestionNode right; // right node

        public QuestionNode (String question) 
        {
            this(question, null, null);
        }


    // Constructs a branch node with the given data and links

        public QuestionNode(String question, QuestionNode left, QuestionNode right) {
            this.question = question;
            this.left = left;
            this.right = right;
    }
}

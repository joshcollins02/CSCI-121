import java.io.*;
import java.util.Scanner;

public class QuestionTree {
    private QuestionNode base;
    private Scanner sc;

//    constructor for QuestionTree class, initializing tree and scanner
    public QuestionTree() {
        base = null;
        sc = new Scanner(System.in);
    }

//    restartGame method that prompts user to enter a question and left and right node, if there is a previous question
//    and there's a leaf node that has a yes but nothing for no, it can be populated by this method to further the game.
    public void restartGame() {
        System.out.println("Enter a question.");
        base = new QuestionNode(new Question(sc.nextLine()));

        System.out.println("Enter something for that question that corresponds to yes.");
        base.leftNode = new QuestionNode(new Question(sc.nextLine()));

        System.out.println("Enter something for that question that corresponds to no.");
        base.rightNode = new QuestionNode(new Question(sc.nextLine()));
    }

//    playGame method that handles the yes and no response, if there is null then it will prompt restartGame to populate
//    the binary tree, if it is !null then it will begin the guessing process, and if it's correct then the game will end and
//    show the main "screen", if it's incorrect, the game will prompt a way to better guess the question by creating a new node.
    public void playGame() {
        if (base == null) {
            restartGame();
        }
        QuestionNode current = base;
        while (!current.isLeafNode()) {
            System.out.println(current.question.getQuestion());
            String response = sc.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                current = current.leftNode;
            } else if (response.equals("no")) {
                current = current.rightNode;
            } else {
                System.out.println("Invalid");
            }
        }

        System.out.println("My guess is a: " + current.question.getQuestion() + "?");
        String response = sc.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            System.out.println("Boom! I win!");
        }
        if (response.equals("no")) {
            System.out.println("Prompt a question that fits what you were thinking of");
            String newQuestion = sc.nextLine();
            System.out.println("What were you thinking of?");
            String answer = sc.nextLine();

            current.question.setQuestion(newQuestion);
            current.leftNode = new QuestionNode(new Question(answer));
            current.rightNode = new QuestionNode(current.question);
        } else if (!response.equals("yes")) {
            System.out.println("Invalid");
        }
    }

//    saveToFile method that takes the finished game once "save" is typed, and prints it to "puterstore.txt" (type that exact text file or else it won,t save)
    public void saveToFile(String fileName) {
//        file not found exception to check to working directory, as long as the txt file is saved in main folder, program should run no problem
        try (PrintWriter writer = new PrintWriter(fileName)) {
            saveTree(base, writer);
            System.out.println("Tree saved to " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

//    saveTree method that saveToFile calls from, handles the printing into the text file
    private void saveTree(QuestionNode node, PrintWriter writer) {
        if (node == null) {
            return;
        }
        writer.println(node.question.getQuestion());
        saveTree(node.leftNode, writer);
        saveTree(node.rightNode, writer);
    }

//    handles the playing of the game, creates a new QuestionTree, where as long as te player doesn't type "quit", the
//    game will continue, handles all of the propmts (play, quit, restart, save), once the game completes, it will save
//    the data to a text file if save is clicked and then closes the scanner.
    public static void main(String[] args) {
        QuestionTree tree = new QuestionTree();
        String command;
        boolean donePlaying = false;

        while (!donePlaying) {
            System.out.print("Please enter command (play, quit, restart, save): ");
            command = tree.sc.nextLine().toLowerCase();
            if (command.equals("play")) {
                tree.playGame();
            } else if (command.equals("quit")) {
                donePlaying = true;
            } else if (command.equals("restart")) {
                tree.restartGame();
            } else if (command.equals("save")) {
                System.out.print("Enter file name to save to: ");
                String fileName = tree.sc.nextLine();
                tree.saveToFile(fileName);
            } else {
                System.out.println("Invalid command.");
            }
        }
        tree.sc.close();
    }
}


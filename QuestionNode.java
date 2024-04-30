public class QuestionNode {
    Question question;
    QuestionNode leftNode;
    QuestionNode rightNode;

//    creating constructor for QuestionNode class
    public QuestionNode(Question question) {
        this.question = question;
    }

//    overriding constructor that handles left and right nodes
    public QuestionNode(Question question, QuestionNode leftNode, QuestionNode rightNode) {
        this.question = question;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

//    getters and setters
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public QuestionNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(QuestionNode leftNode) {
        this.leftNode = leftNode;
    }

    public QuestionNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(QuestionNode rightNode) {
        this.rightNode = rightNode;
    }

//    leafNode to check for if it's a parent or child node
    public boolean isLeafNode() {
        return (this.leftNode == null && this.rightNode == null);
    }
}

public class Main {

    public static void main(String[] args) {
        //initialize tree
        TreeNode<String> decisionTree = GourmetGame.initTree();
        //start game
        GourmetGame.startGame(decisionTree);
    }
}

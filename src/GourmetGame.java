import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GourmetGame {

    private static final String GAME_NAME = "Jogo Gourmet";

    static TreeNode<String> initTree(){
        TreeNode<String> root = new TreeNode<>("Massa", false);
        root.addChildLeft("Lasanha", true);
        root.addChildRight("Bolo de Chocolate", true);

        return root;
    }



    static void startGame(final TreeNode<String> root) {

        buildFrameRoot(root);

    }

    private static void ask(TreeNode<String> root){

        TreeNode<String> treeNode = root;
        boolean found = false;

        while(!found) {

            // show dialog asking about dishes and attributes
            int ask = JOptionPane.showOptionDialog(null, "O prato que você pensou é " + treeNode.data + "?", GAME_NAME, JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);

            switch (ask){
                case JOptionPane.YES_OPTION:
                    if (treeNode.isLeaf()) {
                        //the system hit the dish, show message
                        JOptionPane.showOptionDialog(null, "ACERTEI!!!", GAME_NAME, JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, null, null);

                        //set the tree node to root
                        treeNode = root;
                        found = true;

                    } else if (treeNode.getLeft() != null) {
                        //negative response by user, continue with children node
                        treeNode = treeNode.getLeft();
                    }
                    break;
                case JOptionPane.NO_OPTION:
                    if (treeNode.isLeaf()) {
                        //there's no response in system to dish that the user thought
                        //show input dialog to ask the dish
                        String dish = JOptionPane.showInputDialog("Qual prato você pensou?");
                        if(dish == null){ //check if input text area is empty
                            treeNode = root;
                            found = true;
                            break;
                        }

                        //show dialog to ask attribute
                        String attribute = JOptionPane.showInputDialog(dish + " é ______ mas " + treeNode.data + " não.");
                        if(attribute == null){
                            treeNode = root;
                            found = true;
                            break;
                        }

                        //insert the new node in tree
                        treeNode.addChildLeft(dish, true);
                        treeNode.addChildRight(treeNode.data, treeNode.isLeaf());
                        treeNode.setData(attribute);
                        treeNode.setIsLeaf(false);

                        //set the tree node to root
                        treeNode = root;
                        found = true;

                    } else if (treeNode.getRight() != null) {
                        //negative response by user, continue with children node
                        treeNode = treeNode.getRight();
                    }
                    break;
                case JOptionPane.CLOSED_OPTION:
                    found = true;
                    break;
            }

        }
    }

    private static void buildFrameRoot(final TreeNode<String> root){
        JFrame frameRoot = new JFrame(GAME_NAME);
        //set size and location of frame
        frameRoot.setSize(400, 200);
        frameRoot.setLocationRelativeTo(null);

        //make sure it quits when x is clicked
        frameRoot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set look and feel
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Label message
        JLabel labelM = new JLabel("Pense em um prato que gosta");
        labelM.setBounds(100, 50, 200, 30);

        //add a button
        JButton buttom = new JButton("OK");
        buttom.setBounds(150, 100, 100, 30);

        //add elements to the frame
        frameRoot.add(labelM);
        frameRoot.add(buttom);
        frameRoot.setLayout(null);
        frameRoot.setVisible(true);

        buttom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ask(root);
            }
        });
    }
}

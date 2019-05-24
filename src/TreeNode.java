class TreeNode<T extends Comparable<?>> {
    private TreeNode<T> left, right;
    private boolean leaf;
    T data;

    public TreeNode(T data, boolean isLeaf) {
        this.data = data;
        this.leaf = isLeaf;
        this.left = null;
        this.right = null;
    }


    public TreeNode<T> addChildLeft(T data, boolean isLeaf){
        TreeNode<T> childNode = new TreeNode<T>(data, isLeaf);
        this.left = childNode;
        return childNode;
    }

    public TreeNode<T> addChildRight(T data, boolean isLeaf){
        TreeNode<T> childNode = new TreeNode<T>(data, isLeaf);
        this.right = childNode;
        return childNode;
    }

    public boolean isLeaf(){
        return leaf;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.leaf = isLeaf;
    }

}

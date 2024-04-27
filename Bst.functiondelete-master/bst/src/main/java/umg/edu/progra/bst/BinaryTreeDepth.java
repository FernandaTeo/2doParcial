
//Primer Ejercicio Segunda Parte Parcial


package umg.edu.progra.bst;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        // Creamos un árbol de ejemplo
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        BinaryTreeDepth treeDepth = new BinaryTreeDepth();

        // Calculamos la profundidad mínima y máxima
        int minDepthResult = treeDepth.minDepth(root);
        int maxDepthResult = treeDepth.maxDepth(root);

        System.out.println("Profundidad mínima del árbol: " + minDepthResult);
        System.out.println("Profundidad máxima del árbol: " + maxDepthResult);
    }
}

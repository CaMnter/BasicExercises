package com.camnter.basicexercises.tree;


import com.camnter.basicexercises.core.TreeNode;

import java.util.Stack;

/**
 * 后续遍历
 * <p/>
 * 左右根
 * <p/>
 * <p/>
 * -            1
 * -        2       3
 * -      4   5       6
 * -        7   8
 * <p/>
 * 4 7 8 5 2 6 3 1
 * <p/>
 * 后序遍历的非递归实现：对于任一结点 P，将其入栈，然后沿其左子树一直往下搜索，直到搜索到没有左孩子的结点，此时该结点出现在栈顶，但是此时不能
 * 将其出栈并访问，因此其右孩子还为被访问。所以接下来按照相同的规则对其右子树进行相同的处理，当访问完其右孩子时，该结点又出现在栈顶，此时可
 * 以将其出栈并访问。这样就保证了正确的访问顺序。可以看出，在这个过程中，每个结点都两次出现在栈顶，只有在第二次出现在栈顶时，才能访问它。因
 * 此需要多设置一个变量标识该结点是否是第一次出现在栈顶
 *
 * @author CaMnter
 */
public class PostOrder<T> {

    void postOrderRecursive(TreeNode<T> root) {
        if (root == null) return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.value + " ");
    }

    void postOrder(TreeNode<T> root) {
        if (root == null) return;
        TreeNode<T> current = root;
        // 设置一个标记结点，用来确定是第几次访问栈顶元素
        // 主要用于标记一个 节点 的 right 节点是否输出了，用于判断是否要输出当前节点
        TreeNode<T> flag = null;
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                // 有左，处理左
                stack.push(current);
                current = current.left;
            } else {
                // 无左 尝试找右
                current = stack.peek();
                // 判断栈顶元素是否是第一次出现，以压入其右子树
                if (current.right != null && current.right != flag) {
                    // 无左，处理上一个节点的右，再指向左
                    current = current.right;
                    stack.push(current);
                    // return to left
                    current = current.left;
                } else {
                    // 无左，处理上一个节点的右，没有上一个节点的右，就打印，同时 flag 标记 该节点
                    // 然后标记 current 为 null，再次执行 无左 尝试找右
                    current = stack.pop();
                    // print
                    System.out.print(current.value + " ");
                    flag = current;
                    current = null;
                }
            }
        }
    }

    public static void main(String args[]) {
        PostOrder<Integer> postOrder = new PostOrder<Integer>();
        postOrder.postOrderRecursive(TreeNode.getTree());
        System.out.println("");
        postOrder.postOrder(TreeNode.getTree());
    }

}

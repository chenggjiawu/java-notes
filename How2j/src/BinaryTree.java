import java.util.ArrayList;
import java.util.List;

/**
 * @program JavaBooks
 * @description: 二叉树
 * @author: mf
 * @create: 2019/04/10 10:27
 */

public class BinaryTree {
    // 二叉树由各种节点组成
    // 每个节点都可以有左子节点，右子节点
    // 每一个节点都有一个值
    public static void main(String[] args) {
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 74 };
        Node roots = new Node();
        for (int random : randoms) {
            roots.add(random);
        }

        List<Object> list = roots.values();
        for (Object o : list) {
            System.out.println(o);
        }
//
//        Node tempLeftNode = roots;
//        System.out.println("left:");
//        while (tempLeftNode != null) {
//            System.out.println(tempLeftNode.value);
//            tempLeftNode = tempLeftNode.leftNode;
//        }
//        Node tempRightNode = roots;
//        System.out.println("right:");
//        while (tempRightNode != null) {
//            System.out.println(tempRightNode.value);
//            tempRightNode = tempRightNode.rightNode;
//        }
    }


}

class Node {
    // 左子节点
    public Node leftNode;
    // 右子节点
    public Node rightNode;

    // 当前节值
    public Object value;

    public void add (Object v) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value = v;
        // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值, 比当前值小或者相同
            if ((Integer) v - (Integer) value <= 0) {
                if (null == leftNode) leftNode = new Node();
                leftNode.add(v);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new Node();
                rightNode.add(v);
            }
        }
    }
    // 中序遍历所有的节点
    public List<Object> values() {
        List<Object> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftNode)
            values.addAll(leftNode.values());

        // 当前节点
        values.add(value);

        // 右节点的遍历结果
        if (null != rightNode)

            values.addAll(rightNode.values());

        return values;
    }
}
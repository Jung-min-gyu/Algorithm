package dataStructure;

public class NodeMgmt {
    Node head = null;

    public class Node{
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public boolean InsertNode(int data) {
        //case1 : node가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            //case2 : node가 하나 이상 들어가 있을 때
            Node findNode = this.head;
            while (true) {
                //case2-1 : 현재 node의 왼쪽에 node가 들어가야 할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                    //case2-2 : 현재 node의 오른쪽에 node가 들어가야 할 때
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NodeMgmt myTree = new NodeMgmt();
        myTree.InsertNode(2);
        myTree.InsertNode(3);
        myTree.InsertNode(4);
        myTree.InsertNode(6);
    }
}

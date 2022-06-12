package dataStructure;

public class NodeMgmt {
    Node head = null;

    public class Node{
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.value = data;
        }
    }

    public boolean insertNode(int data) {
        //case1 : node가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            //case2 : node가 하나 이상 들어가 있을 때
            Node findNode = this.head; //기존에 들어가 있는 node
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

    public Node search(int data) {
        //case1 : node가 하나도 없을 때
        if (this.head == null) {
            return null;
        } else { //case2 : node가 하나 이상 있을 때
            Node findNode = this.head; //루트 노드
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
        }
        return null;
    }

    public boolean delete(int value) {
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        //case1: node가 하나도 없을 때
        if (this.head == null) {
            return false;
        } else {
            //case2: node가 단지 하나만 있고, 해당 node가 삭제할 node 일 때
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }
            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }
            if (searched == false) {
                return false;
            }
        }
        //여기까지 실행된다면, currNode는 삭제되어질 해당 데이터를 가지고 있는 Node, currParentNode는 해당 데이터를 가지고 있는 Node의 부모 Node

        //delete case1 : 삭제할 node가 leaf node인 경우
        if (currNode.left == null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = null;
                currNode = null;
            } else {
                currParentNode.right = null;
                currNode = null;
            }
            return true;
        } else if (currNode.left != null && currNode.right == null) {
            //delete case2-1 : 삭제할 node가 child node를 왼쪽에 가지고 있을 경우
            if (value < currParentNode.value) {
                currParentNode.left = currNode.left;
                currNode = null;
            } else {
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
        } else if (currNode.right != null && currNode.left == null) {
            //delete case2-2 : 삭제할 node가 child node를 오른쪽에 가지고 있을 경우
            if (value < currParentNode.value) {
                currParentNode.left = currNode.right;
                currNode = null;
            } else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;
        } else { //delete case3: 삭제할 node가 child node를 두개 가지고 있을때

            //삭제할 node가 부모 node의 왼쪽에 있을 때
            if (value < currParentNode.value) {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                //여기까지 실행되면, changeNode에는 삭제할 Node의 오른쪽 node 중에서 가장 작은 값을 가진 Node가 들어있게 된다.

                if (changeNode.right != null) {
                    //delete case 3-1-2: changeNode의 오른쪽 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    //delete case 3-1-1: changeNode의 Child Node가 없을 때
                    changeParentNode.left = null;
                }
                //currParentNode의 왼쪽 자식인 삭제될 currNode의 오른쪽 자식 중 가장 작은 값이 changeNode이고,
                //changeNode는 currNode를 대신해 currParentNode의 왼쪽 자식으로 승격되어 연결된다.
                currParentNode.left = changeNode;

                //새로 바뀐 changeNode에 삭제된 currNode의 기존에 존재하던 왼쪽, 오른쪽 자식들을 연결시킨다.
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;

                currNode = null;
            } else { //삭제할 currNode가 currParentNode의 오른쪽 자식일때
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                //여기까지 실행되면, changeNode에는 삭제할 Node의 오른쪽 node 중에서 가장 작은 값을 가진 Node가 들어있게 된다.

                if (changeNode.right != null) {
                    //delete case 3-1-2: changeNode의 오른쪽 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    //delete case 3-1-1: changeNode의 Child Node가 없을 때
                    changeParentNode.left = null;
                }
                //currParentNode의 오른쪽 자식인 삭제될 currNode의 오른쪽 자식 중 가장 작은 값이 changeNode이고,
                //changeNode는 currNode를 대신해 currParentNode의 왼쪽 자식으로 승격되어 연결된다.
                currParentNode.right = changeNode;

                //새로 바뀐 changeNode에 삭제된 currNode의 기존에 존재하던 왼쪽, 오른쪽 자식들을 연결시킨다.
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;

                currNode = null;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        // Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우
        NodeMgmt myTree = new NodeMgmt();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }
}

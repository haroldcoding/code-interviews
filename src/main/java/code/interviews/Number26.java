package code.interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haroldcoding
 * @create 2017/07/20/21:49
 */
public class Number26 {
    
    /**
     * 第一步：复制原始链表上的每一个结点
     * 第二步：为复制链表上的每个结点设置随机结点
     * 时间复杂度：O(N)
     * 时间主要浪费在定位随机指针位置上
     */
    public static RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode currNode = pHead;
        RandomListNode newHead = null;
        RandomListNode newNode = null;
        RandomListNode preNode = null;
        // 复制原链表普通指针域
        while (currNode != null) {
            newNode = new RandomListNode(currNode.label);
            currNode = currNode.next;
            if (preNode == null) {
                newHead = newNode;
            } else {
                preNode.next = newNode;
            }
            preNode = newNode;
        }
        // 复制随机指针域
        currNode = pHead;
        newNode = newHead;
        while (currNode != null && newNode != null) {
            RandomListNode randomNode = currNode.random;
            RandomListNode newRandomNode = findInNew(pHead, newHead, randomNode);
            newNode.random = newRandomNode;
            currNode = currNode.next;
            newNode = newNode.next;
        }
        return newHead;
    }
    
    private static RandomListNode findInNew(RandomListNode pHead, RandomListNode newHead,
        RandomListNode randomNode) {
        RandomListNode newNode = newHead;
        RandomListNode oldNode = pHead;
        while (newNode != null && oldNode != null) {
            if (oldNode == randomNode) {
                return newNode;
            }
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return null;
    }
    
    /**
     * 第一步：复制原始链表上的每一个结点，同时将结点和复制结点配对放入一个哈希表中
     * 第二步：遍历哈希表完成随机结点的设置
     * 通过额外的O(n)的控件消耗把时间复杂度降低到O(N)
     */
    public static RandomListNode cloneUsingMap(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // key 为原链表中的结点， value 为新链表中的结点
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();
        RandomListNode newHead = null;
        RandomListNode newNode = null;
        RandomListNode preNewNode = null;
        while (pHead != null) {
            newNode = new RandomListNode(pHead.label);
            if (preNewNode == null) {
                newHead = newNode;
            } else {
                preNewNode.next = newNode;
            }
            nodeMap.put(pHead, newNode);
            preNewNode = newNode;
            pHead = pHead.next;
        }
        newNode = newHead;
        for (Map.Entry<RandomListNode, RandomListNode> item : nodeMap.entrySet()) {
            //设置随机结点
            // 因为key 为原链表中的结点， value 为新链表中的结点，所以根据当前key的随机结点是原链表的结点，也是
            // 随机结点和新链表中随机结点的对中的key 则根据 key 直接找到新链表中的随机结点的位置
            item.getValue().random =
                item.getKey().random == null ? null : nodeMap.get(item.getKey().random);
        }
        return newHead;
    }
    
    /**
     * 第一步：复制链表上的每一个结点 N ，同时将该复制结点 N~ 插入到原链表结点 N 后面
     */
    public static void cloneNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        RandomListNode nextNode = pHead.next;
        RandomListNode newNode = null;
        while (node != null) {
            newNode = new RandomListNode(node.label);
            node.next = newNode;
            newNode.next = nextNode;
            node = nextNode;
            if (node != null) {
                nextNode = node.next;
            }
        }
    }
    
    /**
     * 第二步：设置复制出来的结点的随机结点， 假设原始链表上的 N 的 随机结点指向结点 S ，那么对应复制出来的 N' 结点
     * S' 同样 S' 也是结点 S 的下一个结点
     */
    public static void setRandomNodes(RandomListNode pHead) {
        RandomListNode clonedNode = pHead.next;
        RandomListNode node = pHead;
        while (node != null) {
            clonedNode.random = node.random == null ? null : node.random.next;
            node = clonedNode.next;
            clonedNode = node != null ? node.next : null;
        }
    }
    
    /**
     * 第三步：把第二步得到的链表拆分成两个链表，奇数位置上的结点组成原链表，偶数位置上的链表组成复制出来的链表
     */
    public static RandomListNode reconnectNodes(RandomListNode pHead) {
        RandomListNode clonedHead = pHead.next;
        RandomListNode clonedNode = clonedHead;
        RandomListNode pNode = pHead;
        pNode.next = clonedNode.next;
        pNode = pNode.next;
        while (pNode != null) {
            clonedNode.next = pNode.next;
            clonedNode = clonedNode.next;
            pNode.next = clonedNode.next;
            pNode = pNode.next;
        }
        return clonedHead;
    }
    
    /**
     * 将以上三步合起来就是整个复制过程
     */
    public static RandomListNode clone2(RandomListNode pHead) {
        cloneNodes(pHead);
        setRandomNodes(pHead);
        return reconnectNodes(pHead);
    }
 
}

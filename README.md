Leetcode 2026

- [ ] 01.05 每日一题 [1161. 最大层内元素和](https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree)
    - java实现BFS: `LinkedList`实现`Queue`
        - 入队：`queue.offer()`
        - 出队: `queue.poll()`
    - BFS记录每层或层高: 
        - 每层：while循环里首先固定住size这个参数，在`<size`的for循环里: 出队操作 -> 左节点入队，右节点入队
        - 层高：while里面，在for循环外 每次++
    - DFS+level参数:
        - 设置public的`levelSum`(arrayList get()参数)
        - dfs递归, 前序遍历，在处理根节点时判断是不是第一访问到:
            - `sum.size()==level` 第一次访问到: levelSum.add()
            - 否则: `levelSum.set(level, culVal+node.val)`
        - 遍历levelSum (注意不是Array数组, `int[] x = new int[5]` 长度固定)

- [ ] 01.06 每日一题 
    - [1339. 分裂二叉树的最大乘积](https://leetcode.cn/problems/maximum-product-of-splitted-binary-tree/description/) 计算每颗子树之和：dfs后序遍历 
        - 什么时候判空: dfs(null)是否有明确定义，这里dfs(null)明确为0,或者可以**一直不判断，绝大多数情况(路径除外)，在dfs内判空返回**
        - operation: `int sum = leftSum + rightSum + cur.val`
        - 取模时 (int) (a%b)
    - [2049. 统计最高分的节点数目](https://leetcode.cn/problems/count-nodes-with-the-highest-score/description/) 计算每颗子数的节点数
        - 根据parent数组构建树：两次遍历
            - 第一次`TreeNode[]` new 每个节点
            - 第二次遍历parents数组，为每一个父节点加入子节点
        - operation: `int num = leftNum + rightNum + 1`
        - dfs后序遍历时，注意乘法用`long`
    - 比较好的做法：先得到total，要么dfs获取整颗树的总和或者直接n，然后dfs时用冒泡直接获取结果
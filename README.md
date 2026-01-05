Leetcode 2026

- [ ] 01.05 每日一题 1161. 最大层内元素和
    - java实现BFS: `LinkedList`实现`Queue`
        - 入队：`queue.offer()`
        - 出队: `queue.poll()`
    - BFS记录每层或层高: 
        - 每层：while循环里首先固定住size这个参数，在`<size`的for循环里: 出队操作 -> 左节点入队，右节点入队
        - 层高：while里面，在for循环外 每次++
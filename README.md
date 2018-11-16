## 源码和设计学习

---

[探讨RxJava的实现原理](RxJava)
> 从自己动手写的精简版的代码来看，RxJava用到了大量的匿名内部类和接口回调，从字面上来看想到内部类，这会让我们担忧这个框架的性能（内存泄漏方面）。
我觉得既然原作者能大胆的使用内部类，就说明他对内部类有很深的理解和使用经验。   
&emsp;&emsp;&emsp;回到正题,首先我们分析为何RxJava用到如此多的匿名内部类，却没有人质疑它的问题。

---

[android启动流程](img/android_root.png)
### Vue基础-基础用法

---

1. 请阐述Vue的常用指令有哪些，并说明其作用
   * v:text : 更新元素的 textContent 
   *  v-html : 更新元素的 innerHTML  
   * v-if : 如果为true, 当前标签才会输出到页面  
   * v-else: 如果为false, 当前标签才会输出到页面 
   *  v-show : 通过控制display样式来控制显示/隐藏  
   * v-for : 遍历数组/对象  
   * v-on : 绑定事件监听, 一般简写为@  
   * v-bind : 强制绑定解析表达式, 可以省略
   * v-bind  v-model : 双向数据绑定 
   *  ref : 为某个元素注册一个唯一标识, vue对象通过$refs属性访问这个元素对象 
   *  v-cloak : 使用它防止闪现表达式, 与css配合: [v-cloak] { display: none }

----

2. 用Vue实现数字的加减运算：

   (1)通过按钮控制使用加或者减运算

   (2)将运算结果显示到span标签中

   ```html
   <!DOCTYPE html>
   <html>
   
   <head>
       <meta charset="utf-8">
       <title></title>
       <script src="https://cdn.bootcdn.net/ajax/libs/vue/2.6.9/vue.js" type="text/javascript" charset="utf-8"></script>
   </head>
   
   <body>
       <div id="app" style=" text-align: center;">
           <button @click="sub">-</button>
           <span>{{num}}</span>
           <button @click="sup">+</button>
       </div>
   
       <script type="text/javascript">
           var vm = new Vue({
               el: "#app",
               data: {
                   num: 1
               },
               methods: {
                   sub: () => this.vm.num--,
                   sup: () => this.vm.num++
               }
           })
       </script>
   </body>
   
   </html>
   ```

   
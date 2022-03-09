### 请阐述ES6中回调地狱的解决方案（要求不止一种）

---

#### 回调地狱：

> ​	**回调函数套用过多。 前端的ajax和jsonp内部充斥着大量的异步，为了能够拿到异步的数据，使用了大量的回调函数，来获取将来异步执行成功之后的数据。**
> ​    **从一定程度上来说，回调地狱能解决问题，但是有缺点，或者说不优雅，阅读性非常差。**

---

#### 使用Promiss进行模拟(异步)解决回调地狱：

 ```javascript
 man = () => {
     return new Promise(
         (resolve, _reject) => {
             console.log('man开始跑了')
             setTimeout(() => {
                 console.log('man到了')
                 resolve(1)
             }, 1000)
         }
     )
 }
 
 woman = () => {
     return new Promise(
         (resolve, _reject) => {
             console.log('woman开始跑了')
             setTimeout(() => {
                 console.log('woman到了')
                 resolve(1)
             }, 2000)
         }
     )
 }
 
 Promise
     .all([man(), woman()])
     .then(() =>
         console.log('比赛结束')
     )
     .catch = (exception) => {
         console.log(exception);
     }
 ```

---

#### 使用Async进行模拟(异步)解决回调地狱：

 ```javascript
 man = () => {
     return new Promise(
         (resolve, _reject) => {
             console.log('man开始跑了')
             setTimeout(() => {
                 console.log('man到了')
                 resolve(1)
             }, 1000)
         }
     )
 }
 
 woman = () => {
     return new Promise(
         (resolve, _reject) => {
             console.log('woman开始跑了')
             setTimeout(() => {
                 console.log('woman到了')
                 resolve(1)
             }, 2000)
         }
     )
 }
 
 (async () => {
     try {
         (Promise.all([man(), woman()])
             .then(() => console.log('比赛结束')))
     } catch (error) {
         console.log(error);
     }
 })()
 ```

/**
 * 定义一个Student类和Person类，要求Student类继承自Person类
 * 说明：学生类中包含姓名、年龄等属性，包含学习、考试等方法。
 *
*/

class Person {
    constructor(name) {
        this.name = name
    }
    study = () => console.log(`${this.name}在学习`)
}

class Student extends Person {
    constructor(name, age) {
        super(name)
        this.age = age
    }

    exam = () => console.log(`${this.name}在考试`)
}

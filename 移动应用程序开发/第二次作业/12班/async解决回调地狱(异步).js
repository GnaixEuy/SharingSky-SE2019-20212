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
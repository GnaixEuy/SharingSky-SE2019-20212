isEvenNumber = number => number % 2 == 0
getEvenNumberSumBetweenOne2Hundred = () => {
    var result = 0
    for (let index = 1; index < 101; index++) {
        isEvenNumber(index) == true ? result += index : result = result
    }
    return result
}
console.log(getEvenNumberSumBetweenOne2Hundred())
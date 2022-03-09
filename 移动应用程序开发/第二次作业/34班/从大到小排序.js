newSort = arr => arr.sort((num1, num2) => num2 - num1)

let arr = [4, 5, 6, 1, 23, 55, 6, 7]

arr = newSort(arr)

console.log(arr);
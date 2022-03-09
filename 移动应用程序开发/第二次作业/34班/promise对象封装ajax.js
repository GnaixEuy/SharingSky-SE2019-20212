toAccess = () => new Promise((resolve, reject) => {
    var req = new XMLHttpRequest()
    req.open("GET", "https://api.github.com/users/yyq", true);
    req.send(null)
    req.onload = () => {
        if (req.readyState === 4 && req.status === 200) {
            console.log('success')
            var json = JSON.parse(req.response)
            document.body.innerHTML = `<image src=${json.avatar_url}>`
            resolve(1)
        } else {
            console.log('failed');
            resolve(1)
        }
    }
    req.onerror = () => {
        reject(Error("网络异常"))
    }
}).then(() => console.log('完成请求'))
toAccess()
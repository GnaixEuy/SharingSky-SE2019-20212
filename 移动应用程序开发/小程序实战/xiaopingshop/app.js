const BASE_URL = 'https://www.ibuy123.cn/api/'

App({
  // 重写request方法
  rewriteRequest() {
    // 监听 wx.request wx.downloadFild
    const keys = ['request', 'downloadFile']
    const methods = {}
    keys.forEach(key => {
      methods[key] = wx[key]
    })

    // 对请求统一处理函数
    function _request(method, {url,header = {},...options}) {
      // 请求url
      const path = BASE_URL + url;
      header['token'] = 'xxxxxx'
      return method.call(wx, {
        ...options,
        url: path,
        header
      })
    }

    keys.forEach(key => {
      Object.defineProperty(wx, key, {
        value() {
          return _request(methods[key], ...arguments)
        }
      })
    })
  },
  onLaunch() {    
    this.rewriteRequest();
    // // 展示本地存储能力
    // const logs = wx.getStorageSync('logs') || []
    // logs.unshift(Date.now())
    // wx.setStorageSync('logs', logs)

    // // 登录
    // wx.login({
    //   success: res => {
    //     // 发送 res.code 到后台换取 openId, sessionKey, unionId
    //   }
    // })
  },
  globalData: {
    userInfo: null
  }
})
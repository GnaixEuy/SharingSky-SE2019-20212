// swiper/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    banners:[
      // {url:'/images/1.jpg'},
      // {url:'/images/2.jpg'},
      // {url:'/images/3.jpg'},
    ],
    products:[

    ]
  },
 

  getBanner:function(){
    let url = '/banners/1'
    let that = this
    wx.request({
      url,
      success:function(res){
        console.log(res)
        that.setData({
          banners:res.data.items
        })
      }
    })
  },
  getRecentProducts:function(){
    let url = '/products/recent/count/6'
    let that = this
    wx.request({
      url,
      success:function(res){
        console.log(res)
        that.setData({
          products:res.data
        })
      }
    })
  },
  handleSearch:function(e){
    const keywords = e.detail.value
      console.log('search',e.detail.value)
      setTimeout(function(){
        wx.navigateTo({
          url: '/pages/product_search/index?keywords=' + keywords,
        })
      },1000)
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      this.getBanner(),
      this.getRecentProducts()
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
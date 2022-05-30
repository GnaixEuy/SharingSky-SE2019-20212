// pages/product_search/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      keywords:'',
      products:[],
      page:1,
      totalPages:0
  },
  getProducts:function(keywords,page=1,isRrefresh=false){
    let url = `/products?pagesize=8&keywords=${keywords}&page=${page}`
    let that = this
    wx.request({
      url,
      success(res){
        that.setData({
          products:that.data.products.concat(res.data.data),
          page:res.data.current_page,
          totalPages:res.data.last_page
        })
        if(isRrefresh){
          wx.stopPullDownRefresh()
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      const {keywords} = options;
      console.log('keywords',keywords);
      this.setData({
        keywords
      })
      this.getProducts(keywords)
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
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    console.log('下拉刷新');
    this.setData({
         products:[]
    })
    this.getProducts(this.data.keywords,1,true);
    
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    console.log('上拉加载');
    if(this.data.page < this.data.totalPages){
      this.getProducts(this.data.keywords,this.data.page+1,true)
    }else{
      wx.showToast({
        title: '我是有底线的',
        icon:'success',
        duration:1000
      })
    }
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
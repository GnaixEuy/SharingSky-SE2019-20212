// pages/product/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id: 0,
    counts: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
    product: [],
    index: 0,
    productCounts: 1,
    currentTabsIndex: 0,
  },
  getProductsInfo(productId) {
    let url = 'product/' + productId
    wx.request({
      url,
      success: res => {
        console.log('getProductsInfo', res.data, this);
        this.setData({
          product: res.data
        })
      }
    })
  },
  bindPickerChange(e) {
    let index = e.detail.value
    this.setData({
      index,
      productCounts: this.data.counts[index]
    })
  },
  handleTabsItemTap(event) {
    const index = event.currentTarget.dataset.index
    this.setData({
      currentTabsIndex: index
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    const id = options.id
    this.setData({ id })
    this.getProductsInfo(id)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})
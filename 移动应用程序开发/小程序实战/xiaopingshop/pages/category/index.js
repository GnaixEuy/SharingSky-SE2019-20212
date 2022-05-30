// pages/category/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    currentMenuIndex: 0,
    categories: [],
    categoryData: null
  },
  getCategories: function () {
    let that = this
    wx.request({
      url: 'categories',
      success: function (res) {
        console.log(res)
        const categoryData = res.data
        if (categoryData.length > 0) {
          that.getProductByCategory(categoryData[0].id)
        }
        that.setData({
          categories: categoryData
        })
      }
    })
  },
  changeCategory: function (event) {
    let { index, id } = event.currentTarget.dataset
    this.setData({
      currentMenuIndex: index
    })
    this.getProductByCategory(id)
  },
  getProductByCategory: function (id) {
    const url = `categories/${id}`
    const that = this
    wx.request({
      url,
      success: function (res) {
        console.log('res', res);
        const index = that.data.currentMenuIndex
        const categoryData = that.data.categories
        const dataObj = {
          products: res.data.products,
          topImgUrl: categoryData[index].img.url,
          title: categoryData[index].name
        }
        that.setData({
          categoryInfo: dataObj
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getCategories()
  },
  handleTap(event){
    const id = event.currentTarget.dataset.id
    wx.navigateTo({
      url: '/pages/product/index?id=' + id,
    })
  }
})
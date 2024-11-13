// 应用全局配置
module.exports = {
  baseUrl: 'http://localhost:8080',
  // baseUrl: 'http://vue.ruoyi.vip/prod-api',
  // 应用信息
  appInfo: {
    // 应用名称
    name: "bubo-app",
    // 应用版本
    version: "1.0.0",
    // 应用logo
    logo: "/static/logo.png",
    // 官方网站
    site_url: "http://bubo.vip",
    // 政策协议
    agreements: [{
        title: "隐私政策",
        url: "https://bubo.vip/protocol.html"
      },
      {
        title: "用户服务协议",
        url: "https://bubo.vip/protocol.html"
      }
    ],
    //百度地图
    baidumap:{
      ak:"123"
    }
  }
}

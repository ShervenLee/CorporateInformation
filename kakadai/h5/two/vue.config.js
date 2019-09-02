const path = require("path");

// vue.config.js 配置
module.exports = {
    // 项目启动后的服务器目录
    baseUrl:process.env.NODE_ENV === 'production'?'./':'/',

    // 关闭产品模式的 调试功能
    productionSourceMap:false,

    css:{
        // 开启样式调试文件
        sourceMap:true
    },

    // 开发服务器配置
    devServer:{
        // 为了实现 同局域网的 手机调试功能
        host:"0.0.0.0",
        port:8080,
        // proxy:{}  代理配置
    },
    // 项目插件管理器
    pluginOptions: {
      'style-resources-loader': {
        preProcessor: 'less',
        patterns: [
            // 不能使用相对路径=>可以加载但无法热更新
            // 对组件进行全局less文件的加载
            // 使用 node的 path 方式进行路径合并
            // "./src/less/var.less"
            path.resolve(__dirname,"./src/less/var.less")
        ]
      }
    }
}
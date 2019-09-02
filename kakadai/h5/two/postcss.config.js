module.exports = {
  plugins: {
    autoprefixer: {},
    "postcss-pxtorem":{
      rootValue:75, // 定义UI设计稿的比例/10  1rem 对应的大小
      propList:["*"]// 描述样式中哪些样式需要被转换为 rem
    }
  }
}

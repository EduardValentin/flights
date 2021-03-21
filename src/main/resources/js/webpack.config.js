var path = require("path");
const HtmlWebPackPlugin = require("html-webpack-plugin");

module.exports = {
  entry: {
    javascript: "./app.js",
  },
  devtool: "sourcemaps",
  cache: true,
  mode: "development",
  output: {
    path: path.resolve(__dirname, 'out'),
    publicPath: '/public/',
    filename: 'bundle.js'
  },
  devServer: {
    historyApiFallback: true,
    port: 3000,
    contentBase: path.resolve(__dirname, 'public'),
    hot: true
    
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /(node_modules)/,
        use: [
          {
            loader: "babel-loader",
            options: {
              presets: ["@babel/preset-env", "@babel/preset-react"],
            },
          },
        ],
      },
  
      {
        test: /\.css$/i,
        use: ["style-loader", "css-loader"],
      },
     
    ],
  },
};

import store from './store'
// 公共的请求
 const request = function(options) {
     options.url = store.state.app.fileServerUrl + options.url;
     try {
       const token = uni.getStorageSync('token');
       const username = uni.getStorageSync('username');
       if (token) {
         options.header = {
           'Authorization' : 'Bearer ' + token
         };
        }else{
            uni.navigateTo({
                url: '/pages/index/index' 
            });
            return;
        }
     } catch (err) {
      console.log(err)
    }
    return uni.request(options);
  }
export default request;
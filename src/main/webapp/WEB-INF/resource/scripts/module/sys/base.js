/**
 * 基础base脚本
 * @date 2016/3/26
 *
 * @author Carl
 * @note
 * --------------------
 * @depend sea.js
 * @modify
 * 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */

seajs.config({
    base : "./js/",
    //别名
    alias :{
        "jquery" : "lib/jquery/jquery.min.js",
        "jquery.flexisel": "lib/jquery/jquery.flexisel.js",
        "jquery.leanModal": "lib/jquery/jquery.leanModal.min.js",
        "sea" : "lib/seajs/sea.js",
        "bootstrap" : "common/bootstrap.min.js",
        "bootstrap-select" : "common/bootstrap-select.js"
    },
    // 文件编码
    charset: 'utf-8'
});


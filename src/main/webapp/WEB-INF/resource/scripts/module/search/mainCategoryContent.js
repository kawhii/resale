/**
 * 目录页内容处理脚本，一般用于显示不同的目录详细
 * @date 2016/3/27
 *
 * @author Carl
 * @note
 * --------------------
 * @depend
 * @modify
 * 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */

//TODO js加载有bug
/*define("~/search/mainCategoryContent.js", ["jquery", "easyResponsiveTabs"], function (require, exports, module) {
 *//**
 * 切换改变初始化
 *//*
 function tabChangeInit() {
 //Vertical Tab
 $('#parentVerticalTab').easyResponsiveTabs({
 type: 'vertical', //Types: default, vertical, accordion
 width: 'auto', //auto or any width like 600px
 fit: true, // 100% fit in a container
 closed: 'accordion', // Start closed if in accordion view
 tabidentify: 'hor_1', // The tab groups identifier
 activate: function (event) { // Callback function if tab is switched
 var $tab = $(this);
 var $info = $('#nested-tabInfo2');
 var $name = $('span', $info);
 $name.text($tab.text());
 $info.show();
 }
 });
 }
 return {
 init: function() {
 tabChangeInit();
 }
 }
 });*/

;
(function () {
    function tabChangeInit() {
        //Vertical Tab
        $('#parentVerticalTab').easyResponsiveTabs({
            type: 'vertical', //Types: default, vertical, accordion
            width: 'auto', //auto or any width like 600px
            fit: true, // 100% fit in a container
            closed: 'accordion', // Start closed if in accordion view
            tabidentify: 'hor_1', // The tab groups identifier
            activate: function (event) { // Callback function if tab is switched
                var $tab = $(this);
                var $info = $('#nested-tabInfo2');
                var $name = $('span', $info);
                $name.text($tab.text());
                $info.show();
            }
        });
    }

    function init() {
        //允许延迟加载
        //$("img.lazy").lazyload({ effect : "fadeIn",event : "click" });
        tabChangeInit();
    }

    init();
})();

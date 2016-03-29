<!--
 分类搜索题
 @date 2016/3/27
 @author Carl
 @note
 @depend
 @modify
 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 -->
<link rel="stylesheet" href="styles/common/bootstrap-select.css"/>
<script type="application/javascript" src="js/common/bootstrap.min.js"></script>
<script type="application/javascript" src="js/common/bootstrap-select.js"></script>
<div class="total-ads main-grid-border">
    <div class="container">
        <#--这里包含是指spring mvc设置的views路径开始的-->
        <#include "freemarker/search/searchBar.ftl"/>
        <#include "freemarker/search/categories.ftl"/>
        <#include "freemarker/search/navBar.ftl"/>
        <#include "freemarker/search/advGrid.ftl"/>
    </div>
</div>
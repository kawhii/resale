<!--
 目录栏
 @date 2016/3/27
 @author Carl
 @note
 @depend
 @modify
 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 -->
<div class="all-categories">
    <h3> Select your category and find the perfect ad</h3>
    <ul class="all-cat-list">
    <#list result.listCategory as category>
        <li><a href="cf/search?categoryId=${category.id}">${category.name} <span class="num-of-ads">(${category.goodsCount})</span></a></li>
    </#list>
    </ul>
</div>
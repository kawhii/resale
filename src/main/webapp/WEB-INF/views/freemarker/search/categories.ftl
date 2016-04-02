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
    <#assign currQuery=(request.getQueryString())?replace("&{0,1}categoryId=\\w{24}&{0,1}", "&","r")>
    <#assign currQuery=currQuery?replace("&{0,1}specificTypeId=\\w{24}&{0,1}", "","r")>
    <#assign currQuery=currQuery?replace("&{0,1}showTypeId=\\w{24}&{0,1}", "","r")>
    <#assign currQuery=currQuery?replace("&{0,1}page=\\d+&{0,1}", "","r")>
    <#if !currQuery?ends_with("&")>
        <#assign currQuery=currQuery+"&">
    </#if>
    <#list result.listCategory as category>
        <li><a href="cf/search?${currQuery}categoryId=${category.id}">${category.name} <span
                class="num-of-ads">(${category.goodsCount})</span></a></li>
    </#list>
    </ul>
</div>
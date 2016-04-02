<!--
 导航栏
 @date 2016/3/27
 @author Carl
 @note
 @depend
 @modify
 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 -->
<#--自定义宏变量用于遍历导航变量-->
<#macro navBarParamFun navBar>
<#if navBar?? && navBar.key??>
&${navBar.key}=${navBar.value}
</#if>
<#if navBar?? && navBar.children??>
<#list navBar.children as c>
<@navBarParamFun navBar=c></@navBarParamFun>
</#list>
</#if>
</#macro>
<ol class="breadcrumb" style="margin-bottom: 5px;">
    <li><a href="">首页</a></li>
    <#list result.bars as b>
        <#if !b_has_next>
            <li class="active">${b.name}</li>
        <#else>
            <li><a href="cf/search?<@navBarParamFun navBar=b></@navBarParamFun>">${b.name}</a></li>
        </#if>
    </#list>
</ol>
<#--分页条
result.body 提供分页信息
-->
<#assign pageInfo=result.body>
<#assign queryInfo=(request.getQueryString())>
<#assign queryInfo=queryInfo?replace("&{0,1}page=\\d+&{0,1}", "&","r")>
<#if !queryInfo?ends_with("&")>
    <#assign queryInfo=queryInfo+"&">
</#if>
<#if pageInfo?? && (pageInfo.total > 0)>
    <li>
        <a
        <#if pageInfo.page == 1>
                href="javascript:void(0)"
        <#else>
                href="cf/search?${queryInfo}page=${pageInfo.page-1}"
        </#if>
        >上一页</a>
    </li>
    <#list 0..pageInfo.pageCount-1 as i>
        <#if i&lt;pageInfo.page-3>
            <#if !preGen??>
                <li><a href="javascript://">...</a></li>
                <#assign preGen="true">
            </#if>
        <#elseif i&lt;pageInfo.page+2>
            <li><a href="cf/search?${queryInfo}page=${i+1}">
                <#if i+1 == pageInfo.page>
                    <b>${i+1}</b>
                <#else>
                    ${i+1}
                </#if>
                </a>
            </li>
        <#elseif  !sufGen??>
            <li><a href="javascript:void(0)">...</a></li><#assign sufGen="true">
        </#if>
    </#list>
    <li>
        <a
            <#if pageInfo.page == pageInfo.pageCount>
                    href="javascript:void(0)"
            <#else>
                    href="cf/search?${queryInfo}page=${pageInfo.page+1}"
            </#if>
        >下一页</a>
    </li>
<#else>
没有找到符合条件的数据
</#if>
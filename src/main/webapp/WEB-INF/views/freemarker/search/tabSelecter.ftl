<ul id="myTab" class="nav nav-tabs nav-tabs-responsive" role="tablist">
<#if result.categoryDetail.showTypes??>
    <#assign currQueryShowTypeId=(request.getQueryString())?replace("&{0,1}showTypeId=\\w{24}&{0,1}", "&","r")>
    <#list result.categoryDetail.showTypes as t>
        <li role="presentation"
            <#if (t_index == 0 && !result.showTypeId?exists) || (t.id == result.showTypeId)>
            class="active"
            </#if>
                >
            <a
                <#if (t_index == 0 && !result.showTypeId?exists) || (t.id == result.showTypeId)>
                        href="javascript:void(0)"
                <#else>
                        href="cf/search?${currQueryShowTypeId}&showTypeId=${t.id}"
                </#if>
                        <#--role="tab" data-toggle="tab" aria-controls="home"
                        aria-expanded="true"-->
                    >
                <span class="text">${t.title}</span>
            </a>
        </li>
    </#list>
</#if>
</ul>
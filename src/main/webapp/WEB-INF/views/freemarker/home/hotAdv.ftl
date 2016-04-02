<ul id="flexiselDemo3">
        <#list hotAdv as a>
        <#if a_index % 4 == 0>
        <li>
            <#assign nextEnd=a_index+4>
        </#if>
            <div class="col-md-3 biseller-column">
                <a href="single.html">
                    <img src="file/img/${a.advantage.previewImage.id}.${a.advantage.previewImage.type}"/>
                    <span class="price">￥${a.advantage.price}</span>
                </a>
                <div class="ad-info">
                    <h5>${a.advantage.describe}</h5>
                    <span><#if a.advantage.publishTimeType == 0>
                        今天<#elseif a.advantage.publishTimeType == 1>
                        昨天<#elseif a.advantage.publishTimeType == 2>前天<#else>以前</#if>
                        , ${a.advantage.publishTime?string("HH:mm")}</span>
                </div>
            </div>
            <#if a_index == nextEnd || !a_has_next>
            </li>
            </#if>
        </#list>
</ul>
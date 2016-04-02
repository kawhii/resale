<!--
主目录搜索栏
 @date 2016/3/27
 @author Carl

 @note
 @depend
 @modify
 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 -->
<#--<script type="application/javascript">
    seajs.use("~/search/mainCategoryContent.js", function (c) {
        c.init();
    });
</script>-->
<#--<script type="application/javascript" src="js/lib/jquery-lazyload/jquery.lazyload.min.js"></script>-->
<script type="application/javascript" src="js/common/easyResponsiveTabs.js"></script>
<div class="categories-section main-grid-border">
    <div class="container">
        <h2 class="head">主目录</h2>

        <div class="category-list">
            <div id="parentVerticalTab" class="resp-vtabs hor_1" style="display: block; width: 100%; margin: 0px;">
                <ul class="resp-tabs-list hor_1" style="margin-top: 3px;">
                <#list categories as category>
                    <li class="resp-tab-item hor_1"
                        aria-controls="hor_1_tab_item-${category_index}"
                        role="tab"
                        style="border-color: rgb(193, 193, 193); background-color: rgb(245, 245, 245);">
                    ${category.name}
                    </li>
                    <#if !category_has_next>
                        <a href="cf/search">全部</a>
                    </#if>
                </#list>
                </ul>
                <div class="resp-tabs-container hor_1" style="border-color: rgb(193, 193, 193);">
                    <span class="active total" style="display:block;" data-toggle="modal"
                          data-target="#myModal"><strong>All USA</strong> (Select your city to see local ads)</span>
                <#--遍历详细-->
                <#list categories as c>
                    <h2 class="resp-accordion hor_1"
                        role="tab"
                        aria-controls="hor_1_tab_item-${c_index}"
                        style="border-color: rgb(193, 193, 193); background: none rgb(245, 245, 245);"><span
                            class="resp-arrow"></span>${c.name}</h2>

                    <div class="resp-tab-content hor_1" aria-labelledby="hor_1_tab_item-${st_index}">
                        <div class="category">
                            <div class="category-img">
                                <#if c.imageId??>
                                    <img class="lazy" src="file/img/${c.imageId}.${c.imageType}" title="${c.name}" alt=""></img>
                                </#if>
                            </div>
                            <div class="category-info">
                                <h4>${c.name}</h4>
                                <span>${c.goodsCount}条</span>
                                <a href="cf/search?categoryId=${c.id}">查看全部</a>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="sub-categories">
                            <ul>
                                <#if c.specTypes?exists>
                                    <#list c.specTypes as st>
                                        <li><a href="cf/search?categoryId=${c.id}&specificTypeId=${st.id}">${st.name}</a></li>
                                    </#list>
                                    <div class="clearfix"></div>
                                </#if>
                            </ul>
                        </div>
                    </div>
                </#list>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="application/javascript" src="js/~/search/mainCategoryContent.js"></script>
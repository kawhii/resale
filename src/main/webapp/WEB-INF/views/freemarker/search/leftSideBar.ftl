<!--
 左边搜索广告栏
 @date 2016/3/27
 @author Carl
 @note
 @depend
 @modify
 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 -->
<div class="side-bar col-md-3">
    <div class="search-hotel">
        <h3 class="sear-head">Name contains</h3>

        <form>
            <input type="text" value="Product name..." onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = 'Product name...';}" required="">
            <input type="submit" value=" ">
        </form>
    </div>

<#if result.categoryDetail?? && result.categoryDetail.specTypes>
    <div class="brand-select">
        <h3 class="sear-head">Brand name</h3>

        <div class="btn-group bootstrap-select">
            <select class="selectpicker" data-live-search="true" tabindex="-98">
                <option data-tokens="All">All</option>
                <#list result.categoryDetail.specTypes as st>
                    <option data-tokens="${st.id}">${st.name}</option>
                </#list>
            </select>
        </div>
    </div>
</#if>

    <div class="featured-ads">
        <h2 class="sear-head fer">推荐广告${result.listHotAdv?size}</h2>
        <#list result.listHotAdv as ha>
            <div class="featured-ad">
                <a href="single.html">
                    <div class="featured-ad-left">
                        <img
                                class="hot_lazy"
                                data-original="file/img/${ha.advantage.previewImage.id}.${ha.advantage.previewImage.type}"  alt="">
                    </div>
                    <div class="featured-ad-right">
                        <h4>${ha.advantage.title}</h4>

                        <p>￥${ha.advantage.price}</p>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </div>
        </#list>
        <div class="clearfix"></div>
    </div>
</div>
<script type="application/javascript">
    ;
    (function () {
        $("img.hot_lazy").lazyload({effect: "fadeIn"});
    })();
</script>
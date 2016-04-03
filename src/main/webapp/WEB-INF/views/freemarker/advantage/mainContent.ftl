<!--single-page-->
<div class="single-page main-grid-border">
    <div class="container">
    <#include "freemarker/search/navBar.ftl"/>
        <div class="product-desc">
            <div class="col-md-7 product-view">
                <h2>${adv.title}</h2>
                <p> <i class="glyphicon glyphicon-map-marker"></i><#--<a href="#">state</a>, --><a href="cf/search?cityId=${adv.area.id}">${adv.area.name}</a>| 发布于 ${adv.publishTime?string("HH:mm")}</p>
                <div class="flexslider">
                    <ul class="slides">
                        <#list adv.displayImgs as img>
                            <li data-thumb="file/img/${img.id}.${img.type}">
                                <img src="file/img/${img.id}.${img.type}" />
                            </li>
                        </#list>
                    </ul>
                </div>
                <script>
                    // Can also be used with $(document).ready()
                    $(window).load(function() {
                        $('.flexslider').flexslider({
                            animation: "slide",
                            controlNav: "thumbnails"
                        });
                    });
                </script>
                <!-- //FlexSlider -->
                <div class="product-details">
                    <h4>品牌 : <a href="#">${adv.brand.name}</a></h4>
                    <h4>浏览数 : <strong>${adv.views}</strong></h4>
                    <p><strong>Display </strong>: ${adv.describe}</p>
                    <p><strong>Summary</strong> : ${adv.summary}</p>

                </div>
            </div>
        <#include "freemarker/advantage/rightDetail.ftl"/>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--//single-page-->
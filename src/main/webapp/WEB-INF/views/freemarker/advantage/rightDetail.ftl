<div class="col-md-5 product-details-grid">
    <div class="item-price">
        <div class="product-price">
            <p class="p-price">价钱</p>
            <h3 class="rate">￥${adv.price}</h3>
            <div class="clearfix"></div>
        </div>
        <div class="condition">
            <p class="p-price">状态</p>
            <h4>${adv.condition}</h4>
            <div class="clearfix"></div>
        </div>
        <div class="itemtype">
            <p class="p-price">类型</p>
            <h4>${adv.specificType.name}</h4>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="interested text-center">
        <h4>对此感兴趣？<small> 联系卖家!</small></h4>
        <p><i class="glyphicon glyphicon-earphone"></i>${adv.publishUser.contactPhone!'10086'}</p>
    </div>
<#include "freemarker/advantage/tips.ftl"/>
</div>
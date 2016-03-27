<!--首页品牌-->
<#list brands as brand>
<div class="col-md-2 focus-grid">
    <a href="category/${brand.id}#parentVerticalTab${brand_index + 1}">
        <div class="focus-border">
            <div class="focus-layout">
                <div class="focus-image"><i class="fa fa-${brand.cssName}"></i></div>
                <h4 class="clrchg">${brand.name}</h4>
            </div>
        </div>
    </a>
</div>
</#list>


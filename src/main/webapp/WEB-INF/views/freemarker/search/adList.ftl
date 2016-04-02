<!--
 广告列表
 @date 2016/3/27
 @author Carl
 @note
 @depend
 @modify
 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 -->
<script type="application/javascript" src="js/lib/jquery-lazyload/jquery.lazyload.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var elem = $('#container ul');
        $('#viewcontrols a').on('click', function (e) {
            if ($(this).hasClass('gridview')) {
                elem.fadeOut(1000, function () {
                    $('#container ul').removeClass('list').addClass('grid');
                    $('#viewcontrols').removeClass('view-controls-list').addClass('view-controls-grid');
                    $('#viewcontrols .gridview').addClass('active');
                    $('#viewcontrols .listview').removeClass('active');
                    elem.fadeIn(1000);
                });
            }
            else if ($(this).hasClass('listview')) {
                elem.fadeOut(1000, function () {
                    $('#container ul').removeClass('grid').addClass('list');
                    $('#viewcontrols').removeClass('view-controls-grid').addClass('view-controls-list');
                    $('#viewcontrols .gridview').removeClass('active');
                    $('#viewcontrols .listview').addClass('active');
                    elem.fadeIn(1000);
                });
            }
        });
    });
</script>
<script type="text/javascript">
    String.prototype.endWith = function (s) {
        if (s == null || s == "" || this.length == 0 || s.length > this.length)
            return false;
        if (this.substring(this.length - s.length) == s)
            return true;
        else
            return false;
        return true;
    }
    String.prototype.startWith = function (s) {
        if (s == null || s == "" || this.length == 0 || s.length > this.length)
            return false;
        if (this.substr(0, s.length) == s)
            return true;
        else
            return false;
        return true;
    }
</script>
<div class="ads-display col-md-9">
    <div class="wrapper">
        <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
        <#include "freemarker/search/tabSelecter.ftl">
            <div id="myTabContent" class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="home" aria-labelledby="home-tab">
                    <div>
                        <div id="container">
                            <div class="view-controls-list" id="viewcontrols">
                                <label>view :</label>
                                <a class="gridview"><i class="glyphicon glyphicon-th"></i></a>
                                <a class="listview active"><i class="glyphicon glyphicon-th-list"></i></a>
                            </div>
                            <div class="sort">
                                <div class="sort-by">
                                    <label>排序 : </label>
                                    <select onchange="javascript:window.location ='cf/search'+(window.location.search.replace(/&{0,1}order=\w{4}&{0,1}/g,'&').endWith('&')?window.location.search.replace(/&{0,1}order=\w{4}&{0,1}/g,'&')+'order=':window.location.search.replace(/&{0,1}order=\w{4}&{0,1}/g,'&')+'&order=')+this.value">
                                        <option value="time" <#if result.order == 'time'>selected</#if>>发布时间</option>
                                        <option value="view" <#if result.order == 'view'>selected</#if>>查看量</option>
                                    </select>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <ul class="list">
                            <#if result.body?? && result.body.rows>
                                <#list result.body.rows as r>
                                    <#if r.previewImage?? && r.previewImage.type??>
                                        <a href="cf/search?categoryId=${r.category.id}&specificTypeId=${r.specificType.id}">
                                            <li>
                                                <img class="lazy"
                                                     data-original="file/img/${r.previewImage.id}.${r.previewImage.type}"
                                                     alt=""/>
                                                <section class="list-left">
                                                    <h5 class="title">${r.title}</h5>
                                                    <span class="adprice">￥${r.price}</span>

                                                    <p class="catpath">${r.category.name} » ${r.specificType.name}</p>
                                                </section>
                                                <section class="list-right">
                                                    <span class="date"><#if r.publishTimeType == 0>
                                                        今天<#elseif r.publishTimeType == 1>
                                                        昨天<#elseif r.publishTimeType == 2>前天<#else>以前</#if>
                                                        , ${r.publishTime?string("HH:mm")}
                                                        <span class="cityname">${r.area.name}</span>
                                                </section>
                                                <div class="clearfix"></div>
                                            </li>
                                        </a>
                                    <#else>
                                        <a href="cf/search?categoryId=${r.category.id}&specificTypeId=${r.specificType.id}">
                                            <li>
                                                <section class="list-left">
                                                    <h5 class="title">${r.title}</h5>

                                                    <p class="catpath">${r.category.name} » ${r.specificType.name}</p>
                                                </section>
                                                <section class="list-right">
                                                <span class="date"><#if r.publishTimeType == 0>
                                                    今天<#elseif r.publishTimeType == 1>
                                                    昨天<#elseif r.publishTimeType == 2>前天<#else>以前</#if>
                                                    , ${r.publishTime?string("HH:mm")}</span>
                                                    <span class="cityname">${r.area.name}</span>
                                                </section>
                                                <div class="clearfix"></div>
                                            </li>
                                        </a>
                                    </#if>

                                </#list>
                            </#if>
                            </ul>
                        </div>
                    </div>
                </div>
                <ul class="pagination pagination-sm">
                    <#include "freemarker/common/pageBar.ftl"/>
                </ul>
            </div>
        </div>
    </div>
</div>
<script type="application/javascript">
    ;
    (function () {
        $("img.lazy").lazyload({effect: "fadeIn"});
    })();
</script>
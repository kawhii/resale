<!--
 搜索栏
 @date 2016/3/27
 @author Carl
 @note
 @depend
 @modify
 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 -->
<script>
    $(document).ready(function () {
        var mySelect = $('#first-disabled2');

        $('#special').on('click', function () {
            mySelect.find('option:selected').prop('disabled', true);
            mySelect.selectpicker('refresh');
        });

        $('#special2').on('click', function () {
            mySelect.find('option:disabled').prop('disabled', false);
            mySelect.selectpicker('refresh');
        });

        $('#basic2').selectpicker({
            liveSearch: true,
            maxOptions: 1
        });
    });
</script>
<div class="select-box">
    <form id="ID_categorySearch">
        <div class="select-city-for-local-ads ads-list">
            <label>Select your city to see local ads</label>
            <select name="cityId">
            <#list result.listArea as city>
                <optgroup label="${city.name}">
                    <#list city.children as c>
                        <option <#if c.id == result.cityId>selected</#if> value="${c.id}">${c.name}</option>
                    </#list>
                </optgroup>
            </#list>
            </select>
        </div>
        <div class="browse-category ads-list">
            <label>Browse Categories</label>

            <div class="btn-group bootstrap-select show-tick">

                <select class="selectpicker show-tick" data-live-search="true" tabindex="-98" name="categoryId">
                    <option data-tokens="Mobiles" value="">全部</option>
                <#list result.listCategory as category>
                    <option <#if category.id == result.categoryId>selected</#if>
                            data-tokens="${category.id}" value="${category.id}">${category.name}</option>
                </#list>
                </select></div>
        </div>
        <div class="search-product ads-list">
            <label>Search for a specific product</label>

            <div class="search">
                <div id="custom-search-input">
                    <div class="input-group">
                        <input type="text" class="form-control input-lg" placeholder="Buscar">
							<span class="input-group-btn">
								<button class="btn btn-info btn-lg" type="button" onclick="javascript:window.location='cf/search?' + ($('#ID_categorySearch').serialize())">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
							</span>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <div class="clearfix"></div>
</div>
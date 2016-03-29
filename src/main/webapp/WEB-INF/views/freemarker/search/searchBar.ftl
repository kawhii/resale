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
    <div class="select-city-for-local-ads ads-list">
        <label>Select your city to see local ads</label>
        <select>
        <#list listArea as city>
            <optgroup label="${city.name}">
                <#list city.children as c>
                    <option <#if c.id == cityId>selected</#if> value="${c.id}">${c.name}</option>
                </#list>
            </optgroup>
        </#list>
        </select>
    </div>
    <div class="browse-category ads-list">
        <label>Browse Categories</label>

        <div class="btn-group bootstrap-select show-tick">

            <select class="selectpicker show-tick" data-live-search="true" tabindex="-98">
                <option data-tokens="Mobiles">All</option>
            <#list listCategory as category>
                <option <#if c.id == categoryId>selected</#if> data-tokens="${category.id}">${category.name}</option>
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
								<button class="btn btn-info btn-lg" type="button">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
							</span>
                </div>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
</div>
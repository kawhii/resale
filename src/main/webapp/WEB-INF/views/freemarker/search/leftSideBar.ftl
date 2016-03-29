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
            <input type="text" value="Product name..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Product name...';}" required="">
            <input type="submit" value=" ">
        </form>
    </div>

    <div class="range">
        <h3 class="sear-head">Price range</h3>
        <ul class="dropdown-menu6">
            <li>

                <div id="slider-range" class="ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all"><div class="ui-slider-range ui-widget-header" style="left: 0.5555555555555556%; width: 66.1111111111111%;"></div><a class="ui-slider-handle ui-state-default ui-corner-all" href="#" style="left: 0.5555555555555556%;"></a><a class="ui-slider-handle ui-state-default ui-corner-all" href="#" style="left: 66.66666666666666%;"></a></div>
                <input type="text" id="amount" style="border: 0; color: #ffffff; font-weight: normal;">
            </li>
        </ul>
        <!---->

        <script type="text/javascript">//<![CDATA[
        $(window).load(function(){
            $( "#slider-range" ).slider({
                range: true,
                min: 0,
                max: 9000,
                values: [ 50, 6000 ],
                slide: function( event, ui ) {  $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
                }
            });
            $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) + " - $" + $( "#slider-range" ).slider( "values", 1 ) );

        });//]]>

        </script>

    </div>
    <div class="featured-ads">
        <h2 class="sear-head fer">Featured Ads</h2>
        <div class="featured-ad">
            <a href="single.html">
                <div class="featured-ad-left">
                    <img src="images/f1.jpg" title="ad image" alt="">
                </div>
                <div class="featured-ad-right">
                    <h4>Lorem Ipsum is simply dummy text of the printing industry</h4>
                    <p>$ 450</p>
                </div>
                <div class="clearfix"></div>
            </a>
        </div>
        <div class="featured-ad">
            <a href="single.html">
                <div class="featured-ad-left">
                    <img src="images/f2.jpg" title="ad image" alt="">
                </div>
                <div class="featured-ad-right">
                    <h4>Lorem Ipsum is simply dummy text of the printing industry</h4>
                    <p>$ 380</p>
                </div>
                <div class="clearfix"></div>
            </a>
        </div>
        <div class="featured-ad">
            <a href="single.html">
                <div class="featured-ad-left">
                    <img src="images/f3.jpg" title="ad image" alt="">
                </div>
                <div class="featured-ad-right">
                    <h4>Lorem Ipsum is simply dummy text of the printing industry</h4>
                    <p>$ 560</p>
                </div>
                <div class="clearfix"></div>
            </a>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
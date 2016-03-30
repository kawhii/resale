<!--
 广告列表
 @date 2016/3/27
 @author Carl
 @note
 @depend
 @modify
 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 -->
<script type="text/javascript">
    $(document).ready(function () {
        var elem=$('#container ul');
        $('#viewcontrols a').on('click',function(e) {
            if ($(this).hasClass('gridview')) {
                elem.fadeOut(1000, function () {
                    $('#container ul').removeClass('list').addClass('grid');
                    $('#viewcontrols').removeClass('view-controls-list').addClass('view-controls-grid');
                    $('#viewcontrols .gridview').addClass('active');
                    $('#viewcontrols .listview').removeClass('active');
                    elem.fadeIn(1000);
                });
            }
            else if($(this).hasClass('listview')) {
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
<div class="ads-display col-md-9">
    <div class="wrapper">
        <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
            <ul id="myTab" class="nav nav-tabs nav-tabs-responsive" role="tablist">
                <li role="presentation" class="active">
                    <a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">
                        <span class="text">All Ads</span>
                    </a>
                </li>
                <li role="presentation" class="next">
                    <a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile">
                        <span class="text">Ads with Photos</span>
                    </a>
                </li>
                <li role="presentation">
                    <a href="#samsa" role="tab" id="samsa-tab" data-toggle="tab" aria-controls="samsa">
                        <span class="text">Company</span>
                    </a>
                </li>
            </ul>
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
                                    <label>Sort By : </label>
                                    <select>
                                        <option value="">Most recent</option>
                                        <option value="">Price: Rs Low to High</option>
                                        <option value="">Price: Rs High to Low</option>
                                    </select>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <ul class="list">
                                <a href="single.html">
                                    <li>
                                        <img src="images/m1.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$290</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:55</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m2.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">It is a long established fact that a reader long established</h5>
                                            <span class="adprice">$310</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:45</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m3.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">Contrary to popular belief, Lorem Ipsum is not</h5>
                                            <span class="adprice">$190</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:30</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m4.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">The standard chunk of Lorem Ipsum used since the</h5>
                                            <span class="adprice">$480</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:25</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m5.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">Sed ut perspiciatis unde omnis iste natus error sit voluptatem</h5>
                                            <span class="adprice">$859</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:24</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m6.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">But I must explain to you how all this mistaken idea of denouncing</h5>
                                            <span class="adprice">$1299</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:22</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m1.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis</h5>
                                            <span class="adprice">$1099</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:21</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m7.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">On the other hand, we denounce with righteous dislike men</h5>
                                            <span class="adprice">$290</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:20</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m8.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$899</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:05</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m9.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">ducimus qui blanditiis praesentium voluptatum quos dolores et qua</h5>
                                            <span class="adprice">$199</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:04</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m10.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$250</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m11.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">who are so beguiled and demoralized by the charms of pleasure of the moment</h5>
                                            <span class="adprice">$189</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m12.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">you need to be sure there isn't anything embarrassing hidden</h5>
                                            <span class="adprice">$1090</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m1.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$290</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:55</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m2.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">It is a long established fact that a reader long established</h5>
                                            <span class="adprice">$310</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:45</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m3.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">Contrary to popular belief, Lorem Ipsum is not</h5>
                                            <span class="adprice">$190</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:30</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m4.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">The standard chunk of Lorem Ipsum used since the</h5>
                                            <span class="adprice">$480</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:25</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m5.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">Sed ut perspiciatis unde omnis iste natus error sit voluptatem</h5>
                                            <span class="adprice">$859</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:24</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m6.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">But I must explain to you how all this mistaken idea of denouncing</h5>
                                            <span class="adprice">$1299</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:22</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m1.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis</h5>
                                            <span class="adprice">$1099</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:21</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m7.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">On the other hand, we denounce with righteous dislike men</h5>
                                            <span class="adprice">$290</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:20</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m8.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$899</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:05</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m9.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">ducimus qui blanditiis praesentium voluptatum quos dolores et qua</h5>
                                            <span class="adprice">$199</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:04</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m10.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$250</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m11.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">who are so beguiled and demoralized by the charms of pleasure of the moment</h5>
                                            <span class="adprice">$189</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m12.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">you need to be sure there isn't anything embarrassing hidden</h5>
                                            <span class="adprice">$1090</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m13.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">looked up one of the more obscure Latin words</h5>
                                            <span class="adprice">$599</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:02</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                    <div class="clearfix"></div>
                                </a>
                            </ul>
                        </div>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
                    <div>
                        <div id="container">
                            <div class="view-controls-list" id="viewcontrols">
                                <label>view :</label>
                                <a class="gridview"><i class="glyphicon glyphicon-th"></i></a>
                                <a class="listview active"><i class="glyphicon glyphicon-th-list"></i></a>
                            </div>
                            <div class="sort">
                                <div class="sort-by">
                                    <label>Sort By : </label>
                                    <select>
                                        <option value="">Most recent</option>
                                        <option value="">Price: Rs Low to High</option>
                                        <option value="">Price: Rs High to Low</option>
                                    </select>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <ul class="list">
                                <a href="single.html">
                                    <li>
                                        <img src="images/m1.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$290</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:55</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m2.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">It is a long established fact that a reader long established</h5>
                                            <span class="adprice">$310</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:45</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m3.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">Contrary to popular belief, Lorem Ipsum is not</h5>
                                            <span class="adprice">$190</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:30</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m4.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">The standard chunk of Lorem Ipsum used since the</h5>
                                            <span class="adprice">$480</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:25</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m5.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">Sed ut perspiciatis unde omnis iste natus error sit voluptatem</h5>
                                            <span class="adprice">$859</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:24</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m6.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">But I must explain to you how all this mistaken idea of denouncing</h5>
                                            <span class="adprice">$1299</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:22</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m1.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis</h5>
                                            <span class="adprice">$1099</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:21</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m7.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">On the other hand, we denounce with righteous dislike men</h5>
                                            <span class="adprice">$290</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:20</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m8.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$899</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:05</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m9.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">ducimus qui blanditiis praesentium voluptatum quos dolores et qua</h5>
                                            <span class="adprice">$199</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:04</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m10.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$250</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m11.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">who are so beguiled and demoralized by the charms of pleasure of the moment</h5>
                                            <span class="adprice">$189</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m12.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">you need to be sure there isn't anything embarrassing hidden</h5>
                                            <span class="adprice">$1090</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m13.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">looked up one of the more obscure Latin words</h5>
                                            <span class="adprice">$599</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:02</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                    <div class="clearfix"></div>
                                </a>
                            </ul>
                        </div>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="samsa" aria-labelledby="samsa-tab">
                    <div>
                        <div id="container">
                            <div class="view-controls-list" id="viewcontrols">
                                <label>view :</label>
                                <a class="gridview"><i class="glyphicon glyphicon-th"></i></a>
                                <a class="listview active"><i class="glyphicon glyphicon-th-list"></i></a>
                            </div>
                            <div class="sort">
                                <div class="sort-by">
                                    <label>Sort By : </label>
                                    <select>
                                        <option value="">Most recent</option>
                                        <option value="">Price: Rs Low to High</option>
                                        <option value="">Price: Rs High to Low</option>
                                    </select>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <ul class="list">
                                <a href="single.html">
                                    <li>
                                        <img src="images/m1.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$290</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:55</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m2.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">It is a long established fact that a reader long established</h5>
                                            <span class="adprice">$310</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:45</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m3.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">Contrary to popular belief, Lorem Ipsum is not</h5>
                                            <span class="adprice">$190</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:30</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m4.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">The standard chunk of Lorem Ipsum used since the</h5>
                                            <span class="adprice">$480</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:25</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m5.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">Sed ut perspiciatis unde omnis iste natus error sit voluptatem</h5>
                                            <span class="adprice">$859</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:24</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m6.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">But I must explain to you how all this mistaken idea of denouncing</h5>
                                            <span class="adprice">$1299</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:22</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m12.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">you need to be sure there isn't anything embarrassing hidden</h5>
                                            <span class="adprice">$1090</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m1.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis</h5>
                                            <span class="adprice">$1099</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:21</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m7.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">On the other hand, we denounce with righteous dislike men</h5>
                                            <span class="adprice">$290</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:20</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m8.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$899</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:05</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m13.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">looked up one of the more obscure Latin words</h5>
                                            <span class="adprice">$599</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:02</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m9.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">ducimus qui blanditiis praesentium voluptatum quos dolores et qua</h5>
                                            <span class="adprice">$199</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:04</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m10.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$250</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m12.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">you need to be sure there isn't anything embarrassing hidden</h5>
                                            <span class="adprice">$1090</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m11.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">who are so beguiled and demoralized by the charms of pleasure of the moment</h5>
                                            <span class="adprice">$189</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>

                                <a href="single.html">
                                    <li>
                                        <img src="images/m4.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">The standard chunk of Lorem Ipsum used since the</h5>
                                            <span class="adprice">$480</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:25</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m9.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">ducimus qui blanditiis praesentium voluptatum quos dolores et qua</h5>
                                            <span class="adprice">$199</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:04</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m8.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">There are many variations of passages of Lorem Ipsum</h5>
                                            <span class="adprice">$899</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:05</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m12.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">you need to be sure there isn't anything embarrassing hidden</h5>
                                            <span class="adprice">$1090</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>

                                <a href="single.html">
                                    <li>
                                        <img src="images/m11.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">who are so beguiled and demoralized by the charms of pleasure of the moment</h5>
                                            <span class="adprice">$189</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:03</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                </a>
                                <a href="single.html">
                                    <li>
                                        <img src="images/m13.jpg" title="" alt="">
                                        <section class="list-left">
                                            <h5 class="title">looked up one of the more obscure Latin words</h5>
                                            <span class="adprice">$599</span>
                                            <p class="catpath">Mobile Phones » Brand</p>
                                        </section>
                                        <section class="list-right">
                                            <span class="date">Today, 17:02</span>
                                            <span class="cityname">City name</span>
                                        </section>
                                        <div class="clearfix"></div>
                                    </li>
                                    <div class="clearfix"></div>
                                </a>
                            </ul>
                        </div>
                    </div>
                </div>
                <ul class="pagination pagination-sm">
                    <li><a href="#">Prev</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">7</a></li>
                    <li><a href="#">8</a></li>
                    <li><a href="#">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
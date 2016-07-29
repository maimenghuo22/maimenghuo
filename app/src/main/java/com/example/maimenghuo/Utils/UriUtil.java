package com.example.maimenghuo.Utils;

/**
 * Created by lvcuili on 2016/7/26.
 */
public class UriUtil {
    //轮播
    public final static String headUri="http://api.maimenghuo.com/v2/banners";
    //签到换礼
    public final static String goodURi="http://api.maimenghuo.com/v2/secondary_banners";
//首页
public final static String homeURi="http://api.maimenghuo.com/v2/posts?limit=20&offset=0" ;



   //热门攻略
    public final static String HOT_DISCOVERY_URI="http://api.maimenghuo.com/v2/collections?limit=10&offset=0";
    //更多
    public final static String DISCOVERY_URI="http://api.maimenghuo.com/v2/collections?limit=20&offset=0";
    //热门攻略点进去
    public final static String INTODISCOVERY_URI="http://api.maimenghuo.com/v2/collections/%d/posts?limit=20&offset=0";


    //栏目专区及以下
    public final static String DISCOVERYITEM_URI="http://api.maimenghuo.com/v2/channel_groups/all";
    //栏目专区进入
    public final static String INTODISCOVERYITEM_URI=" http://api.maimenghuo.com/v2/channels/%d/items?limit=20&offset=0";
    //攻略详情
    public final static String DISCOVERY_DETAIL_URI="http://api.maimenghuo.com/v2/posts_v2/%d";
   // 评论
   public final static String DISCOVERY_COMMENT_URI="http://api.maimenghuo.com/v2/posts/%d/comments?limit=20&offset=0";

    //商品详情
    public final static String GOODS_DETAIL_URI="http://api.maimenghuo.com/v2/items_v2/%d";
    // 评论
    public final static String GOODS_COMMENT_URI="http://api.maimenghuo.com/v2/items/%d/comments?limit=20&offset=0";



    //商品
    public final static String GOODS_URI="http://api.maimenghuo.com/v2/item_categories/tree";
    //大图片点进去
    public final static String GOODS_ITEM_CATEGORIES_URI="http://api.maimenghuo.com/v2/item_categories/%d/items?limit=20&offset=0";
    //字点进去
    public final static String GOODS_ITEM_SUBCATEGORIES_URI="http://api.maimenghuo.com/v2/item_subcategories/%d/items?limit=20&offset=0";

}

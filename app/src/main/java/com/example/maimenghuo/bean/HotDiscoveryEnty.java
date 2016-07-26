package com.example.maimenghuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class HotDiscoveryEnty {

    /**
     * code : 200
     * data : {"collections":[{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160718/kss9jk9z6.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160718/dofi22fpy.jpg-w720","created_at":1468831783,"id":111,"posts_count":10,"status":0,"subtitle":"是一个包包不能解决的","title":"没有什么问题","updated_at":1468831783},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160712/0fn9b5ydp.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160712/glfy1obc6.jpg-w720","created_at":1468289254,"id":109,"posts_count":5,"status":0,"subtitle":"用了高颜值水杯就知道！","title":"喝水都是甜的？","updated_at":1468289254},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160708/49jioolf4.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160708/oe51pbmbc.jpg-w720","created_at":1467941928,"id":108,"posts_count":7,"status":0,"subtitle":"浪浪浪","title":"夏天，就要去海边","updated_at":1467941928},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160705/l886bmzru.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160705/u1tgdg4rd.jpg-w720","created_at":1467687136,"id":107,"posts_count":7,"status":0,"subtitle":"不嗑零食怎么行？","title":"暑期宅家看剧","updated_at":1467687136},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160630/rsoupn6fc.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160630/ipmfmes3n.jpg-w720","created_at":1467278788,"id":106,"posts_count":6,"status":0,"subtitle":"你在等什么？","title":"夏天不减肥，秋天肉成堆","updated_at":1467278788},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160624/2tonilil9.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160624/nn04jh28x.jpg-w720","created_at":1466734635,"id":105,"posts_count":6,"status":0,"subtitle":"致最好的我们","title":"青春不散场，友谊不毕业","updated_at":1466734635},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160621/fye3efkbn.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160621/ipa4k89i5.jpg-w720","created_at":1466474416,"id":104,"posts_count":9,"status":0,"subtitle":"拒绝\u201c热成狗\u201d","title":"夏日抗暑小秘诀","updated_at":1466474416},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160609/q6y8u80y5.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160609/zx73loaco.jpg-w720","created_at":1465453871,"id":101,"posts_count":6,"status":0,"subtitle":"讨巧搭配，闪耀一季","title":"配饰陪你过夏季","updated_at":1465453871},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160606/ql07qyn8g.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160606/sudfaxbaw.jpg-w720","created_at":1465196379,"id":100,"posts_count":5,"status":0,"subtitle":"穿衣指南看这里","title":"假期玩出潮","updated_at":1465196379},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160602/gg3tc6ln3.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160602/s5e9v5wwe.jpg-w720","created_at":1464846546,"id":99,"posts_count":7,"status":0,"subtitle":"高考文具助力","title":"高考的\u201c战斗品\u201d你都准备好了么","updated_at":1464846546}],"paging":{"next_url":"http://api.maimenghuo.com/v2/collections?limit=10&offset=10"}}
     * message : OK
     */

    private int code;
    /**
     * collections : [{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160718/kss9jk9z6.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160718/dofi22fpy.jpg-w720","created_at":1468831783,"id":111,"posts_count":10,"status":0,"subtitle":"是一个包包不能解决的","title":"没有什么问题","updated_at":1468831783},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160712/0fn9b5ydp.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160712/glfy1obc6.jpg-w720","created_at":1468289254,"id":109,"posts_count":5,"status":0,"subtitle":"用了高颜值水杯就知道！","title":"喝水都是甜的？","updated_at":1468289254},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160708/49jioolf4.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160708/oe51pbmbc.jpg-w720","created_at":1467941928,"id":108,"posts_count":7,"status":0,"subtitle":"浪浪浪","title":"夏天，就要去海边","updated_at":1467941928},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160705/l886bmzru.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160705/u1tgdg4rd.jpg-w720","created_at":1467687136,"id":107,"posts_count":7,"status":0,"subtitle":"不嗑零食怎么行？","title":"暑期宅家看剧","updated_at":1467687136},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160630/rsoupn6fc.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160630/ipmfmes3n.jpg-w720","created_at":1467278788,"id":106,"posts_count":6,"status":0,"subtitle":"你在等什么？","title":"夏天不减肥，秋天肉成堆","updated_at":1467278788},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160624/2tonilil9.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160624/nn04jh28x.jpg-w720","created_at":1466734635,"id":105,"posts_count":6,"status":0,"subtitle":"致最好的我们","title":"青春不散场，友谊不毕业","updated_at":1466734635},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160621/fye3efkbn.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160621/ipa4k89i5.jpg-w720","created_at":1466474416,"id":104,"posts_count":9,"status":0,"subtitle":"拒绝\u201c热成狗\u201d","title":"夏日抗暑小秘诀","updated_at":1466474416},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160609/q6y8u80y5.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160609/zx73loaco.jpg-w720","created_at":1465453871,"id":101,"posts_count":6,"status":0,"subtitle":"讨巧搭配，闪耀一季","title":"配饰陪你过夏季","updated_at":1465453871},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160606/ql07qyn8g.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160606/sudfaxbaw.jpg-w720","created_at":1465196379,"id":100,"posts_count":5,"status":0,"subtitle":"穿衣指南看这里","title":"假期玩出潮","updated_at":1465196379},{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160602/gg3tc6ln3.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160602/s5e9v5wwe.jpg-w720","created_at":1464846546,"id":99,"posts_count":7,"status":0,"subtitle":"高考文具助力","title":"高考的\u201c战斗品\u201d你都准备好了么","updated_at":1464846546}]
     * paging : {"next_url":"http://api.maimenghuo.com/v2/collections?limit=10&offset=10"}
     */

    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * next_url : http://api.maimenghuo.com/v2/collections?limit=10&offset=10
         */

        private PagingBean paging;
        /**
         * banner_image_url : http://7xkwn3.com1.z0.glb.clouddn.com/image/160718/kss9jk9z6.jpg-w300
         * cover_image_url : http://7xkwn3.com1.z0.glb.clouddn.com/image/160718/dofi22fpy.jpg-w720
         * created_at : 1468831783
         * id : 111
         * posts_count : 10
         * status : 0
         * subtitle : 是一个包包不能解决的
         * title : 没有什么问题
         * updated_at : 1468831783
         */

        private List<CollectionsBean> collections;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<CollectionsBean> getCollections() {
            return collections;
        }

        public void setCollections(List<CollectionsBean> collections) {
            this.collections = collections;
        }

        public static class PagingBean {
            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class CollectionsBean {
            private String banner_image_url;
            private String cover_image_url;
            private int created_at;
            private int id;
            private int posts_count;
            private int status;
            private String subtitle;
            private String title;
            private int updated_at;

            public String getBanner_image_url() {
                return banner_image_url;
            }

            public void setBanner_image_url(String banner_image_url) {
                this.banner_image_url = banner_image_url;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPosts_count() {
                return posts_count;
            }

            public void setPosts_count(int posts_count) {
                this.posts_count = posts_count;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}

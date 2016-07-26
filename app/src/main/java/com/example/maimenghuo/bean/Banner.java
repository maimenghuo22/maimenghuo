package com.example.maimenghuo.bean;

import java.util.List;

/**
 * Created by lvcuili on 2016/7/26.
 */
public class Banner {


    /**
     * code : 200
     * data : {"banners":[{"id":195,"image_url":"http://7xkwn3.com1.z0.glb.clouddn
     * .com/image/160722/rwlrekn7m.jpg-w720","order":209,"status":0,
     * "target":{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160530/bcsk11p3s
     * .jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160530/k8a0lz2k2
     * .jpg-w720","created_at":1445513081,"id":22,"posts_count":68,"status":1,"subtitle":"None",
     * "title":"萌兔酱FM","updated_at":1445513081},"target_id":22,"target_url":"",
     * "type":"collection"},{"id":194,"image_url":"http://7xkwn3.com1.z0.glb.clouddn
     * .com/image/160721/c6lb1z747.jpg-w720","order":208,"status":0,
     * "target":{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160721/5y3nb7ax0
     * .jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160721/d6nmpravg
     * .jpg-w720","created_at":1469067987,"id":112,"posts_count":4,"status":1,
     * "subtitle":"宅家吃冷饮才是正经事","title":"炎热的夏天里","updated_at":1469067987},"target_id":112,
     * "target_url":"","type":"collection"},{"id":193,"image_url":"http://7xkwn3.com1.z0.glb
     * .clouddn.com/image/160718/wx4kdj88o.jpg-w720","order":207,"status":0,
     * "target":{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160718/kss9jk9z6
     * .jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160718/dofi22fpy
     * .jpg-w720","created_at":1468831783,"id":111,"posts_count":10,"status":0,
     * "subtitle":"是一个包包不能解决的","title":"没有什么问题","updated_at":1468831783},"target_id":111,
     * "target_url":"","type":"collection"},{"id":190,"image_url":"http://7xkwn3.com1.z0.glb
     * .clouddn.com/image/160715/yqobeabj4.jpg-w720","order":204,"status":0,
     * "target":{"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160715/lzez9yv9y
     * .jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160715/iy12jvfz9
     * .jpg-w720","created_at":1468561261,"id":110,"posts_count":8,"status":1,
     * "subtitle":"不来一个嘛～","title":"换个手机壳，换种好心情","updated_at":1468561261},"target_id":110,
     * "target_url":"","type":"collection"}]}
     * message : OK
     */

    private int code;
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
         * id : 195
         * image_url : http://7xkwn3.com1.z0.glb.clouddn.com/image/160722/rwlrekn7m.jpg-w720
         * order : 209
         * status : 0
         * target : {"banner_image_url":"http://7xkwn3.com1.z0.glb.clouddn
         * .com/image/160530/bcsk11p3s.jpg-w300","cover_image_url":"http://7xkwn3.com1.z0.glb
         * .clouddn.com/image/160530/k8a0lz2k2.jpg-w720","created_at":1445513081,"id":22,
         * "posts_count":68,"status":1,"subtitle":"None","title":"萌兔酱FM","updated_at":1445513081}
         * target_id : 22
         * target_url :
         * type : collection
         */

        private List<BannersBean> banners;

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public static class BannersBean {
            private int id;
            private String image_url;
            private int order;
            private int status;
            /**
             * banner_image_url : http://7xkwn3.com1.z0.glb.clouddn.com/image/160530/bcsk11p3s
             * .jpg-w300
             * cover_image_url : http://7xkwn3.com1.z0.glb.clouddn.com/image/160530/k8a0lz2k2
             * .jpg-w720
             * created_at : 1445513081
             * id : 22
             * posts_count : 68
             * status : 1
             * subtitle : None
             * title : 萌兔酱FM
             * updated_at : 1445513081
             */

            private TargetBean target;
            private int target_id;
            private String target_url;
            private String type;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public TargetBean getTarget() {
                return target;
            }

            public void setTarget(TargetBean target) {
                this.target = target;
            }

            public int getTarget_id() {
                return target_id;
            }

            public void setTarget_id(int target_id) {
                this.target_id = target_id;
            }

            public String getTarget_url() {
                return target_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public static class TargetBean {
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
}

package com.example.maimenghuo.bean;

import java.util.List;

/**
 * Created by lvcuili on 2016/7/26.
 */
public class Banners {
    /**
     * code : 200
     * data : {"secondary_banners":[{"id":1,"image_url":"http://7xkwn3.com1.z0.glb.clouddn
     * .com/image/160606/ucrkti2ru.jpg-w720","order":20,
     * "raw_url":"maimenghuo:///page?type=url&login=true&url=http://www.maimenghuo
     * .com/credit/sign_v2&right_item_title=","target_id":null,"target_type":1,
     * "target_url":"maimenghuo:///page?type=url&login=true&url=http://www.maimenghuo
     * .com/credit/sign_v2&right_item_title=","title":""},{"id":2,"image_url":"http://7xkwn3.com1
     * .z0.glb.clouddn.com/image/160527/ev37fzm34.jpg-w720","order":19,"raw_url":"",
     * "target_id":77,"target_type":2,"target_url":"maimenghuo:///page?type=topic&topic_id=77",
     * "title":""},{"id":3,"image_url":"http://7xkwn3.com1.z0.glb.clouddn
     * .com/image/160527/oucfcml6a.jpg-w720","order":18,"raw_url":"","target_id":93,
     * "target_type":2,"target_url":"maimenghuo:///page?type=topic&topic_id=93","title":""},
     * {"id":4,"image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/hgapqpjih
     * .jpg-w720","order":17,"raw_url":"","target_id":15,"target_type":2,
     * "target_url":"maimenghuo:///page?type=topic&topic_id=15","title":""},{"id":5,
     * "image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/w8zxlmki5.jpg-w720",
     * "order":16,"raw_url":"","target_id":22,"target_type":2,
     * "target_url":"maimenghuo:///page?type=topic&topic_id=22","title":""},{"id":6,
     * "image_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/hzrw2k815.jpg-w720",
     * "order":15,"raw_url":"","target_id":94,"target_type":2,
     * "target_url":"maimenghuo:///page?type=topic&topic_id=94","title":""}]}
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
         * id : 1
         * image_url : http://7xkwn3.com1.z0.glb.clouddn.com/image/160606/ucrkti2ru.jpg-w720
         * order : 20
         * raw_url : maimenghuo:///page?type=url&login=true&url=http://www.maimenghuo
         * .com/credit/sign_v2&right_item_title=
         * target_id : null
         * target_type : 1
         * target_url : maimenghuo:///page?type=url&login=true&url=http://www.maimenghuo
         * .com/credit/sign_v2&right_item_title=
         * title :
         */

        private List<SecondaryBannersBean> secondary_banners;

        public List<SecondaryBannersBean> getSecondary_banners() {
            return secondary_banners;
        }

        public void setSecondary_banners(List<SecondaryBannersBean> secondary_banners) {
            this.secondary_banners = secondary_banners;
        }

        public static class SecondaryBannersBean {
            private int id;
            private String image_url;
            private int order;
            private String raw_url;
            private Object target_id;
            private int target_type;
            private String target_url;
            private String title;

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

            public String getRaw_url() {
                return raw_url;
            }

            public void setRaw_url(String raw_url) {
                this.raw_url = raw_url;
            }

            public Object getTarget_id() {
                return target_id;
            }

            public void setTarget_id(Object target_id) {
                this.target_id = target_id;
            }

            public int getTarget_type() {
                return target_type;
            }

            public void setTarget_type(int target_type) {
                this.target_type = target_type;
            }

            public String getTarget_url() {
                return target_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}

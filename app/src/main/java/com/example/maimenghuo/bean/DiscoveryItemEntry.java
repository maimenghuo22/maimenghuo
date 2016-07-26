package com.example.maimenghuo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class DiscoveryItemEntry {

    /**
     * code : 200
     * data : {"channel_groups":[{"channels":[{"group_id":5,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/qzn6niwpl.png-w640","id":46,"items_count":14,"name":"ACGN贩卖机","order":5,"status":0},{"group_id":5,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/hjjj9nv8u.png-w640","id":48,"items_count":29,"name":"三无少女进化论","order":4,"status":0},{"group_id":5,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/w5ekhvpgk.png-w640","id":49,"items_count":24,"name":"idol启示录","order":3,"status":0},{"group_id":5,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/ihkpoub17.png-w640","id":50,"items_count":14,"name":"魔法禁书目录","order":2,"status":0},{"group_id":5,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/xuz1pyr4g.png-w640","id":51,"items_count":13,"name":"沦为社畜更要浪","order":1,"status":0}],"id":5,"name":"栏目专区","order":3,"show_type":1,"status":0},{"channels":[{"group_id":6,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/bj391w6rw.png-w320","id":52,"items_count":256,"name":"绝对萌领域","order":7,"status":0},{"group_id":6,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/k1ay6mrkc.png-w320","id":53,"items_count":243,"name":"吃货俱乐部","order":6,"status":0},{"group_id":6,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/v60xosupi.png-w320","id":54,"items_count":331,"name":"潮流穿搭术","order":5,"status":0},{"group_id":6,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/p0kjitz81.png-w320","id":55,"items_count":215,"name":"美护大作战","order":4,"status":0},{"group_id":6,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/bduh4tvpr.png-w320","id":56,"items_count":105,"name":"上学那些事","order":3,"status":0},{"group_id":6,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/pyaakf4xv.png-w320","id":57,"items_count":181,"name":"疯狂改造家","order":2,"status":0},{"group_id":6,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/agqmbg0n4.png-w320","id":58,"items_count":229,"name":"奇葩BIBI","order":1,"status":0},{"group_id":6,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160530/jrwsoypr8.png-w320","id":59,"items_count":27,"name":"DIY小屋","order":0,"status":0}],"id":6,"name":"攻略标签","order":1,"show_type":2,"status":0}]}
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
         * channels : [{"group_id":5,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/qzn6niwpl.png-w640","id":46,"items_count":14,"name":"ACGN贩卖机","order":5,"status":0},{"group_id":5,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/hjjj9nv8u.png-w640","id":48,"items_count":29,"name":"三无少女进化论","order":4,"status":0},{"group_id":5,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/w5ekhvpgk.png-w640","id":49,"items_count":24,"name":"idol启示录","order":3,"status":0},{"group_id":5,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/ihkpoub17.png-w640","id":50,"items_count":14,"name":"魔法禁书目录","order":2,"status":0},{"group_id":5,"icon_url":"http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/xuz1pyr4g.png-w640","id":51,"items_count":13,"name":"沦为社畜更要浪","order":1,"status":0}]
         * id : 5
         * name : 栏目专区
         * order : 3
         * show_type : 1
         * status : 0
         */

        private List<ChannelGroupsBean> channel_groups;

        public List<ChannelGroupsBean> getChannel_groups() {
            return channel_groups;
        }

        public void setChannel_groups(List<ChannelGroupsBean> channel_groups) {
            this.channel_groups = channel_groups;
        }

        public static class ChannelGroupsBean {
            private int id;
            private String name;
            private int order;
            private int show_type;
            private int status;
            /**
             * group_id : 5
             * icon_url : http://7xkwn3.com1.z0.glb.clouddn.com/image/160527/qzn6niwpl.png-w640
             * id : 46
             * items_count : 14
             * name : ACGN贩卖机
             * order : 5
             * status : 0
             */

            private List<ChannelsBean> channels;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getShow_type() {
                return show_type;
            }

            public void setShow_type(int show_type) {
                this.show_type = show_type;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public List<ChannelsBean> getChannels() {
                return channels;
            }

            public void setChannels(List<ChannelsBean> channels) {
                this.channels = channels;
            }

            public static class ChannelsBean {
                private int group_id;
                private String icon_url;
                private int id;
                private int items_count;
                private String name;
                private int order;
                private int status;

                public int getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(int group_id) {
                    this.group_id = group_id;
                }

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getItems_count() {
                    return items_count;
                }

                public void setItems_count(int items_count) {
                    this.items_count = items_count;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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
            }
        }
    }
}

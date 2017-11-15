/**
 * Created by user on 2017/11/14.
 */
layui.config({
    base : "/SSM/static/js/"
}).use(['form','layer','jquery','layedit','laydate','tree','treeselect'],function(){
    var form = layui.form(),
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;
    treeselect = layui.treeselect;

    //创建一个编辑器
    var editIndex = layedit.build('links_content');
    var addLinksArray = [],addLinks;

    var tree = layui.tree({
        elem : '#tree-demo', //指定元素，生成的树放到哪个元素上
        check: 'checkbox', //勾选风格
        skin: 'as', //设定皮肤
        drag: true,//点击每一项时是否生成提示信息
        checkboxName: 'aa[]',//复选框的name属性值
        checkboxStyle: "",//设置复选框的样式，必须为字符串，css样式怎么写就怎么写
        click: function (item) { //点击节点回调
            console.log("item")
        },
        data: {//为元素添加额外数据，即在元素上添加data-xxx="yyy"，可选
            hasChild: true
        },
        nodes: [ //节点
            {
                name: '常用文件夹', //节点名称
                //	spread: true, //是否是展开状态，true为展开状态
                href: "http://www.baidu.com",//设置节点跳转的链接，如果不设置则不会跳转
                target: "_self",//节点链接打开方式
                alias: 'changyong',
                data: {
                    nodeName: "常用文件夹",
                    alias: "changyong"
                },
                checkboxValue: 1,//复选框的值
                checked: true,//复选框默认是否选中
                children: [{
                    name: '所有未读',
                    alias: 'weidu',
                    checked: true,
                    checkboxValue: 2
                }, {
                    name: '置顶邮件',
                }, {
                    name: '标签邮件',
                    checked: false,
                    checkboxValue: 3
                }]
            }, {
                name: '我的邮箱',
                checked: true,
                spread: true,
                data: {
                    nodeName: "我的邮箱",
                    alias: "email"
                },
                children: [{
                    name: 'QQ邮箱',
                    checked: true,
                    checkboxValue: 4,
                    spread: true,
                    children: [{
                        name: '收件箱',
                        checked: false,
                        checkboxValue: 5,
                        children: [{
                            name: '所有未读',
                            checked: false,
                            checkboxValue: 6,
                            children: [{
                                name: '一周未读',
                                checked: false,
                                checkboxValue: 6
                            }]
                        }, {
                            name: '置顶邮件',
                            checked: false,
                            checkboxValue: 7
                        }, {
                            name: '标签邮件',
                            checked: false,
                            checkboxValue: 8
                        }]
                    }, {
                        name: '已发出的邮件',
                        checked: false,
                        checkboxValue: 9
                    }, {
                        name: '垃圾邮件',
                        checked: false,
                        checkboxValue: 10
                    }]
                }, {
                    name: '阿里云邮',
                    checked: true,
                    checkboxValue: 11,
                    children: [{
                        name: '收件箱',
                        checked: true,
                        checkboxValue: 12
                    }, {
                        name: '已发出的邮件',
                        checked: true,
                        checkboxValue: 13
                    }, {
                        name: '垃圾邮件',
                        checked: true,
                        checkboxValue: 14
                    }]
                }]
            }
        ]
    });



    function GetQueryString(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }
    form.on("submit(addLinks)",function(data){


        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        //var index = layer.load(1);
        $.ajax({
            contentType: "application/json",
            type: 'post',
            async: false,
            url: '/SSM/menu/addSysMenu',
            dataType:"json",
            data: JSON.stringify(data.field),
            success: function (outResult) {
                top.layer.close(index);
                console.log(outResult.result);
                console.log(outResult.msg);
                if (outResult.result) {
                    top.layer.msg(outResult.msg, { icon: 6 });
                    parent.location.reload();//location.reload(true);
                } else {
                    if (outResult.msg != undefined) {
                        top.layer.msg(outResult.msg, { icon: 5 });
                    } else {
                        top.layer.msg('程序异常', { icon: 5 });
                    }
                }
            },
            error: function (outResult) {
                layer.close(index);
                layer.msg("请求异常", { icon: 2 });
            }
        });

//        setTimeout(function(){
//            top.layer.close(index);
//			top.layer.msg("文章添加成功！");
// 			layer.closeAll("iframe");
//	 		//刷新父页面
//	 		parent.location.reload();
//        },2000);
        return false;
    })

})

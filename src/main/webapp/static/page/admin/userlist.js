/**
 * Created by user on 2017/11/16.
 */
layui.config({
    base : "/static/js/"
}).use(['form','layer','jquery','laypage'],function(){
    var form = layui.form(),
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        $ = layui.jquery;




    $(".userAdd_btn").click(function(){
        var self=$(this);
        var uid=self.attr("data-uid");
        var url="",title="";
        if(uid!=undefined)
        {
            url=ctx+"admin/addUser?id="+uid;
            title="修改用户";
        }
        else
        {
            url=ctx+"admin/addUser";
            title="添加用户";
        }
        var index = layui.layer.open({
            title : title,
            type : 2,
            content : url,
            success : function(layero, index){
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
        $(window).resize(function(){
            layui.layer.full(index);
        })
        layui.layer.full(index)
    })

    $(".setAdminRole_btn").click(function(){
        var self=$(this);
        var uid=self.attr("data-uid");
        var url="",title="";
        if(uid!=undefined)
        {
            url=ctx+"userRole/setUserRole?uid="+uid;
            title="设置权限";
        }

        var index = layui.layer.open({
            title : title,
            type : 2,
            content : url,
            success : function(layero, index){
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
        $(window).resize(function(){
            layui.layer.full(index);
        })
        layui.layer.full(index);
    })

    laypage({
        cont: 'page'
        ,pages: total
        ,curr: currPage
        ,jump: function(obj, first){

            if(!first){
                $("#currpage").val(obj.curr);
                // $("#myform").attr("action",ctx+"menu/menulist#!fenye="+obj.curr);
                myform();
            }
        }
    });
    function myform(){
        var keywords=$("#search_input").val();
        $("input[name='keyWords']").val(keywords);
        $("#myform").submit();
    }
    $(".search_btn").click(function (){
        myform();
    })


})


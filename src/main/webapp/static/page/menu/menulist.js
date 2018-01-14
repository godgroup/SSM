/**
 * Created by Administrator on 2017/11/30.
 */
layui.config({
    base : ctx+"static/js/"
}).use(['form','layer','jquery','laypage'],function(){
    var form = layui.form(),
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        $ = layui.jquery;

    $(".menuAdd_btn").click(function(){
        var self=$(this);
        var id=self.attr("data-id");
        var url="",title="";
        if(id!=undefined)
        {
            url=ctx+"menu/addMenu?id="+id;
            title="修改菜单";
        }
        else
        {
            url="addMenu";
            title="添加菜单";
        }
        var index = layui.layer.open({
            title : title,
            type : 2,
            content : url,
            success : function(layero, index){
                setTimeout(function(){
                    layui.layer.tips('点击此处返回友链列表', '.layui-layer-setwin .layui-layer-close', {
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
        ,curr: currPage //获取hash值为fenye的当前页
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
    $("body").on("click",".menu_del",function(){  //删除
        var _this = $(this);

        layer.confirm('确定禁用此菜单吗？',{icon:3, title:'提示信息'},function(index){
            $.ajax({
                type: 'post',
                url: ctx+'menu/addSysMenu',
                dataType:"json",
                data:$("form").serialize(),
                success: function (outResult) {
                    top.layer.close(index);

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
            layer.close(index);
        });
    })

})

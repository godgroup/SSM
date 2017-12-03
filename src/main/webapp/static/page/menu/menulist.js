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
    $("body").on("click",".links_del",function(){  //删除
        var _this = $(this);
        layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
            //_this.parents("tr").remove();
            for(var i=0;i<linksData.length;i++){
                if(linksData[i].linksId == _this.attr("data-id")){
                    linksData.splice(i,1);
                    linksList(linksData);
                }
            }
            layer.close(index);
        });
    })

})

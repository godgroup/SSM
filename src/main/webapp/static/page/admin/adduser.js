/**
 * Created by Administrator on 2017/12/4.
 */

/**
 * Created by Administrator on 2017/11/30.
 */
layui.config({
    base : ctx+"static/js/"
}).use(['form','layer','jquery','layedit','laydate','tree','treeselect'],function(){
    var form = layui.form(),
        layer = parent.layer === undefined ? layui.layer : parent.layer,

        $ = layui.jquery;

    $("input").attr("autocomplete","off");
    var addLinksArray = [],addLinks;





    form.on("submit(addLinks)",function(data){


        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        //var index = layer.load(1);
        $.ajax({
            //contentType: "application/json",
            type: 'post',
            async: false,
            url: ctx+'admin/addAdminUser',
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

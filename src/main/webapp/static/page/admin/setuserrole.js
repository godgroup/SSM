/**
 * Created by Administrator on 2017/11/19.
 */
/**
 * Created by user on 2017/11/16.
 */
/**
 * Created by user on 2017/11/14.
 */
layui.config({
    base : "/static/js/"
}).use(['layer','form','jquery'],function(){
    var layer = parent.layer === undefined ? layui.layer : parent.layer,

        $ = layui.jquery;
 $(".setuserrole_btn").click(function(){

        var uid=$('input[name="uid"]').val();
        var roles = "";
        $('input[name="roles"]:checked').each(function() {
            if ( roles == "")
                roles = $(this).val();
            else
                roles = roles + "," + $(this).val();
        });

        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax({
            //contentType: "application/json",
            type: 'post',
            url: '/userRole/doSetUserRole',
            dataType:"json",
            data: {"uid":uid,"roles":roles},
            success: function (outResult) {
                top.layer.close(index);
                console.log(outResult.result);
                console.log(outResult.msg);
                if (outResult.result) {
                    top.layer.msg(outResult.msg, { icon: 6 });
                    parent.location.reload();
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
        })
    })
})

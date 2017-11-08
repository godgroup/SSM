layui.config({
	base : "/SSM/static/js/"
}).use(['form','layer','jquery','layedit','laydate','tree','treeselect'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;
	  
	//创建一个编辑器
 	var editIndex = layedit.build('links_content');
 	var addLinksArray = [],addLinks;
 	layui.treeselect(
            {
            	//[{"children":[{"id":2,"name":"用户列表","spread":false}],"id":1,"name":"用户管理","spread":false} ],
            	// [{ //节点
//	                    name: '父节点1'
//	                    ,children: [{
//	                      name: '子节点11'
//	                    },{
//	                      name: '子节点12'
//	                    }]
//	                  }],
                elem: "#treeselecttest11",
                data: "/SSM/menu/getNodes",
  	            method: "GET"
            });
 	
 	form.on("submit(addLinks)",function(data){
 		 //弹出loading
 		 var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
 		 //var index = layer.load(1);
         $.ajax({
             contentType: "application/json",
             type: 'post',
             async: false,
             url: '/SSM/menu/addSysMenu',
             data: JSON.stringify(data.field),
             success: function (outResult) {
                 layer.close(index);
                 if (outResult.result=="ok") {
                     layer.msg(outResult.Message, { icon: 6 });
                     location.reload(true);
                 } else {
                     if (outResult.Message != undefined) {
                         layer.msg(outResult.Message, { icon: 5 });
                     } else {
                         layer.msg('程序异常，请重试或联系作者', { icon: 5 });
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

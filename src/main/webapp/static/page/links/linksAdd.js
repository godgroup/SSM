layui.config({
	base : "/static/js/"
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
 	var url="/menu/getNodes";
 	var parm=GetQueryString("id");
 	if(parm!=null)
 	{
 		url+="?id="+parm;
 	}
 	treeselect.render(
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
                data:url ,
  	            method: "GET",
  	           
            });
 	//全部treeselect
 	//treeselect.render();
 	//支持filter筛选
 	
	//treeselect.render({filter:'demo'});
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
             //contentType: "application/json",
             type: 'post',
             async: false,
             url: '/menu/addSysMenu',
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

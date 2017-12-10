<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getRequestURI();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="../css/bootstrap-editable.css" rel="stylesheet" />
<link href="../css/bootstrap-table.min.css" rel="stylesheet">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-table.min.js"></script>
<script src="../js/bootstrap-editable.min.js"></script>
<title>查询结果</title>
</head>
<body>
<table id="table"></table>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					详情
				</h4>
			</div>
			<div class="modal-body">
				<table class="table table-striped">
  <thead>
    <tr>
      <th>名称</th>
      <th>详情</th>
    </tr>
  </thead>
  <tbody>
    <tr>   
     <td>图书编号</td>
     <td id="1"></td>         
    </tr> 
     <tr>   
     <td>图书名</td>
     <td id="2"></td>            
    </tr> 
    <tr>   
     <td>作者</td>
     <td id="3"></td>         
    </tr>   
    <tr>   
     <td>出版社</td>
     <td id="4"></td>          
    </tr>   
    <tr>   
     <td>价钱</td>
     <td id="5"></td>           
    </tr>       
    <tr>   
     <td>类别</td>
     <td id="6"></td>            
    </tr> 
     <tr>
    <td>入库日期</td>
    <td id="10"></td>       
    </tr> 
    <tr>   
     <td>入库</td>
     <td id="7"></td>           
    </tr> 
    <tr>   
     <td>丢失</td>
     <td id="8"></td>            
    </tr> 
    <tr>   
     <td>借出</td>
    <td id="9"></td>       
    </tr> 
   
      
  </tbody>
</table> 
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<script type="text/javascript">

$(function () {
    var obj = [];//创建一个数组对象
    $.ajax({
        url : "../bookjson.action",
        type : "post",
        dataType : "json",//这里必须是json，不然没法拿到返回来的值
        success : function(value) {
            $.each(value.rows, function(i, d) {
                obj.push(d);
                // alert(obj.coursename);
            });
            initTable(obj);//等把所有数据存到obj之后，调用bootstrap table的方法
        },
        error:function(){
            alert("执行错误！");
        }
    });
});
$(function () {
	$("#table")
	.on('dbl-click-row.bs.table', function (e, row, ele,field) {
	        	 var params = {
	         	          bookid : row.bookid
	        	        };
	        	 $.ajax({
	        		    type: "POST",
	        		    url: "../bookxq.action",
	        		    data: params,
	        		    dataType:"text",
	        		    success: function(json){  
	        		    	 var obj = $.parseJSON(json);
	        	        	 var book = obj.everybook;
	        	        	 $("#1").text(book.bookid);
	        	        	 $("#2").text(book.name);
	        	        	 $("#3").text(book.author);
	        	        	 $("#4").text(book.publish);
	        	        	 $("#6").text(book.cat);
	        	        	 $("#5").text(book.price);
	        	        	 $("#7").text(book.numin);
	        	        	 $("#9").text(book.numout);
	        	        	 $("#8").text(book.numloss);
	        	        	 $("#10").text(book.dateii);
	        		    },
	        		    error:function(){
	        	            alert("执行错误！");
	        	        }
	        	 });
	        	 
	        	 $('#myModal').modal('show')
            });
});
function initTable(obj){
    $table = $('#table').bootstrapTable({
        data : obj, //最终的JSON数据放在这里  
        toolbar : '#toolbar',
        striped : true,
        pagination : true,
        pageNumber : 1,//初始化分页数
        pageSize : 10,//页面显示条数
        pageList : [ 5, 10, 20 ],
        search : true,//启用搜索输入。
        searchAlign : 'right',//指示如何对齐搜索输入。左'，'右'可以使用。
        //showRefresh: true,  //显示“刷新”按钮。
        //showExport : true, //是否显示导出

        exportDataType : "selected", //basic', 'all', 'selected'.

        sidePagination : "client",//定义表格边分页，只能“client”或“server”。使用“server”需要设置“URL”或“Ajax”选项。

        editable : true,

        showColumns : true,
        //clickToSelect : true,//true选择复选框或RadioBOX点击排。
        showToggle : false, //是否显示详细视图和列表视图的切换按钮
        cardView : false, //是否显示详细视图
        detailView : false,//显示详细视图表。

        minimunCountColumns : 2,

        rowStyle : function(row, index) {
            //这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
            var strclass = "";
            if (row.ORDER_STATUS == "待排查") {
                strclass = 'success';//还有一个active
            } else if (row.ORDER_STATUS == "已删除") {
                strclass = 'danger';
            } else {
                return {};
            }
            return {
                classes : strclass
            }
        },
     
        columns : [
              
                {

                    field : 'name', 

                    title : '图书名',

                },{
                    field : 'bookid',
                    title : '图书编号',
                 
                }, {

                    field : 'author',

                    title : '作者',

                }, {

                    field : 'publish',

                    title : '出版社',

                }, {

                    field : 'price',

                    title : '价格',

                } ]

    });
    }

</script>
</body>
</html>
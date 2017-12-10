<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getRequestURI();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="../css/bootstrap-editable.css" rel="stylesheet" />
<link href="../css/bootstrap-table.min.css" rel="stylesheet">
<link href="../css/toastr.min.css" rel="stylesheet">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-table.min.js"></script>
<script src="../js/bootstrap-editable.min.js"></script>
<script src="../js/toastr.min.js"></script>
<title>读者管理</title>
</head>
<body>
 <%@ include file="manageheader.jsp"%>
<table id="table"></table>
 <div id="toolbar" class="btn-group">
            <button id="btn_add" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
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
     <td>读者编号</td>
     <td><input type="text" class="form-control" id="1"></td>         
    </tr> 
     <tr>   
     <td>姓名</td>
     <td><input type="text" class="form-control" id="2"></td>           
    </tr> 
    <tr>   
     <td>性别</td>
     <td><input type="text" class="form-control" id="3"></td> 
    </tr>  
    <tr>
    <td>生日</td>
    <td><input type="date" class="form-control" id="10" /></td>       
    </tr>  
    <tr>   
     <td>移动电话</td> 
    <td><input type="text" class="form-control" id="4"></td> 
    </tr>   
    <tr>   
     <td>邮箱</td>
     <td><input type="text" class="form-control" id="5"></td>   
    </tr>       
    <tr>   
     <td>等级</td>
     <td><input type="text" class="form-control" id="6"></td>   
    </tr> 
    <tr>   
     <td>一卡通号码</td>
   <td><input type="text" class="form-control" id="7"></td>    
    </tr> 
     <tr>
    <td>办证日期</td>
    <td><input type="date" class="form-control" id="8" /></td>       
    </tr> 
  </tbody>
</table> 
</div>
<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" id='btn_submit'>提交</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<script type="text/javascript">
//曾删改
//曾删改
//曾删改
//曾删改

$(function () {
    var obj = [];//创建一个数组对象
    $.ajax({
        url : "../allreaderjson.action",
        type : "post",
        dataType : "json",//这里必须是json，不然没法拿到返回来的值
        success : function(value) {
            $.each(value.rows, function(i, d) {
                obj.push(d);
                // alert(obj.coursename);
            });
            initTable(obj);//等把所有数据存到obj之后，调用bootstrap table的方法
            var oButtonInit = new ButtonInit();
            oButtonInit.Init();
        },
        error:function(){
            toastr.error("执行错误！");
        }
    });
});
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        $("#btn_add").click(function () {
            $("#myModalLabel").text("新增");
            $("#myModal").find(".form-control").val("");
            $('#myModal').modal()

           
        });

        $("#btn_edit").click(function () {
           var arrselections = $("#table").bootstrapTable('getSelections');
           if (arrselections.length > 1) {
               toastr.warning('只能选择一行进行编辑');

               return;
           }
           if (arrselections.length <= 0) {
        	   toastr.warning('请选择有效数据');

               return;
           }
           $("#myModalLabel").text("编辑");
           console.info(arrselections[0].name);  
           $("#1").val(arrselections[0].readerid);
           $("#2").val(arrselections[0].name);
           $("#3").val(arrselections[0].sex);
           $("#4").val(arrselections[0].phone);
           $("#5").val(arrselections[0].email);
           $("#6").val(arrselections[0].level);
           $("#7").val(arrselections[0].cardid);
           $("#8").val(arrselections[0].dayii);
           $("#10").val(arrselections[0].birthii);
           $('#myModal').modal();
        });
        

        $("#btn_delete").click(function () {
           var arrselections = $("#table").bootstrapTable('getSelections');
           if (arrselections.length <= 0) {
        	   toastr.warning('请选择有效数据');
               return;
           }
           if (arrselections.length > 1) {
               toastr.warning('每次只能选择一行');

               return;
           }

          
               var ttttt=confirm("确认要删除选择的数据吗？");
               console.log(ttttt);
               if(ttttt==false)
            	   {
            	   return;
            	   }
               else if(ttttt==true)
            	   {
            	   var params = {
              			
              	       readerid:arrselections[0].readerid
             	        };
            	   $.ajax({
                       type: "post",
                       url: "../deletereader.action",
                       data: params,
           		       dataType:"text",
                       success: function (data, status) {
                           if (status == "success") {
                        	   toastr.success('提交数据成功');
                               $("#table").bootstrapTable('refresh');
                           }
                       },
                       error: function () {
                    	   toastr.error('Error');
                       },
                       complete: function () {

                       }

                   });
            	   }
              
           
        });
        $("#btn_submit").click(function () {
        	 var params = {
        			 name:$("#2").val(),
        	         readerid:$("#1").val(),
        	         sex:$("#3").val(),
        	         phone:$("#4").val(),
        	         email:$("#5").val(),
        	         level:$("#6").val(),
        	         cardid:$("#7").val(),
        	         day:$("#8").val(),
        	 
        	         birth:$("#10").val()
       	        };
        	 var uurl="../addreader.action";
        	 if($("#myModalLabel").text()=="编辑")
        		 {
        		 uurl="../updatereader.action"
        		 }
           $.ajax({
               type: "post",
               url: uurl,
               data: params,
   		       dataType:"text",
               success: function (data, status) {
                   if (status == "success") {
                       toastr.success('提交数据成功');
                       $("#table").bootstrapTable('refresh');
                   }
               },
               error: function () {
                   toastr.error('Error');
               },
               complete: function () {

               }

           });
        });

    };

    return oInit;
};
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
                    checkbox : true
                },
                {

                    field : 'readerid', 

                    title : '读者编号',

                },{
                    field : 'name',
                    title : '姓名',
                 
                }, {

                    field : 'sex',

                    title : '性别',

                }, {

                    field : 'phone',

                    title : '移动电话',

                }, {

                    field : 'email',

                    title : '邮箱',

                } ]

    });
    }
</script>
</body>
</html>
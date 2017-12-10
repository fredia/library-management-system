 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<title>个人画像</title>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/echarts.min.js"></script>
<script type="text/javascript">
   $(function() {
     $("#tj").click(function() {

    //提交的参数，name和inch是和struts action中对应的接收变量
        var params = {
          
           begin : $("#rq").val()
        };
        $.ajax({
    type: "POST",
    url: "../jsonAjax.action",
    data: params,
    dataType:"text", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
    success: function(json){  
    var obj = $.parseJSON(json);  //使用这个方法解析json
                var state_value = obj.result;  //result是和action中定义的result变量的get方法对应的
    var map=obj.map;
    var keys = new Array();
    for ( var p in map) {
        keys.push(p);
    }
    var valuesArray = new Array();
    for (var i = 0; i < keys.length; i++) {
        valuesArray.push(map[keys[i]]);
    }
   // alert(state_value);
   var myChart1 = echarts.init(document.getElementById('zhuzhuang'));
   var myChart2 = echarts.init(document.getElementById('bar'));
   var myChart3 = echarts.init(document.getElementById('zhexian'));
   var arr=obj.arr;
    // 指定图表的配置项和数据
    var option1 = {
        title: {
            text: '各类书籍阅读情况'
        },
        tooltip: {},
        legend: {
            data:['数量']
        },
        xAxis: {
            data: ["计算机技术","自然科学","医学","农林","建筑","科普","通信","化学","物理","美文"]
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'bar',
            data: [arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[9]]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option1);
   
    var option2 = {
    	    title : {
    	        text: '各类书籍阅读情况',
    	        x:'center'
    	    },
    	    tooltip : {
    	    },
    	    legend: {
    	        orient : 'vertical',
    	        x : 'left',
    	        data:["计算机技术","自然科学","医学","农林","建筑","科普","通信","化学","物理","美文"]
    	    },
    	    toolbox: {
    	        show : true,
    	        feature : {
    	            mark : {show: true},
    	            dataView : {show: true, readOnly: false},
    	            magicType : {
    	                show: true, 
    	                type: ['pie', 'funnel'],
    	                option: {
    	                    funnel: {
    	                        x: '25%',
    	                        width: '50%',
    	                        funnelAlign: 'left',
    	                        max: 100
    	                    }
    	                }
    	            },
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    calculable : true,
    	    series : [
    	        {
    	            name:'类别',
    	            type:'pie',
    	            radius : '55%',
    	            center: ['50%', '60%'],
    	            data:[
    	                {value:arr[0], name:'计算机技术'},
    	                {value:arr[1], name:'自然科学'},
    	                {value:arr[2], name:'医学'},
    	                {value:arr[3], name:'农林'},
    	                {value:arr[4], name:'建筑'},
    	                {value:arr[5], name:'科普'},
    	                {value:arr[6], name:'通信'},
    	                {value:arr[7], name:'化学'},
    	                {value:arr[8], name:'物理'},
    	                {value:arr[9], name:'美文'}
    	                
    	            ]
    	        }
    	    ]
    	};
       myChart2.setOption(option2);
       
       var option3 = {
    		    title : {
    		        text: '最近借书情况',
    		    },
    		    tooltip : {
    		        trigger: 'axis'
    		    },
    		    legend: {
    		        data:['借阅数量']
    		    },
    		    toolbox: {
    		        show : true,
    		        feature : {
    		            mark : {show: true},
    		            dataView : {show: true, readOnly: false},
    		            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
    		            restore : {show: true},
    		            saveAsImage : {show: true}
    		        }
    		    },
    		    calculable : true,
    		    xAxis : [
    		        {
    		            type : 'category',
    		            boundaryGap : false,
    		            data : keys
    		        }
    		    ],
    		    yAxis : [
    		        {
    		            type : 'value'
    		        }
    		    ],
    		    series : [
    		        {
    		            name:'借阅数量',
    		            type:'line',
    		            smooth:true,
    		            itemStyle: {normal: {areaStyle: {type: 'default'}}},
    		            data:valuesArray
    		        }
    		       
    		    ]
    		};
       myChart3.setOption(option3);
    },
    error: function(json){
     alert("json=" + json);
     return false;
    }
    });
     });
   });
</script>
</head>
<body>
<%@ include file="readerheader.jsp"%>
  <span>选择开始日期：</span><input type="date" id="rq"/> 
  <input type="button" value="提交" id="tj">
   <div id="zhexian" style="width: 1000px;height:400px;"></div>
  <div id="zhuzhuang" style="width: 1000px;height:400px;"></div>
  <div id="bar" style="width: 1000px;height:400px;"></div>
 
  
</body>
</html> 
  /*
  使用ajax加载数据字典，生成select
  参数一：数据字典类型（dict_type_code）
  参数二：下拉选放入的标签的id
  参数三：生成的下拉选的select的name属性
  参数四：需要回显时，选中的哪个option
  */
  function loadSelect(typecode,positionId,selectname,selectedId){
	  alert(typecode);
	  alert(positionId);
	  //1.创建select对象，将name属性指定
	  var $select = $("<select name ="+selectname+" ></select>");
	  alert($select);
	  //2.创建提示选项
	  $select.append($("<option value=''>----请选择----</option>"));
	  //3.使用ajax访问后台 ,得到数据，添加option
	  //参数说明：第一个参数：发送的url地址，第二个，参数列表，第三个，返回的参数处理函数，第四个返回数据的格式
	  $.post("${pageContext.request.contextPath }/BaseDictAction",{dict_type_code:typecode},
	  		//data为此次ajax请求得到的数据
	  		function(data){
		  		alert(data);
	  			//遍历
	  				//对得到的data，进行遍历，遍历的下标为i，每次遍历得到的内容为json
	  			$.each(data,function(i,json){
	  				//添加下拉选项
	  				var  $option = $("<option value="+json['dict_id']+"> " +json['dict_item_name']+ " </option>");
	  				alert($option);
	  				//如果被选择（用于回显）
	  				if(json['dict_id'] == selectedId){
	  					$option.attr("selected","selected");
	  				}
	  				//添加下拉项
	  				 $select.append($option);
	  			});
	  		}
	  ,"json");
	  //组装好的select添加页面指定位置
	  $("#"+positionId).append($select);
  }
  /*
   * 其他文件使用方式
 	$(document).ready(function(){
	loadSelect("001","level","hhhh","666666");
	});
   * */

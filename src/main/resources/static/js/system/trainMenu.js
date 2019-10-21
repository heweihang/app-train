var array=new Array();

var config={
    "pageNo" :1,
}

$(function(){
//	initDatePicker();
    initPayeeRepairList(1);
});
/**
 * 初始化日历控件
 */
//function initDatePicker(){
//    $('.form_datetime').datetimepicker({
//        needDay:true,
//        changeMonth: true, //显示月份
//        changeYear: true, //显示年份
//        showButtonPanel: true, //显示按钮
//        timeFormat: "HH:mm:ss",
//        dateFormat: "yy-mm-dd"
//    });
//
//}
/**
 * @param page
 */
function initPayeeRepairList(page){
    var queryJson={};
    queryJson.pageNo=page;
    queryJson.pageSize=10;
    queryJson.factoryName=changeCha($("#factoryName").val());
    $.ajax({
        type: 'post',
        url: base+"/user/trainMenu",
        data: {
            "json":JSON.stringify(queryJson)
        },
        async:true,
        dataType:'json',
        success: function(PageData){
            var pages =  Math.ceil(parseFloat(PageData.count)/parseFloat(queryJson.pageSize));
            var pageNum = page;
            var pageSize = queryJson.pageSize;
            var totalRows = PageData.count;
            $("#count").html(totalRows);
            $("#pageSize").html(pageSize);
            config.pageNo=pageNum;
            $("#listpage")
                .bs_pagination({
                    currentPage : pageNum,
                    totalPages : pages,
                    totalRows : totalRows,
                    visiblePageLinks : 5,
                    rowsPerPage : pageSize,
                    showGoToPage : false,
                    showRowsPerPage : false,
                    showRowsInfo : false,
                    showRowsDefaultInfo : false,
                    navListContainerClass : "col-xs-12 col-sm-12 col-md-12",//使分页按钮区域占一整行
                    containerClass : "",//包含按钮的class为空，原为well，有背景
                    onLoad : function(event, data) {//分页按钮加载时
                        showPageList(PageData);
                    },
                    onChangePage : function(event, data) {//分页按钮改变时
                        initPayeeRepairList(data.currentPage);
                    }
                });
        },
        error:function(){
            alert("请求失败");
        }
    });
}

function changeCha(value){
    var reg = new RegExp("（","g");//g,表示全部替换
    if (value.indexOf("（") !=-1){
        value =value.replace(reg,"(");
    }
    var reg = new RegExp("）","g");//g,表示全部替换
    if (value.indexOf("）") !=-1){
        value = value.replace(reg,")");
    }
    return value;
}

/**
 * 页面数据js加载
 * @param pageData
 */
function showPageList(pageData){
    $("#goodsBody").empty();
    var tableHtml="";
    for(var re in pageData.list){
        tableHtml+="<tr>"
            +"<td>";
//     if(array.join().indexOf(pageData.list[re].sid)==-1){
        tableHtml+="<input id='' type='checkbox' value="+pageData.list[re].id+" class='input-mini' />";
//     }else{
//    	 tableHtml+="<input id='' type='checkbox' value="+pageData.list[re].sid+" class='input-mini' checked='checked' />";
//     }
        tableHtml+="</td>"
            +"<td>"+tarnsUndefine(pageData.list[re].factoryName)+"</a></td>"
            +"<td>"+tarnsUndefine(pageData.list[re].creator)+"</td>"
            +"<td><a href='"+base+"/system/config/payeeRepairEditPage?id="+pageData.list[re].id+"'>修改</a></td>"
            +"</tr>"
    }
    $("#goodsBody").prepend(tableHtml);
    $("#goodsBody").find("input[type=checkbox]").bind("click",eachclick);
}


/**
 * 全选事件
 */
//$("#allCheck").click(function(){
//	$("#goodsBody").find("input[type=checkbox]").each(function(){
//		var val=$(this).val();
//		if($('#allCheck').is(':checked')){
//			if(array.length ==0
//					||array.join().indexOf(val)==-1){
//				array.push(val);
//			}
//			$(this).prop("checked",true);
//		}else{
//			array = jQuery.grep(array, function(value) {
//				return value != val;
//			});
//			$(this).prop("checked",false);
//		}
//	});
//});


$("#repairAdd").click(function(){
    window.location.href=base+"/system/config/payeeRepairAddPage";
});


$("#repairEdit").click(function(){
    if(array.length==1){
        window.location.href=base+"/system/config/payeeRepairEditPage?id="+array[0];
    }else{
        alert("请选择一个领款人维修厂进行编辑");
    }
});

$("#repairDelete").click(function(){
    if(array.length==1){
        if(confirm("确定删除？")){
            var queryJson={};
            queryJson.id=array[0];
            $.ajax({
                type: 'post',
                url: base+"/system/config/delPayeeRepairInfo",
                data:{
                    "json":JSON.stringify(queryJson)
                },
                async:true,
                dataType:'json',
                success: function(data){
                    if(data.code == "0000"){
                        //默认调到当前页面
                        array.splice(0, array.length); //清空数组
                        initPayeeRepairList(config.pageNo);
                    }else{
                        alert("领款人维修厂删除失败");
                    }
                },
                error:function(){
                    alert("领款人维修厂删除失败");
                }
            });
        }
    }else{
        alert("请选择一个维修厂进行删除");
    }
});



/**
 * 每个复选框的点击事件
 */
function eachclick(){
    var val=$(this).val();
    if($(this).is(':checked')){
        array.push(val);
    }else{
        array = jQuery.grep(array, function(value) {
            return value != val;
        });
    }
}
/**
 * 资源搜索查询
 */
$("#repairQuery").click(function(){
    //校验输入项
    initPayeeRepairList(1);
});

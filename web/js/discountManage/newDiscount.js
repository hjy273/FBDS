$("#stareDate").datetimepicker({/*开始时间*/
    format: "yyyy-mm-dd",
    autoclose: true,
    todayBtn: true,
    language: 'zh-CN',//中文，需要引用zh-CN.js包
    startView: 2,//月视图
    minView: 2//日期时间选择器所能够提供的最精确的时间选择视图
}).on('changeDate',function(e){
    var startTime = e.date;
    $('#endDate').datetimepicker('setStartDate',startTime);
    var endTime=$("#endDate").val();
    var oDate1 = new Date($("#stareDate").val());
    var oDate2 = new Date(endTime);
    if (oDate1.getTime() > oDate2.getTime()){
        $("#endDate").val($("#stareDate").val());
    }
});

var productCommonTipFun = function (tips) {//公共提示文字方法
    $("#commonTipsBox").html(tips);
    $("#commonTipsBox").fadeIn(200);
    setTimeout(function(){
        $("#commonTipsBox").fadeOut(200);
    },2000)
}

$("#endDate").datetimepicker({/*结束时间*/
    format: "yyyy-mm-dd",
    autoclose: true,
    todayBtn: true,
    language: 'zh-CN',//中文，需要引用zh-CN.js包
    startView: 2,//月视图
    minView:2//日期时间选择器所能够提供的最精确的时间选择视图
});

  $(".tcdPageCode").createPage({/*分页*/
    pageCount:5,
    current:1,
    backFn:function(p){
        /*  alert(p);*/
        //单击回调方法，p是当前页码
    }
});

var changeVaule;
$("#sureSelectBtn").on("click",function(){
    $("input[name=chooseRadio]").each(function(){
        if($(this).is(':checked')){
            console.log($(this).attr("data"))
            $("#chooseUserRange").slideUp(200);
            $("#whichSelect").html("您选择的"+changeVaule+"是："+"<label>"+$(this).parent().next().html()+"</label>")
        }
    })
    if($("input[name=chooseRadio]:checked").size()==0){
        productCommonTipFun("请选择具体使用范围")
    }
})

$("#userAddress").on("change",function(){
    changeVaule = $(this).find("option:selected").text();
    $("#chooseUserRangeTitle").html(changeVaule);
    $("#chooseUserRange").slideDown(200);
})

/* 推广方式 */
var ifChooseWay = true;
$(".selectStarAndEndTime").on("click",function(){
    if(ifChooseWay){
        $(this).addClass("chooseProductImg");
        ifChooseWay = false;
    }else{
        $(this).removeClass("chooseProductImg");
        ifChooseWay = true;
    }
})


/*点击保存按钮*/

$(".saveNewDiscountBtn").on("click",function(){
    var myFullString={
    discountName:$("#discountName").val(),
    discountType:$("#discountType").find("option:selected").text(),
    whichSelect:$("#whichSelect").html(),
    discountDenomination:$("#discountDenomination").val(),
    discountTotalNumber:$("#discountTotalNumber").val(),
    discountLimit:$("#discountLimit").val(),
    stareDate:$("#stareDate").val(),
    endDate:$("#endDate").val(),
    userTerm:$("#userTerm").val()
}
    if(myFullString.discountName==""){
        productCommonTipFun("请输入优惠券名称")
    }else if(myFullString.discountType=="请选择"){
        productCommonTipFun("请选择优惠券类型")
    }else if(myFullString.whichSelect==""){
        productCommonTipFun("请选择使用范围")
    }else if(myFullString.discountDenomination==""){
        productCommonTipFun("请输入面额")
    }else if(myFullString.discountTotalNumber==""){
        productCommonTipFun("请输入发行总量")
    }else if(myFullString.discountLimit==""){
        productCommonTipFun("请输入人均限领")
    }else if(myFullString.stareDate==""){
        productCommonTipFun("请选择开始时间")
    }else if(myFullString.endDate==""){
        productCommonTipFun("请选择结束时间")
    }else if(myFullString.userTerm==""){
        productCommonTipFun("请输入使用条件")
    }else{
        console.log("可以了")
    }
})
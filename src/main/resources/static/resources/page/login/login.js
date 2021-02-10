layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer;
        $ = layui.jquery;

    $(".loginBody .seraph").click(function(){
        layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样登录的？还是老老实实的找管理员去注册吧",{
            time:5000
        });
    });

    //登录按钮
    form.on("submit(login)",function(data){
        var btn =  $(this);
        //设置登录按钮  为不可点击
        btn.text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
        $.post("/login/login",data.field,function(rs){
            //设置登录按钮 恢复可点击   在前端防止 重复点击
            btn.text("登录").attr("disabled",false).removeClass("layui-disabled");
            layer.msg(rs.msg);
            if(rs.code != 200){
                layer.msg(rs.msg);
            }else{
                //跳转到templates/system/index/index.html页面
                layer.msg(rs.msg);
                location.href="/sys/index";
            }
        });
        return false;
    });

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    });
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    });
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
});

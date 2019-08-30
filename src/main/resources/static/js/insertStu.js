layui.use(['form'], function() {
  var form = layui.form;
});

$(function() {
  // 提交
  $('#submit').click(function(e) {
    e.preventDefault();
    var studentSno = $.trim($('input[name=\'sno\']').val());
    var studentName = $.trim($('input[name=\'name\']').val());
    var studentPassword = $.trim($('input[name=\'password\']').val());
    var studentAge = $.trim($('input[name=\'age\']').val());
    var studentQq = $.trim($('input[name=\'qq\']').val());
    var professionId = $.trim($('select[name=\'professionId\']').val());
    var studentSex = $.trim($('select[name=\'sex\']').val());
    var studentEmail =$.trim($('input[name=\'email\']').val());
    var student={
      studentName:studentName,
      studentSno:studentSno,
      studentSex:studentSex,
      studentPassword:studentPassword,
      studentAge:studentAge,
      studentQq:studentQq,
      studentEmail:studentEmail,
      professionId:professionId
    };
    $.ajax({
      url:'/studentApi//insertStudent',
      dataType:'json',
      type:'post',
      data:JSON.stringify(student),
      contentType: 'application/json; charset=utf-8',
      success:function(data) {
        if(data.body==1){
          layer.alert('添加学生成功',function() {
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            window.parent.location.reload();
            parent.layer.close(index); //再执行关闭
          });
        }else{
          layer.alert('添加学生失败',function() {
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            window.parent.location.reload();
            parent.layer.close(index); //再执行关闭
          });
        }
      }
    });
  });
});

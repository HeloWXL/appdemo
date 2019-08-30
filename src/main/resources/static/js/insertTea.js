layui.use(['form'], function() {
  var form = layui.form;

});


$(function() {

  // 提交
  $('#submit').click(function(e) {
    e.preventDefault();
    var teacherNo = $.trim($('input[name=\'teacherNo\']').val());
    var teacherName = $.trim($('input[name=\'teacherName\']').val());
    var teacherAge = $.trim($('input[name=\'teacherAge\']').val());
    var teacherPassword = $.trim($('input[name=\'teacherPassword\']').val());
    var sex = $.trim($('select[name=\'sex\']').val());
    var professionId = $.trim($('select[name=\'professionId\']').val());
    var teacherJobTitle = $.trim($('select[name=\'teacherJobTitle\']').val());


    var teacher={
      teacherName:teacherName,
      teacherTno:teacherNo,
      teacherPassword:teacherPassword,
      teacherJobTitle:teacherJobTitle,
      teacherSex:sex,
      teacherAge:teacherAge,
      professionId:professionId
    };

    $.ajax({
      url:'/teacherApi//insertTeacher',
      dataType:'json',
      type:'post',
      data:JSON.stringify(teacher),
      contentType: 'application/json; charset=utf-8',
      success:function(data) {
        if(data.body==1){
          layer.alert('添加教师成功',function() {
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            window.parent.location.reload();
            parent.layer.close(index); //再执行关闭
          });
        }else{
          alert('添加教师失败',function() {
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
          });
        }
      }
    });


  });

});

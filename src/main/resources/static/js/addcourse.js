mui.init();
$(function() {
  var teacherId = '';
  $.ajax({
    url: '/teacherApi/getTeacherSession',
    data: {teacherBean: 'teachersession'},
    dataType: 'json',
    type: 'post',
    async:false,
    success: function(data) {

      if (data.body == null) {
        mui.alert('用户未登录', function() {
          location.href = '/toTeaLogin';
        });
      }else{
        $('#teacherName').val(data.body.teacherName);
        teacherId = data.body.teacherId;
        return teacherId;
      }


    }
  });
  var professionList = [{
    value: '1',
    text: '信息管理与信息系统'
  }, {
    value: '2',
    text: '计算机科学与技术'
  }, {
    value: '3',
    text: '物联网'
  }, {
    value: '4',
    text: '大数据科学与技术'
  }];
  var dateList = [{
    value: '1',
    text: '星期一'
  }, {
    value: '2',
    text: '星期二'
  }, {
    value: '3',
    text: '星期三'
  }, {
    value: '4',
    text: '星期四'
  }, {
    value: '5',
    text: '星期五'
  }];
  $('#startTime').click(function() {
    var $dom = $('#startTime');
    dateSelect($dom);
  });
  $('#endTime').click(function() {
    var dom1 = $('#endTime');
    dateSelect(dom1);
  });
  // 专业选择
  var Picker = new mui.PopPicker();
  Picker.setData(professionList);
  prefession.addEventListener('tap', function(event) {
    var $dom  = $(this);
    Picker.show(function(items) {
      var vals = items[0].text;
      var name = items[0].value;
      $dom.val(vals);
      $dom.attr('name',name);
    });
  }, false);
  // 上课时间选择
  var DatePicker = new mui.PopPicker();
  DatePicker.setData(dateList);
  var btn = document.getElementById('dateSelect');
  btn.addEventListener('tap', function(event) {
    var $dom  = $(this);
    DatePicker.show(function(items) {
      var vals = items[0].text;
      var name = items[0].value;
      $dom.val(vals);
      $dom.attr('name',name);
    });
  }, false);
  // 提交
  $('#submit').click(function() {
    var courseName = $('#courseName').val();
    var classarrangement = $('#dateSelect').attr('name');
    var starttime = $('#startTime').val();
    var endtime = $('#endTime').val();
    var profession = $('#prefession').attr('name');
    var course  = {
      courseName:courseName,
      classarrangement:classarrangement,
      starttime:getDate(starttime),
      endtime:getDate(endtime),
      profession:profession,
      teacherId:teacherId
    };

    $.ajax({
      url:'/courseApi/insertCourse',
      data:JSON.stringify(course),
      dataType:'json',
      type:'post',
      contentType: 'application/json; charset=utf-8',
      success:function(data) {
        if(data.body==1){
          mui.alert('提交成功',function() {
            history.back(-1);
          });
        }else{
          mui.alert('提交失败',function() {
            reset();
          });
        }
      }
    });
  });




//字符串转日期格式，strDate要转为日期格式的字符串
  function getDate(strDate) {
    var date = eval('new Date(' + strDate.replace(/\d+(?=-[^-]+$)/,
        function (a) { return parseInt(a, 10) - 1; }).match(/\d+/g) + ')');
    return date;
  }





  // 时间选择
  function dateSelect(dom) {
    var $a = dom;
    var Date = new mui.DtPicker({
      type: 'month'
    });
    Date.show(function(item) {
      //这里你可以用console 看看回调函数中的item的值
      var endDate = item.y.text + '-' + item.m.text;
      $a.val(endDate);
    });
  }
});

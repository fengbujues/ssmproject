<%--
  Created by IntelliJ IDEA.
  User: 刘洋
  Date: 2019/3/2
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <style>
        /*td{*/
            /*width: 25%;*/
        /*}*/
    </style>
</head>
<script>
    <%--待编辑的用户--%>
    var editjson
    $(document).ready(function () {
        var page = 1
        var count = 0
        var maxpage = 0

        //分页提交查询
        function Post(){
            $.post(
                "/user/limitquery.form",
                {"page":page},
                function (result) {
                    $("table").empty()
                    for (var i = 0; i < result.length; i++) {
                        $("table").append("<tr><td>"+result[i].id+"</td><td>"+result[i].name+"</td><td>"+result[i].age+"</td><td>"+result[i].tel+"</td>" +
                            "<td>"+result[i].address+"</td><td><a href='#' data-toggle=\"modal\" data-target=\"#deletemodal\" onclick='Delete("+result[i].id+")'><i class=\"fa fa-trash\" aria-hidden=\"true\"></i></a></td>" +
                            "<td><a href='#' data-toggle=\"modal\" data-target=\"#editmodal\" onclick='Edit("+result[i]+")'><i class=\"fa fa-edit\" aria-hidden=\"true\"></i></a></td></tr>")
                    }
                }
            )
        }
        //加载页面后查询
        Post()

        //得到最大页数
        $.post(
            "/user/count.form",
            function (result) {
                count = result
                if(count%3==0){
                    maxpage=count/3
                }else{
                    maxpage=parseInt(count/3+1)
                }
            }
        )
        $("#next").click(function () {
            page++
            if(page > maxpage){
                page = maxpage
                alert("这已经是最后一页！")
            }else {
                Post()
            }
        })
        $("#last").click(function () {
            page--
            if(page < 1){
                page = 1
                alert("这已经是第一页!")
            }else{
               Post()
            }
        })

        $("#first").click(function () {
            page = 1
            Post()
        })

        $("#end").click(function () {
            page = maxpage
            Post()
        })

    })
</script>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand/logo -->
    <a class="navbar-brand" href="#">Linkman</a>

    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="#" data-toggle="modal" data-target="#mymodal">添加联系人</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">查看联系人</a>
        </li>
        <span class="navbar-text">
            Creat By LY
        </span>
    </ul>
</nav>
<span class="h2 text-center">登陆成功</span>
<div class="user text-success"></div>
<div class="container">
    <table class="table table-bordered table-striped table-hover">
    </table>
    <button class="btn btn-sm" id="first">首页</button>
    <button class="btn btn-sm" id="last">上一页</button>
    <button class="btn btn-sm" id="next">下一页</button>
    <button class="btn btn-sm" id="end">尾页</button>
</div>

<%--&lt;%&ndash;写一个简单的模态框&ndash;%&gt;--%>
<%--<div class="modal fade" id="your">--%>
    <%--<div class="modal-dialog">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<h3>添加</h3>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<%--<button class="btn btn-primary" data-toggle="modal" data-target="#your">打开模态框</button>--%>

<%--添加信息的模态框--%>
<div class="modal fade" id="mymodal">
    <div class="modal-dialog">
        <div class="modal-content">
            <form class="form-control">
                <div class="modal-header">
                    <h4 class="modal-title">添加联系人</h4>
                    <button class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <label class="">名称:</label>
                        <input type="text" class="form-control" name="name"/>
                        <label>年龄:</label>
                        <input type="text" class="form-control" name="age"/>
                        <label>电话号码:</label>
                        <input type="text" class="form-control" name="tel"/>
                        <label>家庭住址:</label>
                        <input type="text" class="form-control" name="address"/>
                            <input type="submit" class="btn btn-primary mt-3" id="addLinkman" value="添加">
                    </div>
                </div>
                <%--<div class="modal-footer container">--%>
                    <%--<input type="submit" value="提交" class="btn btn-primary">--%>
                    <%--<button class="btn" data-dismiss="modal">关闭</button>--%>
                <%--</div>--%>
            </form>
        </div>
    </div>
</div>


<%--删除的模态框--%>
<div class="modal fade" id="deletemodal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">确认删除？</h4>
                <button class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body text-center">
                <button class="btn btn-danger mr-3 delSure" data-dismiss="modal">确认</button>
                <button class="btn btn-primary" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

<%--编辑的模态框--%>
<div class="modal fade" id="editmodal">
    <div class="modal-dialog">
        <div class="modal-content">
            <form class="form-control">
                <div class="modal-header">
                    <h4 class="modal-title">编辑联系人</h4>
                    <button class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <label class="">名称:</label>
                        <input type="text" class="form-control name" name="name"/>
                        <label>年龄:</label>
                        <input type="text" class="form-control age" name="age"/>
                        <label>电话号码:</label>
                        <input type="text" class="form-control tel" name="tel"/>
                        <label>家庭住址:</label>
                        <input type="text" class="form-control address" name="address"/>
                        <input type="submit" class="btn btn-primary mt-3" id="editLinkman" value="编辑">
                    </div>
                </div>
                <%--<div class="modal-footer container">--%>
                <%--<input type="submit" value="提交" class="btn btn-primary">--%>
                <%--<button class="btn" data-dismiss="modal">关闭</button>--%>
                <%--</div>--%>
            </form>
        </div>
    </div>
</div>

<%--<button class="btn btn-primary" data-toggle="modal" data-target="#mymodal">打开</button>--%>
</body>
<script>
$("#addLinkman").click(function () {
    var name = $("[name='name']").val()
    var age = $("[name='age']").val()
    var tel = $("[name='tel']").val()
    var address = $("[name='address']").val()
    // alert(name)
    $.post(
        "/user/AddLinkman.form",
        {"name":name,"age":age,"tel":tel,"address":address},
        function () {
            // alert("添加成功")
        }
    )
})
//删除用户的方法
    function Delete(id) {
        if(!id){
            alert("error")
        }else{
            $(".delSure").click(function () {
                $.post(
                    "/user/deleteLinkmanByid.form",
                    {"id":id},
                    function (result) {
                        // alert("删除成功")
                        $("body").html(result)
                    }
                )
            })
        }
    }
    //编辑用户的方法
    function Edit(json) {
        // alert(json)
        console.log(json.name)
        // $("#editLinkman").parent()
        var name = $("[name='name']").val(json.name)
        var age = $("[name='age']").val(json.age)
        var tel = $("[name='tel']").val(json.tel)
        var address = $("[name='address']").val(json.address)
    }
</script>
</html>

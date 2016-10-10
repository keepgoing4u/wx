<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我是自定义文章页面</title>
</head>
<style>
    div{
        text-align: center;
    }
    div a{
        color: red;
    }
</style>

<body>
    <div>
        <a href="#">文章1</a> <br>
    </div>
    <div>
        <a href="#">文章2</a> <br>
    </div>
    <div>
        <a href="#">文章3</a> <br>
    </div>
    <div>
        <a href="#">文章4</a> <br>
    </div>
    <div>
        <a href="#">文章5</a> <br>
    </div>
    <div>
        <a href="#">文章6</a> <br>
    </div>
</body>
<script>
//    var a = document.getElementById("aaa");
//    a.addEventListener("onclick", sss,false);


    window.onload=function(){
        var Aarray = document.getElementsByTagName("a");

        function aaa(){
            window.location="http://www.baidu.com";
        }

        function each(Aarray) {
            for(var i=0; i<Aarray.length; i++){
                var obj = Aarray[i];
                obj.addEventListener("click",aaa);
            }
        }
        each(Aarray);
    }


</script>
</html>

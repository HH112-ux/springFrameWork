<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSM整合 - 学生管理系统</title>
    <style>
        body { font-family: "Microsoft YaHei", sans-serif; background: #f5f5f5; margin: 0; padding: 40px; }
        .container { max-width: 600px; margin: 0 auto; background: #fff; padding: 40px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); text-align: center; }
        h1 { color: #333; margin-bottom: 30px; }
        .btn { display: inline-block; padding: 12px 30px; background: #409eff; color: #fff; text-decoration: none; border-radius: 4px; font-size: 16px; }
        .btn:hover { background: #66b1ff; }
    </style>
</head>
<body>
    <div class="container">
        <h1>学生管理系统</h1>
        <br/>
        <a href="${pageContext.request.contextPath}/student/list" class="btn">进入学生管理</a>
    </div>
</body>
</html>

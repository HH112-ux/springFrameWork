<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增学生</title>
    <style>
        body { font-family: "Microsoft YaHei", sans-serif; background: #f5f5f5; margin: 0; padding: 40px; }
        .container { max-width: 500px; margin: 0 auto; background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        h2 { color: #333; margin-top: 0; }
        .form-item { margin-bottom: 20px; }
        label { display: block; margin-bottom: 8px; color: #606266; font-size: 14px; }
        input[type="text"], input[type="number"], select {
            width: 100%; padding: 10px; border: 1px solid #dcdfe6; border-radius: 4px;
            font-size: 14px; box-sizing: border-box;
        }
        input:focus, select:focus { outline: none; border-color: #409eff; }
        .btn-row { margin-top: 30px; text-align: right; }
        .btn { padding: 10px 24px; border: none; border-radius: 4px; font-size: 14px; cursor: pointer; }
        .btn-submit { background: #409eff; color: #fff; }
        .btn-cancel { background: #fff; color: #606266; border: 1px solid #dcdfe6; margin-right: 10px; text-decoration: none; display: inline-block; }
    </style>
</head>
<body>
    <div class="container">
        <h2>新增学生</h2>
        <form action="${pageContext.request.contextPath}/student/add" method="post">
            <div class="form-item">
                <label>姓名</label>
                <input type="text" name="name" required placeholder="请输入姓名">
            </div>
            <div class="form-item">
                <label>年龄</label>
                <input type="number" name="age" required min="1" max="150" placeholder="请输入年龄">
            </div>
            <div class="form-item">
                <label>性别</label>
                <select name="gender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <div class="btn-row">
                <a href="${pageContext.request.contextPath}/student/list" class="btn btn-cancel">取消</a>
                <button type="submit" class="btn btn-submit">提交</button>
            </div>
        </form>
    </div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生列表</title>
    <style>
        body { font-family: "Microsoft YaHei", sans-serif; background: #f5f5f5; margin: 0; padding: 40px; }
        .container { max-width: 800px; margin: 0 auto; background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        h2 { color: #333; margin-top: 0; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: center; border-bottom: 1px solid #eee; }
        th { background: #f8f9fa; color: #606266; font-weight: normal; }
        tr:hover { background: #f5f7fa; }
        .btn { display: inline-block; padding: 6px 16px; text-decoration: none; border-radius: 4px; font-size: 14px; }
        .btn-add { background: #67c23a; color: #fff; }
        .btn-edit { background: #e6a23c; color: #fff; }
        .btn-delete { background: #f56c6c; color: #fff; }
        .btn-back { background: #909399; color: #fff; }
        .toolbar { margin-bottom: 20px; }
        .empty { text-align: center; color: #909399; padding: 40px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>学生列表</h2>
        <div class="toolbar">
            <a href="${pageContext.request.contextPath}/student/toAdd" class="btn btn-add">+ 新增学生</a>
            <a href="${pageContext.request.contextPath}/" class="btn btn-back">返回首页</a>
        </div>

        <c:if test="${empty students}">
            <div class="empty">暂无数据，请点击"新增学生"添加</div>
        </c:if>

        <c:if test="${not empty students}">
        <table>
            <thead>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.age}</td>
                    <td>${s.gender}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/student/toEdit?id=${s.id}" class="btn btn-edit">编辑</a>
                        <a href="${pageContext.request.contextPath}/student/delete?id=${s.id}"
                           class="btn btn-delete"
                           onclick="return confirm('确定要删除 ${s.name} 吗？')">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </c:if>
    </div>
</body>
</html>

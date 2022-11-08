<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>登陆页面</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            font-size: 16px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        #index table {
            width: 500px;
            margin: 0 auto;
        }

        #index table th {
            font-size: 36px;
        }

        #index table tr {
            background-color: white;
        }

        #index table tr > td {
            text-align: right;
        }

        #index table tr > td + td {
            text-align: left;
        }

        #index #submit1 {
            text-align: center;
        }

        #index #submit1 input {
            border: 0;
            font-size: 20px;
        }
    </style>
</head>
<body id="index">
<div>
    <form action="LoginServlet" method="post">
        <table>
            <th colspan="2">
                会员登录界面
            </th>
            <tr>
                <td>用户邮箱登录：</td>
                <td><input type="text" name="memberEmail"/></td>
            </tr>
            <tr>
                <td>用户登录密码：</td>
                <td><input type="password" name="memberPassword"/></td>
            </tr>
            <tr>
                <td colspan="2" id="submit1">
                    <button type="submit">提交</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>